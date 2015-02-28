package demo.opsw;

import com.opsware.client.OpswareClient;
import com.opsware.compliance.sco.AuditTaskService;
import com.opsware.job.JobService;
import com.opsware.script.ServerScriptService;
import com.opsware.server.ServerService;

public class OPSWUtil {
	// Default host name of the Opsware SAS core server.
	private static String host = "owc";

	// Default port of where the Opsware server is listenting for requests
	private static int port = 443;

	//Handle to the Service.
	private static ServerService serverSvc;
	private static ServerScriptService scriptSvc;
	private static AuditTaskService auditSvc;
	private static JobService jobSvc;
	
	// User password
	private static String USERNAME ="admin";
	private static String PASSWD = "opsware_admin";

	public static final void init() throws Exception {
		
		// Use the OpswareClient to create an https connection to Opsware SAS
		// and authenticate the user.
		OpswareClient.connect("https", host, (short) port, USERNAME,
				PASSWD, true);

		// Get the handle to the required service.
		serverSvc = (ServerService) OpswareClient
				.getService(ServerService.class);
		scriptSvc = (ServerScriptService) OpswareClient
				.getService(ServerScriptService.class);
		auditSvc = (AuditTaskService) OpswareClient
				.getService(AuditTaskService.class);
		jobSvc = (JobService) OpswareClient
				.getService(JobService.class);
	}

	public static ServerService getServerSvc() {
		return serverSvc;
	}

	public static ServerScriptService getScriptSvc() {
		return scriptSvc;
	}

	public static AuditTaskService getAuditSvc() {
		return auditSvc;
	}

	public static JobService getJobSvc() {
		return jobSvc;
	}
	
	
}
