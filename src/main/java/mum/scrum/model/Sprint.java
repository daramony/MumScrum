package mum.scrum.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.Date;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ishwor on 11/11/15.
 */
@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    private Date endDate;

//    public Integer getRelease_id() {
//        return release_id;
//    }
//
//    public void setRelease_id(Integer release_id) {
//        this.release_id = release_id;
//    }

//    private Integer release_id;
    @OneToOne
    @JoinColumn(name = "release_id")
    private Release release;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "sprint")
    //@JoinColumn(name="sprint_id")
    private Set<UserStory> userStorySet = new HashSet<UserStory>();

    
    public void addUserStory(UserStory userStory){
        userStorySet.add(userStory);
        userStory.setSprint(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public Set<UserStory> getUserStorySet() {
        return userStorySet;
    }

    public void setUserStorySet(Set<UserStory> userStorySet) {
        this.userStorySet = userStorySet;
    }

    public Sprint() {
        super();


    }


    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }
}
