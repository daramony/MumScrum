package mum.scrum.service;


import mum.scrum.model.Release;
import mum.scrum.model.UserStory;
import mum.scrum.repository.ReleaseRepository;
import mum.scrum.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ishwor on 11/12/15.
 */
public interface ReleaseService {

    public boolean saveRelease(Release release);

    public List<Release> findAllRelease();

    public Release findReleaseById(int id);


    public boolean updateRelease(Release sprint);

    public void deleteRelease(int id);


}
