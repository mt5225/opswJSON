package demo.opsw;


import com.opsware.server.*;
import com.opsware.search.*;

public class GetServerInfo {

	public static ServerVO getServerInfo(String target) throws Exception {
		ServerService serverSvc = OPSWUtil.getServerSvc();
		String filterExpr = "ServerVO.hostname CONTAINS " + target;
		Filter filter = new Filter("device", filterExpr);
		// Get references to the servers that match the search filter.
		ServerRef[] serverRefs = serverSvc.findServerRefs(filter);
		if (serverRefs.length == 0) {
			System.out.println("No matching servers found.");
			System.out.println("Filter expression: " + filterExpr);
			System.exit(1);
		}
		// Get the value objects for the server references.
		ServerVO svo = serverSvc.getServerVOs(serverRefs)[0];	
		System.out.println("-----server " + svo.toString());
		return svo;
	}
	
	public static ServerVO[] getAllServer() throws Exception {
		//do login
		ServerService serverSvc = OPSWUtil.getServerSvc();	
		Filter filter = new Filter("device", "");
		// Get references to the servers that match the search filter.
		ServerRef[] serverRefs = serverSvc.findServerRefs(filter);
		if (serverRefs.length == 0) {
			System.out.println("No  servers found.");
			System.exit(1);
		}
		
		// Get the value objects for the server references.
		return serverSvc.getServerVOs(serverRefs);
	}
}

