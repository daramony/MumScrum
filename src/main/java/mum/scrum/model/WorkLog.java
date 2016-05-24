package mum.scrum.model;

import java.util.Comparator;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class WorkLog{
	@Id
    @GeneratedValue
	private Integer id;

//	public Integer getUserStory_id() {
//		return userStory_id;
//	}
//
//	public void setUserStory_id(Integer userStory_id) {
//		this.userStory_id = userStory_id;
//	}

//	private Integer userStory_id;
	private Integer remainingDevEffort;
	private Date workDay;
	private Integer remainingTestEffort;
	private Integer TotalTestEffort;
	private Integer TotalDevEffort;
	private String status;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "userStory_id")
	private UserStory userStory;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRemainingDevEffort() {
		return remainingDevEffort;
	}
	public void setRemainingDevEffort(Integer remainingDevEffort) {
		this.remainingDevEffort = remainingDevEffort;
	}
	public Date getWorkDay() {
		return workDay;
	}
	public void setWorkDay(Date workDay) {
		this.workDay = workDay;
	}
	public Integer getRemainingTestEffort() {
		return remainingTestEffort;
	}
	public void setRemainingTestEffort(Integer remainingTestEffort) {
		this.remainingTestEffort = remainingTestEffort;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTotalDevEffort() {
		return TotalDevEffort;
	}
	public void setTotalDevEffort(Integer totalDevEffort) {
		TotalDevEffort = totalDevEffort;
	}
	public Integer getTotalTestEffort() {
		return TotalTestEffort;
	}
	public void setTotalTestEffort(Integer totalTestEffort) {
		TotalTestEffort = totalTestEffort;
	}

	@Override
	public String toString() {
		return "WorkLog{" +
				"workDay=" + workDay +
				'}';
	}

	public UserStory getUserStory() {
		return userStory;
	}


//	public String toString() {
//		return "WorkLog{" +
//				"id=" + id +
//				", remainingDevEffort=" + remainingDevEffort +
//				", workDay=" + workDay +
//				", remainingTestEffort=" + remainingTestEffort +
//				", TotalTestEffort=" + TotalTestEffort +
//				", TotalDevEffort=" + TotalDevEffort +
//				", status='" + status + '\'' +
//				", userStory=" + userStory +
//				'}';
//	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}


}
