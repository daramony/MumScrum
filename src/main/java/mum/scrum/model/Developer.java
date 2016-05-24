package mum.scrum.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Developer extends EmployeeRole {
    public Developer() {
        super();
    }

    public List<UserStory> getUserStoryList() {
        return userStoryList;
    }

    public void setUserStoryList(List<UserStory> userStoryList) {
        this.userStoryList = userStoryList;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "developer")

    List<UserStory> userStoryList;
}
