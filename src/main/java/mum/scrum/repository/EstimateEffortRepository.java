package mum.scrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mum.scrum.model.Employee;
import mum.scrum.model.UserStory;

@Repository
public interface EstimateEffortRepository extends JpaRepository<UserStory, Integer>  {
	

	@Query("SELECT e FROM UserStory e WHERE e.developer_id = :userId")
    public List<UserStory> findUserStoryByDev(@Param("userId") int userId);

	@Query("SELECT e FROM UserStory e WHERE e.tester_id = :userId")
    public List<UserStory> findUserStoryByTester(@Param("userId") int userId);

	@Query("SELECT e.id FROM Employee e where e.userId = :userId")
    public int findIdByUserName(@Param("userId") String userId);

	@Modifying
	@Transactional
	@Query("update UserStory a set a.devEffort=? where a.developer_id=? and a.id=?")
	public void estimateDeveloperEffortInUserStory(int effort, int did, int uid);
	
	@Modifying  
	@Transactional
	@Query("update UserStory a set a.testEffort=? where a.tester_id=? and a.id=?")
	public void estimateTesterEffortInUserStory(int effort, int tid, int uid);
	
}
