package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackpage
{
	@FindBy (xpath="//div[text()='Tasks']")
	private WebElement taskstab;
	
	@FindBy (id="logoutLink")
	private WebElement logout;

	public EnterTimeTrackpage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	public void Setlogout() {
		logout.click();
	}
	public void Settaskstab() {
		taskstab.click();
	}
}
