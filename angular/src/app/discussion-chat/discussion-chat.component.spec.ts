import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscussionChatComponent } from './discussion-chat.component';

describe('DiscussionChatComponent', () => {
  let component: DiscussionChatComponent;
  let fixture: ComponentFixture<DiscussionChatComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DiscussionChatComponent]
    });
    fixture = TestBed.createComponent(DiscussionChatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
