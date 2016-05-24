package mum.scrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mum.scrum.model.WorkLog;

@Repository
public interface WorkLogRepository extends JpaRepository<WorkLog, Integer> {

}
