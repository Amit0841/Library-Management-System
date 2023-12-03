import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-discussion-chat',
  templateUrl: './discussion-chat.component.html',
  styleUrls: ['./discussion-chat.component.css']
})
export class DiscussionChatComponent implements OnInit{
  discussionsId=0;
title="";
name="";
uId=0;
loginUserId=0;
delete=false;
chat:any[]=[];

constructor(private route:ActivatedRoute,private dataService:DataService,private router:Router){
  this.route.params.subscribe(params => {
    this.discussionsId=params['id']; 
    this.title=params['name']; 
    this.name=params['title'];
    this.uId=params['uId'];
this.loginUserId= dataService.getLocalStorage("id");
  });
}
  ngOnInit(): void {
    this.dataService.getChat(this.discussionsId).subscribe((data:any)=>{
      this.chat=data.body
if(this.loginUserId==this.uId){
this.delete=true;
}
    })
  }
  message="";

  send(){
    if(this.message){
    let userId=this.dataService.getLocalStorage("id");
    let chat={
      message:this.message
    }
    this.dataService.sendChat(this.discussionsId,userId,chat).subscribe((data:any)=>{
      console.log(data.body);
      this.message="";
      this.ngOnInit();
    })
  }
  }

  deleteC(){
    this.dataService.deleteDiscussion(this.discussionsId).subscribe((data:any)=>{
      alert(this.title+" Deleted ");
      this.router.navigate(["dis"]);  
console.log(data);
    })
  }
}
