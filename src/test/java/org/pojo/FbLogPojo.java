package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLogPojo extends BaseClass {
	
	public void Fblogin() {
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath = "//input[@aria-label='Phone number, username, or email']") 
		private WebElement email;
		
		@FindBy(xpath = "//input[@type='password']")
		private WebElement password;
		
		@FindBy(xpath = "//div[text()='Log in']")
		private WebElement logbtn;

		public WebElement getEmail() {
			return email;
		}

		public WebElement getPassword() {
			return password;
		}

		public WebElement getLogbtn() {
			return logbtn;
		}

	
		

		

		
		

	
	
}
