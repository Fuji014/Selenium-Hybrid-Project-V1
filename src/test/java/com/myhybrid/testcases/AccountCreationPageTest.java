package com.myhybrid.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.myhybrid.base.BaseClass;
import com.myhybrid.pageobjects.AccountCreationPage;
import com.myhybrid.pageobjects.IndexPage;
import com.myhybrid.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;

	@Test(groups = { "Sanity" })
	public void verifyCreateAccountPageTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("oidkmqmwdmk123@gmail.com");
		boolean result = accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);
	}
}
