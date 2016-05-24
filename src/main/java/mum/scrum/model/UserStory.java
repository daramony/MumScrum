package mum.scrum.model;

import javax.persistence.*;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class UserStory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="User Story Name is required.")
	private String name;
	@NotEmpty(message="User Story Description is required.")
	private String description;

	private Integer developer_id;
	private Integer tester_id;

	public Integer getDeveloper_id() {
		return developer_id;
	}

	public void setDeveloper_id(Integer developer_id) {
		this.developer_id = developer_id;
	}

	public Integer getTester_id() {
		return tester_id;
	}

	public void setTester_id(Integer tester_id) {
		this.tester_id = tester_id;
	}

	private Integer devEffort;
	private Integer testEffort;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sprint_id")
	private Sprint sprint;

//	private Integer priority;
	@OrderBy("workDay ASC")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "userStory", orphanRemoval = true)
	private List<WorkLog> workLogList = new ArrayList<WorkLog>();

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "developer_id", insertable = false, updatable = false)
	private Employee developer;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "tester_id", insertable = false, updatable = false)
	private Employee tester;

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}


	public Employee getDeveloper() {
		return developer;
	}

	public void setDeveloper(Employee developer) {
		this.developer = developer;
	}

	public Employee getTester() {
		return tester;
	}

	public void setTester(Employee tester) {
		this.tester = tester;
	}

	public void addWorkLog(WorkLog workLog){
		workLogList.add(workLog);
		workLog.setUserStory(this);
	}

	public List<WorkLog> getWorkLogList() {
		return workLogList;
	}

	public void setWorkLogList(List<WorkLog> workLogList) {
		this.workLogList = workLogList;
	}

	public UserStory() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public Integer getDeveloperId() {
//		return developerId;
//	}
//	public void setDeveloperId(Integer developerId) {
//		this.developerId = developerId;
//	}
//	public Integer getTesterId() {
//		return testerId;
//	}
@Override
public String toString() {
	return "UserStory{" +
			"id=" + id +
			", name='" + name + '\'' +
			", description='" + description + '\'' +
			", developer_id=" + developer_id +
			", tester_id=" + tester_id +
			", devEffort=" + devEffort +
			", testEffort=" + testEffort +
			", sprint=" + sprint +
			", workLogList=" + workLogList +
			", developer=" + developer +
			", tester=" + tester +
			'}';
}
//	public void setTesterId(Integer testerId) {
//		this.testerId = testerId;
//	}
	public Integer getDevEffort() {
		return devEffort;
	}
	public void setDevEffort(Integer devEffort) {
		this.devEffort = devEffort;
	}
	public Integer getTestEffort() {
		return testEffort;
	}
	public void setTestEffort(Integer testEffort) {
		this.testEffort = testEffort;
	}

	
}
