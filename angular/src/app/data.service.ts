import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private apiUrl = "https://library-management-system-production-f1f3.up.railway.app";
  // private apiUrl =  "http://localhost:8080";
constructor(private http: HttpClient) {
  console.log("service")
  this.checkloginJava();
 } 

 
 // check Login Java
checkloginJava(){
let jwt= this.getLocalStorage("key");
  // const headers = new HttpHeaders({
  //   'Content-Type': 'application/json',
  //   'Authorization': 'Bearer ' + jwt
  // });
  // this.http.get(`${this.apiUrl}/loginCheck`,{ headers: headers, observe: 'response' }).subscribe((data:any)=>{
  //   console.log("setLogin")
  if(jwt!=null){
    this.setLogin();
  }
  // },) 
}

Books:any[]=[];

isLogin=false;

setArr(book:any[]) {
this.Books=book;
}
checkLogin(){
  return this.isLogin;
}

getArr(){
  return this.Books;
  }

getAllBooks(){
    return this.http.get(`${this.apiUrl}/books`);
  }
  signUp(user:any): Observable<any>{
    return this.http.post(`${this.apiUrl}/users`, user);
  }
  setLogin(){
    this.isLogin=true;
  }
   // login
  login(username: string, password: string): Observable<any> {
  const base64Credentials = btoa(`${username}:${password}`);
  // Set the Authorization header
  const headers = new HttpHeaders({
    'Authorization': 'Basic ' + base64Credentials
  });
  return this.http.get(`${this.apiUrl}/logini`,{ headers: headers, observe: 'response' });
  }
// add Book to wishList
addWishList(userId:number,bookId:number): Observable<any> {
 let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  let wish={
    mes:"User"
  }
  return this.http.put(`${this.apiUrl}/users/wishList/${userId}/${bookId}`,wish,{ headers: headers, observe: 'response' });
}
// add Book to Reading List
addReadingList(userId:number,bookId:number) {
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.get(`${this.apiUrl}/users/ReadingList/${userId}/${bookId}`,{ headers: headers, observe: 'response' });
}
// set data to local storage
  saveLocalStorage(key: string, value: any): void {
    localStorage.setItem(key, JSON.stringify(value));
  }
  //remove data from local storage
  removeDataLocalStorage(){
    localStorage.clear();
    this.isLogin=false;
  }
  // Get data from local storage
getLocalStorage(key: string): any {
  const storedValue = localStorage.getItem(key);
return storedValue ? JSON.parse(storedValue) : null; 
}
// Get User By UserId
getUser(userId:any): Observable<any>{
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.get(`${this.apiUrl}/users/${userId}`,{ headers: headers, observe: 'response' });
}
// post review
postReview(bookId:any,userId:any,requestBody:any): Observable<any>{
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.put(`${this.apiUrl}/books/rating/${bookId}/${userId}`,requestBody,{ headers: headers, observe: 'response' });
}
// get review
getReview(bookId:any): Observable<any>{
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.get(`${this.apiUrl}/books/rating/${bookId}`,{ headers: headers, observe: 'response' });
}
//create Discussion
createDiscussion(title:any,userId:any) {
  let jwt= this.getLocalStorage("key");
  let discussion={
    title:title
  }
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.post(`${this.apiUrl}/discussions/${userId}`,discussion,{ headers: headers, observe: 'response' });
}
//get All Discussion
getAllDiscussion() {
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.get(`${this.apiUrl}/discussions`,{ headers: headers, observe: 'response' });
}
//get readingList
getReadingList(id:any) {
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.get(`${this.apiUrl}/users/ReadingList/${id}`,{ headers: headers, observe: 'response' });
}
//get wishList
getWishList(id:any) {
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.get(`${this.apiUrl}/users/wishList/${id}`,{ headers: headers, observe: 'response' });
}
//send Chat 
sendChat(id:any,userId:any,message:any) {
  let jwt= this.getLocalStorage("key");

  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.put(`${this.apiUrl}/discussions/chat/${id}/${userId}`,message,{ headers: headers, observe: 'response' });
}

//get Chat 
getChat(id:any) {
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.get(`${this.apiUrl}/discussions/chat/${id}`,{ headers: headers, observe: 'response' });
}

// chat Bot
chatBot(message:any) {
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.get(`${this.apiUrl}/chat?prompt=${message}`,{ headers: headers, observe: 'response' });
}

// delete discussion
deleteDiscussion(discussionId:any){
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.delete(`${this.apiUrl}/discussions/${discussionId}`,{ headers: headers, observe: 'response' });
}

// delete Book from wishList
deleteBookFromWishList(userId:any,bookId:any){
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.delete(`${this.apiUrl}/users/wishList/${userId}/${bookId}`,{ headers: headers, observe: 'response' });
}

// search Books
searchBook(by:any,name:any){
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.get(`${this.apiUrl}/search/byAuthor/${name}`,{ headers: headers, observe: 'response' });
}
// mail
mail(email:any){
  let jwt= this.getLocalStorage("key");
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + jwt
  });
  return this.http.post(`${this.apiUrl}/mail?email=${email}`,{ headers: headers, observe: 'response' });
}
}
