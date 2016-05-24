package mum.scrum.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import mum.scrum.model.UserStory;
import mum.scrum.repository.UserStoryRepository;
import mum.scrum.service.UserStoryService;

@Service
public class UserStoryServiceImp implements UserStoryService {

	@Autowired
	UserStoryRepository userStoryRepository;

	public UserStoryServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean saveUserStory(UserStory userStory) {
		// TODO Auto-generated method stub
		if (userStoryRepository.save(userStory) != null) {
			return true;
		}
		return false;
	}

	public List<UserStory> findAllUserStory() {
		// TODO Auto-generated method stub
		return userStoryRepository.findAll();
	}

	public UserStory findUserStoryById(int id) {
		// TODO Auto-generated method stub
		return userStoryRepository.findOne(id);
	}

	public boolean updateUserStory(UserStory userStory) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteUserStory(int id) {
		userStoryRepository.delete(id);
	}
	
	
}
