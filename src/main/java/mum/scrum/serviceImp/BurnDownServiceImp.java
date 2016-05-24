package mum.scrum.serviceImp;

import mum.scrum.model.Sprint;
import mum.scrum.model.UserStory;
import mum.scrum.model.WorkLog;
import mum.scrum.service.BurnDownService;
import mum.scrum.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ishwor on 11/12/15.
 */
@Service
public class BurnDownServiceImp implements BurnDownService {
    @Autowired
    SprintService sprintService;

    @Override
    public Map<String,TreeMap<String, Integer>> generateBurnDownData(int sprintId) {
        Map<String, TreeMap<String,Integer>> burndownData = new HashMap<String, TreeMap<String, Integer>>();

        burndownData.put("dev",getBurnDownDataDev(sprintId));
        burndownData.put("test",getBurnDownDataTest(sprintId));
        return burndownData;

    }

    private TreeMap<String,Integer> getBurnDownDataDev(int sprintId){
        Sprint sprint = sprintService.findSprintById(sprintId);
        Set<UserStory> userStories = sprint.getUserStorySet();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        TreeMap<String,Integer> burndownDataDev = new TreeMap<String,Integer>();
        burndownDataDev.put(formatter.format(sprint.getStartDate()),getInitialSprintEstimate(sprintId,"dev"));
        System.out.println(userStories);
        for(UserStory userStory:userStories){

            List<WorkLog> workLogs = userStory.getWorkLogList();
            for(WorkLog workLog:workLogs){
                if(burndownDataDev.containsKey(formatter.format(workLog.getWorkDay()))){
//                    System.out.println(workLog);
                    int workLoad = burndownDataDev.get(formatter.format(workLog.getWorkDay()));
                    burndownDataDev.put(formatter.format(workLog.getWorkDay()),workLoad+workLog.getRemainingDevEffort());
                }
                else{
//                    System.out.println(workLog);
                    burndownDataDev.put(formatter.format(workLog.getWorkDay()),workLog.getRemainingDevEffort());
                }
            }
        }

        return  burndownDataDev;
    }

    private TreeMap<String,Integer> getBurnDownDataTest(int sprintId){
        Sprint sprint = sprintService.findSprintById(sprintId);
        Set<UserStory> userStories = sprint.getUserStorySet();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        TreeMap<String,Integer> burndownDataTest = new TreeMap<String,Integer>();
        burndownDataTest.put(formatter.format(sprint.getStartDate()),getInitialSprintEstimate(sprintId,"test"));
        System.out.println(userStories);
        for(UserStory userStory:userStories){
//            System.out.println(userStory);
            List<WorkLog> workLogs = userStory.getWorkLogList();
            for(WorkLog workLog:workLogs){
                if(burndownDataTest.containsKey(formatter.format(workLog.getWorkDay()))){
//                    System.out.println(workLog);
                    int workLoad = burndownDataTest.get(formatter.format(workLog.getWorkDay()));
                    burndownDataTest.put(formatter.format(workLog.getWorkDay()),workLoad+workLog.getRemainingTestEffort());
                }
                else{
//                    System.out.println(workLog);
                    burndownDataTest.put(formatter.format(workLog.getWorkDay()),workLog.getRemainingTestEffort());
                }
            }
        }
//        burndownDataTest.put("Sprint Start",getInitialSprintEstimate(sprintId,"test"));
        return  burndownDataTest;
    }

    private int getInitialSprintEstimate(int sprintId,String role){
        int initialEstimate = 0;
        Sprint sprint = sprintService.findSprintById(sprintId);
        Set<UserStory> userStories = sprint.getUserStorySet();
        for(UserStory userStory:userStories){
            if(role=="dev") {
                initialEstimate += userStory.getDevEffort();
            }
            else if(role=="test")
                initialEstimate += userStory.getTestEffort();
        }
        System.out.println(initialEstimate);
        return initialEstimate;

    }
//    private HashMap<Date,Integer> calculateBurndown(UserStory userStory){
//
//
//        return null;
//    }

}
