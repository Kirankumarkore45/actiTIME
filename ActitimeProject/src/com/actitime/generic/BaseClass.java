package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.EnterTimeTrackpage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	@BeforeTest
	public void openbrowser() 
	{
		Reporter.log("open browser",true);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		Reporter.log("login",true);
		FileLib f= new FileLib();
		String url = f.GetPropertyData("url");
		String un = f.GetPropertyData("username");
		String pw = f.GetPropertyData("password");
		driver.get(url);
		LoginPage l = new LoginPage(driver);
		l.setlogin(un, pw);
	}
	
	@AfterTest
	public void closebrowser()
	{
		Reporter.log("closebrowser",true);
		driver.close();
	}
	
	
	@AfterMethod
	public void logout()
	{
		Reporter.log("logout",true);
		EnterTimeTrackpage e= new EnterTimeTrackpage(driver);
		e.Setlogout();
	}
}
