import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { DisplayBooksComponent } from './display-books/display-books.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { DiscussionComponent } from './discussion/discussion.component';
import { MyBooksComponent } from './my-books/my-books.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { DataService } from './data.service';
import { DiscussionChatComponent } from './discussion-chat/discussion-chat.component';
import { ChatBotComponent } from './chat-bot/chat-bot.component';
import { PaymentComponent } from './payment/payment.component';

@NgModule({
  declarations: [AppComponent, DisplayBooksComponent, LoginComponent, SignupComponent, DiscussionComponent, MyBooksComponent, UserProfileComponent, HomeComponent, DiscussionChatComponent, ChatBotComponent, PaymentComponent],
  imports: [BrowserModule, FormsModule, CommonModule, AppRoutingModule, HttpClientModule],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule {
 
 }