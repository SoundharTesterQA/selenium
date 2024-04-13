package org.stepdefinition;

import org.base.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class FbAndAmazonHooks extends BaseClass {
	@Before
	
	private void preCondition() {
		launchBrowser();
		WindowMaximize();
	}
	
	@After
	private void postCondition() {
	closeEntireBrowser();

	}

}
