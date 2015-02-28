package demo.opsw;

import com.opsware.compliance.sco.AuditTaskRef;
import com.opsware.compliance.sco.AuditTaskService;
import com.opsware.job.JobRef;
import com.opsware.search.Filter;

public class RunAuditJob {

	private static final AuditTaskRef getAuditTaskRef(String name) throws Exception {
		AuditTaskService auditTaskSvc = OPSWUtil.getAuditSvc();
		String filterExpr = "AuditTaskVO.name *=* " + name;
		Filter filter = new Filter("audit_task", filterExpr);
		// Get references to the audit task that match the search filter.
		AuditTaskRef auditRef = auditTaskSvc.findAuditTaskRefs(filter)[0];
		System.out.println("-------audit policy " + auditRef.toString());
		return auditRef;		
	}
	
	public static final JobRef runAuditJob(String auditPolicyName) {
		AuditTaskService auditTaskSvc = OPSWUtil.getAuditSvc();
		try {
			//run audit job and return reference
			JobRef jobRef = auditTaskSvc.startAudit(getAuditTaskRef(auditPolicyName), null, null, null);
			return jobRef;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
