package mum.scrum.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ishwor on 11/11/15.
 */
@Entity(name = "Releases")
public class Release {
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


    public Set<Sprint> getSprintSet() {
        return sprintSet;
    }

    public void setSprintSet(Set<Sprint> sprintSet) {
        this.sprintSet = sprintSet;
    }

    public Release() {
        super();
    }

    public void addSprint(Sprint sprint){
        sprintSet.add(sprint);
        sprint.setRelease(this);
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "release")
    private Set<Sprint> sprintSet = new HashSet<Sprint>();

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        formatter.format(re)
        this.releaseDate = releaseDate;

    }
}
