package demo.opsw;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opsware.job.JobInfoVO;
import com.opsware.job.JobRef;
import com.opsware.job.JobResult;
import com.opsware.server.ServerVO;

@RestController
public class OpswController {
	
	@RequestMapping("/server")
	public ServerVO getServer(@RequestParam(value="name", defaultValue="rhel55") String serverName){
		try{
			OPSWUtil.init();
			return GetServerInfo.getServerInfo(serverName);
		}catch (Exception e){
			return null;
		}
	}
	
	@RequestMapping("/servers")
	public ServerVO[] getServers(){
		try{
			OPSWUtil.init();
			return GetServerInfo.getAllServer();
		}catch (Exception e){
			return null;
		}
	}
	
	@RequestMapping("/audit")
	public JobRef runAuditTask(@RequestParam(value="name", defaultValue="policy1") String auditPolicyName){
		try{
			OPSWUtil.init();
			return RunAuditJob.runAuditJob(auditPolicyName);
		}catch (Exception e){
			return null;
		}
	}
	
	@RequestMapping("/job/status")
	public JobInfoVO getJobStatusbyID(@RequestParam(value="id", defaultValue="600001") String jobID){
		try{
			OPSWUtil.init();
			return JobInfoService.getJobStatusByID(jobID);
		}catch (Exception e){
			return null;
		}
	}
	
	@RequestMapping("/job/result")
	public JobResult getJobResultbyID(@RequestParam(value="id", defaultValue="600001") String jobID){
		try{
			OPSWUtil.init();
			return JobInfoService.getJobResultByID(jobID);
		}catch (Exception e){
			return null;
		}
	}
}