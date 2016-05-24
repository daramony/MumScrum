package mum.scrum.service;

import mum.scrum.model.Sprint;
import mum.scrum.model.UserStory;

import java.util.List;

/**
 * Created by ishwor on 11/11/15.
 */
public interface SprintService {
    public boolean saveSprint(Sprint sprint);

    public List<Sprint> findAllSprint();

    public Sprint findSprintById(int id);


    public boolean updateSprint(Sprint sprint);

    public void deleteSprint(int id);
}
