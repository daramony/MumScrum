package mum.scrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.scrum.model.UserStory;
@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Integer> {

	
}
