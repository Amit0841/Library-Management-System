package com.masai.service;

import java.util.List;

import com.masai.model.Chat;
import com.masai.model.Discussions;

public interface DiscussionServiceInterface {

	Discussions createDiscussion(Integer userId, Discussions discussion);

	Discussions createChat(Chat chat, Integer discussionsId, Integer userId);

	List<Discussions> getAllDiscussions();

	Discussions deleteDiscussions(Integer discussionsId);

	List<Chat> getChat(Integer discussionsId);

}
