package mum.scrum.repository;

import mum.scrum.model.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ishwor on 11/12/15.
 */
@Repository
public interface ReleaseRepository extends JpaRepository<Release,Integer> {
}
