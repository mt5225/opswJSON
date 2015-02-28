package demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.opsware.job.JobRef;
import com.opsware.server.ServerVO;

import demo.opsw.GetServerInfo;
import demo.opsw.JobInfoService;
import demo.opsw.OPSWUtil;
import demo.opsw.RunAuditJob;

public class OPSWTest {
	
	GetServerInfo gsi = new GetServerInfo();

	@Before
	public void setUp() throws Exception {
		OPSWUtil.init();
	}

	@Test
	public void testGetServerInfo() throws Exception {
		ServerVO svo = GetServerInfo.getServerInfo("rhel55");
		assertNotNull(svo);
	}
	
	@Test
	public void testGetAllServer() throws Exception {
		ServerVO[] servers = GetServerInfo.getAllServer();
		assertNotNull(servers);
		assertTrue(servers.length > 1);
	}
	
	@Test
	public void testRunAuditJob() throws Exception {
		JobRef jobRef = RunAuditJob.runAuditJob("policy1");
		assertNotNull(jobRef);
	}

    @Test
    public void testGetJobStatus() throws Exception {
    	assertNotNull(JobInfoService.getJobStatusByID("600001"));
    }
    
    @Test
    public void testGetJobResult() throws Exception {
    	assertNotNull(JobInfoService.getJobResultByID("600001"));
    }
}
