import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';
@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
  title="";
  price=0;
  id=0;
  days="None";
l=false;

  name="";
  card="";
  cvv="";
  date="";
submit(){
  if(this.name&&this.card&&this.cvv&&this.date){
    let id:number=this.dataService.getLocalStorage("id");
  let bookId:number=this.dataService.getLocalStorage("bookId");
    this.dataService.addReadingList(id,bookId).subscribe((data:any)=>{
       alert("Payment success");
    },
    (error) => {
      alert("The Book Already Added to your Reading List");
      console.error(error);
    })
   
  }
}
  constructor(private route: ActivatedRoute,private dataService:DataService) {
    this.route.params.subscribe(params => {
      this.title = params['title'];
      this.price = params['price'];
      this.id = params['id'];
     if(this.id){
this.l=true
      this.price = Math.floor(this.price/7 );
      this.days="One week";
     }
    });
  }
}
