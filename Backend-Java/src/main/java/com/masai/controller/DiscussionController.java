package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Chat;
import com.masai.model.Discussions;
import com.masai.service.DiscussionServiceInterface;

@RestController
@CrossOrigin(origins = "*")
public class DiscussionController {
	@Autowired
	private DiscussionServiceInterface discussionServiceInterface;
	
@PostMapping("/discussions/{userId}")
public ResponseEntity<Discussions> createDiscussions(@PathVariable Integer userId,@RequestBody Discussions discussion){
	
	return new ResponseEntity<Discussions>(discussionServiceInterface.createDiscussion(userId,discussion),HttpStatus.CREATED);
}

@PutMapping("/discussions/chat/{discussionsId}/{userId}")
public ResponseEntity<Discussions> createChat(@RequestBody Chat chat,@PathVariable Integer discussionsId,@PathVariable Integer userId){
	
	return new ResponseEntity<Discussions>(discussionServiceInterface.createChat(chat,discussionsId,userId),HttpStatus.CREATED);
}

@GetMapping("/discussions")
public ResponseEntity<List<Discussions>> getAllDiscussions(){
	return new ResponseEntity<List<Discussions>>(discussionServiceInterface.getAllDiscussions(),HttpStatus.OK);
}

@DeleteMapping("/discussions/{discussionsId}")
public ResponseEntity<Discussions> deleteDiscussions(@PathVariable Integer discussionsId){
	return new ResponseEntity<Discussions>(discussionServiceInterface.deleteDiscussions(discussionsId),HttpStatus.OK);
}

@GetMapping("/discussions/chat/{discussionsId}")
public ResponseEntity<List<Chat>> getChat(@PathVariable Integer discussionsId){
	return new ResponseEntity<List<Chat>>(discussionServiceInterface.getChat(discussionsId),HttpStatus.OK);
}

}
