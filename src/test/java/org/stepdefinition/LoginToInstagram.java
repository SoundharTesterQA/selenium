package org.stepdefinition;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pojo.FbLogPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginToInstagram extends BaseClass {
	FbLogPojo f;
	
	@Given("TO launch the edge browser and maximize window")
	public void to_launch_the_edge_browser_and_maximize_window() {
		launchBrowser();
		WindowMaximize();
	   
	}

	@When("To launch the url of the instagram application")
	public void to_launch_the_url_of_the_instagram_application() {
		launchUrl("https://www.instagram.com/accounts/login/");
	   
	}

	@When("To pass valid username in email field")
	public void to_pass_valid_username_in_email_field() {
		f= new  FbLogPojo();
		passText("Sounndarap89@gmail.com",f.getEmail());
	}

	@When("To pass invalid password in passwod field")
	public void to_pass_invalid_password_in_passwod_field() {
		f = new FbLogPojo();
		passText("Sondhar@07", f.getPassword());
		
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		clickTheOption(f.getLogbtn());
	}

	@When("To check whether navigateto the home  page or not")
	public void to_check_whether_navigateto_the_home_page_or_not() {
		System.err.println("Check your login details");
	   
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeEntireBrowser();
	    
	}


}
