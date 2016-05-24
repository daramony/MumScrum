package mum.scrum.serviceImp;

import mum.scrum.model.Sprint;
import mum.scrum.repository.SprintRepository;
import mum.scrum.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ishwor on 11/11/15.
 */
@Service
public class SprintServiceImp implements SprintService{
    @Autowired
    SprintRepository sprintRepository;

    @Override
    public boolean saveSprint(Sprint sprint) {
        if(sprintRepository.save(sprint)!=null)
            return true;
        return false;
    }

    @Override
    public List<Sprint> findAllSprint() {

        return sprintRepository.findAll();
    }

    @Override
    public Sprint findSprintById(int id) {

        return sprintRepository.findOne(id);
    }

    @Override
    public boolean updateSprint(Sprint sprint) {
        return false;
    }

    @Override
    public void deleteSprint(int id) {
        sprintRepository.delete(id);
    }
}
