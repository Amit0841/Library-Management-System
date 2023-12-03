import { Component } from '@angular/core';
import { DataService } from '../data.service';
@Component({
  selector: 'app-chat-bot',
  templateUrl: './chat-bot.component.html',
  styleUrls: ['./chat-bot.component.css']
})
export class ChatBotComponent {
  message='';
constructor(private dataService:DataService){

}
loading = false;
l=false;
item="";
charArr:any[]=[];
responceArr:any[]=[];
cancel(){
  this.loading = false;
}
  send(){
    if(this.message){
     this.l=true;
    this.item=this.message;
    this.loading = true;
    this.dataService.chatBot(this.message).subscribe((data:any)=>{
      
      this.responceArr.push(data.body.message);
      this.loading = false;
      this.message="";
      this.l=false;
console.log(this.responceArr);
    }) 
    }
    
  }
}
