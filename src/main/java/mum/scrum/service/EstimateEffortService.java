package mum.scrum.service;

import java.util.List;

import mum.scrum.model.Employee;
import mum.scrum.model.UserStory;

public interface EstimateEffortService {

	public List<UserStory> findUserStoryByDev(int userId);
	
	public List<UserStory> findUserStoryByTester(int userId);
	
	public int findIdByUserName(String userId);
	
	public boolean estimateEffortDeveloper(int uid, int eid, int effort);
	
	public boolean estimateEffortTester(int uid, int eid, int effort);
	
}

