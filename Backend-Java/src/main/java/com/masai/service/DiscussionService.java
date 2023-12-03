package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Chat;
import com.masai.model.Discussions;
import com.masai.model.Users;
import com.masai.repository.DiscussionRepository;
import com.masai.repository.UserRepository;
@Service
public class DiscussionService implements DiscussionServiceInterface{
	@Autowired
private DiscussionRepository discussionRepository;
	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public Discussions createDiscussion(Integer userId, Discussions discussion) {
		Optional<Users> user=UserRepository.findById(userId);
		
		discussion.setUser(user.get());
		discussionRepository.save(discussion);
		return discussion;
	}
	
	@Override
	public Discussions createChat( Chat chat, Integer discussionsId, Integer userId) {
		Optional<Users> user=UserRepository.findById(userId);
		Optional<Discussions> d =discussionRepository.findById(discussionsId);
		Discussions discussion=d.get();
		chat.setUser(user.get());
		discussion.getChat().add(chat);
		discussionRepository.save(discussion);
		return discussion;
	}

	@Override
	public List<Discussions> getAllDiscussions() {
		List<Discussions> list=discussionRepository.findAll();
		return list;
	}

	@Override
	public Discussions deleteDiscussions(Integer discussionsId) {
		Optional<Discussions> d =discussionRepository.findById(discussionsId);
		Discussions discussion=d.get();
		discussion.setChat(null);
		discussion.setUser(null);
		discussionRepository.save(discussion);
		discussionRepository.delete(discussion);
		return discussion;
	}

	@Override
	public List<Chat> getChat(Integer discussionsId) {
		Optional<Discussions> d =discussionRepository.findById(discussionsId);
		Discussions discussion=d.get();
		return discussion.getChat();
	}

}
