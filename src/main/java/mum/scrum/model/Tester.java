package mum.scrum.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tester extends EmployeeRole {
    public Tester() {
        super();
    }
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn
    List<UserStory> userStoryList;
    public List<UserStory> getUserStoryList() {
        return userStoryList;
    }

    public void setUserStoryList(List<UserStory> userStoryList) {
        this.userStoryList = userStoryList;
    }


}
