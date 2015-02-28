package demo.opsw;

import com.opsware.job.JobInfoVO;
import com.opsware.job.JobRef;
import com.opsware.job.JobResult;
import com.opsware.job.JobService;
import com.opsware.search.Filter;

public class JobInfoService {
	
	public final static JobInfoVO getJobStatusByID(String jobID){
		JobService jobsrv = OPSWUtil.getJobSvc();
		String filterExpr = "job_session_id = " + jobID;
		Filter filter = new Filter("job", filterExpr);
		try {
			JobRef[] jobRefs = jobsrv.findJobRefs(filter);
			return jobsrv.getJobInfoVOs(jobRefs)[0];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public final static JobResult getJobResultByID(String jobID){
		JobService jobsrv = OPSWUtil.getJobSvc();
		String filterExpr = "job_session_id = " + jobID;
		Filter filter = new Filter("job", filterExpr);
		try {
			JobRef jobRef = jobsrv.findJobRefs(filter)[0];
			return jobsrv.getResult(jobRef);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
