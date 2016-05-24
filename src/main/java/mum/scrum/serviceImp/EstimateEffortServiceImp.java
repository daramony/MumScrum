package mum.scrum.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.scrum.model.Employee;
import mum.scrum.model.UserStory;
import mum.scrum.repository.EstimateEffortRepository;
import mum.scrum.service.EstimateEffortService;

@Service
public class EstimateEffortServiceImp implements EstimateEffortService {

	@Autowired
	EstimateEffortRepository estimateEffortRepository;	
	
	public List<UserStory> findUserStoryByDev(int userId){
		return estimateEffortRepository.findUserStoryByDev(userId);
	}
	
	public List<UserStory> findUserStoryByTester(int userId){
		return estimateEffortRepository.findUserStoryByTester(userId);
	}
	
	public int findIdByUserName(String userId){
		return estimateEffortRepository.findIdByUserName(userId);
	}
	
	public boolean estimateEffortDeveloper(int uid, int eid, int Effort) {
		estimateEffortRepository.estimateDeveloperEffortInUserStory(Effort, eid, uid);	
		return true;
	}	
	
	public boolean estimateEffortTester(int uid, int eid, int Effort) {
		estimateEffortRepository.estimateTesterEffortInUserStory(Effort, eid, uid);		
		return true;
	}
	
}
