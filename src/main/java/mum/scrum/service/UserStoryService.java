package mum.scrum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mum.scrum.model.UserStory;


public interface UserStoryService {
	 public boolean saveUserStory(UserStory userStory);

	    public List<UserStory> findAllUserStory();

	    public UserStory findUserStoryById(int id);

	    public boolean updateUserStory(UserStory userStory);
	    
	    public void deleteUserStory(int id);
}
