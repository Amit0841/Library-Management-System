import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
import { User } from './User';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

    email='';
    password='';
    error='';
    userName='';
    mobile="";
  constructor(private route:Router,private taskServiceService:DataService){}
  veryfi=false;
  otp=1;
  newOTP="";
    register() {
      this.error='';
      const emailRegex = /\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}\b/;
      if(!emailRegex.test(this.email)){
        this.error+='Email must be a proper format.';
      }else if(this.password.length<8){
        this.error+=' Password must be more than Eight characters.';
      }else{
        
        this.error='We sent a four digit verification code in your email';
        this.taskServiceService.mail(this.email).subscribe((data:any)=>{
          this.otp=data.otp;
          this.veryfi=true;
        })
    
      }
    }
  
    sub(){
      let u=new User(this.email,this.password,this.userName,this.mobile);
      this.veryfi=false;
      const parsedString: number = parseInt(this.newOTP); 
      console.log(parsedString===this.otp);
      console.log(parsedString,this.otp);
if(parsedString===this.otp){
this.taskServiceService.signUp(u).subscribe((response: any) => {
        console.log('POST Request Response:', response);
         alert("Register Success you can login now");
      this.route.navigate(["login"]);
      });
}
    }
}
