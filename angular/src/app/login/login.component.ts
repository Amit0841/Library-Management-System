import { Component } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email='';
  password='';
  error='';

arr:any=[];
constructor(private route:Router,private dataService:DataService){
}
  ngOnInit(): void {
  }

  Login() {
    this.error='';
    const emailRegex = /\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}\b/;
    if(!emailRegex.test(this.email)){
      this.error+='Email must be a proper format.';
    }else
    if(this.password.length<8){
      this.error+=' Password must be more than Eight characters.';
    }else{
      this.dataService.login(this.email,this.password).subscribe((res:any)=>{
        const token=res.headers.get("Authorization");
        
          this.dataService.saveLocalStorage("key",token);
        this.dataService.saveLocalStorage("id",res.body.userId);
        this.dataService.setLogin();
        alert("welcome "+res.body.name); 
        this.route.navigate([""]);  
    },(error) => {
      alert("Something Went Wrong");
      this.error="Email or password incorrect"; 
      console.error('Login error:', error);
    }
    )};
  }
  
}
