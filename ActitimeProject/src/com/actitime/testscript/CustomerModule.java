package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.EnterTimeTrackpage;
import com.actitime.pom.TaskListPage;
public class CustomerModule extends BaseClass {
	@Test 
	public void TestCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("CreateCustomer",true);
		FileLib f=new FileLib();
		String customerName = f.GetExcelData("Create Customer", 1, 2);
		String customerDesc = f.GetExcelData("Create Customer", 1, 3);
		EnterTimeTrackpage e= new EnterTimeTrackpage(driver);
		e.Settaskstab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerOption().click();
		t.getEnterCustNameTbx().sendKeys(customerName);
		t.getEnterCustDescriptionTbx().sendKeys(customerDesc);
		t.getSelectCustomerDD().click();
		t.getBigBangCompanyTx().click();
		t.getCreateCustomerBtn().click();
		Thread.sleep(5000);
		String actualCustomerText = t.getActualCustomer().getText();
		Assert.assertEquals(actualCustomerText, customerName);
		}
	}

