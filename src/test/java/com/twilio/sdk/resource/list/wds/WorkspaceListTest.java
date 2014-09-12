package com.twilio.sdk.resource.list.wds;

import com.twilio.sdk.resource.instance.BasicRequestTester;
import com.twilio.sdk.resource.instance.wds.Workspace;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WorkspaceListTest extends BasicRequestTester {

	@Before
	public void setup() throws Exception {
		setExpectedServerContentType("application/json");
		setExpectedServerAnswer("/" + getClass().getPackage().getName().replace(".", "/") + "/workspaces.json");
	}

	@Test
	public void testGetWorkspaces() throws Exception {
		setExpectedServerReturnCode(200);
		WorkspaceList workspaces = wdsClient.getWorkspaces();
		assertNotNull(workspaces);
		for (Workspace workspace : workspaces) {
			assertNotNull(workspace.getSid());
		}
		assertTrue(workspaces.getTotal() == 1);
	}

}
