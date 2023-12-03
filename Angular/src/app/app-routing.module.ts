import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DisplayBooksComponent } from './display-books/display-books.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { DiscussionComponent } from './discussion/discussion.component';
import { MyBooksComponent } from './my-books/my-books.component';
import { HomeComponent } from './home/home.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { DiscussionChatComponent } from './discussion-chat/discussion-chat.component';
import { ChatBotComponent } from './chat-bot/chat-bot.component';
import { PaymentComponent } from './payment/payment.component';

const routes: Routes = [
  {component:DisplayBooksComponent,path:"books/:id"},
  {component:LoginComponent,path:"login"},
  {component:SignupComponent,path:"login/signup"},
  {component:LoginComponent,path:"login/signup/login"},
  {component:DiscussionComponent,path:"dis"},
  {component:MyBooksComponent,path:"MyBooks"},
  {component:UserProfileComponent,path:"userProfile"},
  {component:ChatBotComponent,path:"chat"},
  {component:DiscussionChatComponent,path:"dis/chat/:id/:name/:title/:uId"},
  {component:PaymentComponent,path:"payment/:title/:price"},
  {component:PaymentComponent,path:"payment/:title/:price/:id"},
  {component:HomeComponent,path:""},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
