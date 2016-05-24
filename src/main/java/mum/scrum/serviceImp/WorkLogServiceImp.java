package mum.scrum.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.scrum.model.WorkLog;
import mum.scrum.repository.WorkLogRepository;
import mum.scrum.service.WorkLogService;

@Service
public class WorkLogServiceImp implements WorkLogService {

	@Autowired
	WorkLogRepository workLogRepository;

//	public WorkLogServiceImp() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	@Override
	public boolean saveWorkLog(WorkLog worklog) {

		if (workLogRepository.save(worklog) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteWorkLog(int id) {
		workLogRepository.delete(id);
	}

}
