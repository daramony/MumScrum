package mum.scrum.service;

import org.springframework.stereotype.Service;

import mum.scrum.model.WorkLog;


public interface WorkLogService {

    boolean saveWorkLog(WorkLog userStory);

    void deleteWorkLog(int id);


}
