package com.actitime.testscript;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.pom.EnterTimeTrackpage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class ProjectModule extends BaseClass{
	@Test
	public void CreateProject() throws InterruptedException {
	EnterTimeTrackpage e= new EnterTimeTrackpage(driver);
	e.Settaskstab();
	TaskListPage t= new TaskListPage(driver);
	t.getAddNewBtn().click();
	t.getNewprojectbtn().click();
	t.getEnterprojectname().sendKeys("HDFC Bank");
	Thread.sleep(2000);
	t.getSelectcustomerdropdown().click();
	t.getSelecthdfc001().click();
	Thread.sleep(2000);
	t.getSelectdescription().sendKeys("abc");
	t.getClickcreatebtn().click();
	Thread.sleep(2000);
}
}