import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-discussion',
  templateUrl: './discussion.component.html',
  styleUrls: ['./discussion.component.css']
})
export class DiscussionComponent implements OnInit{
  constructor(private dataService:DataService){}

  ngOnInit(): void {
    this.dataService.getAllDiscussion().subscribe((data:any)=>{
      this.discussion=data.body;
    })
  }

  title="";
  discussion:any[]=[];
  showInputAndButton =false;

  createDiscussion(){
this.showInputAndButton = true;
  }

  submit(){
    if(this.title&&this.dataService.checkLogin()){
      this.showInputAndButton = false;
      let userId=this.dataService.getLocalStorage("id");
      this.dataService.createDiscussion(this.title,userId).subscribe((data:any)=>{
      this.ngOnInit();
      alert(" The Discussion "+this.title+" Created");
      });
    }else{
      alert("Login First");
    }
  }
}
