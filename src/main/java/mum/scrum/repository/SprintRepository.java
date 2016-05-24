package mum.scrum.repository;

import mum.scrum.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ishwor on 11/11/15.
 */
@Repository
public interface  SprintRepository extends JpaRepository<Sprint,Integer> {
}
