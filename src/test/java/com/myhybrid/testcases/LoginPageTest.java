package com.myhybrid.testcases;

import com.myhybrid.base.BaseClass;
import com.myhybrid.dataprovider.DataProviders;
import com.myhybrid.pageobjects.HomePage;
import com.myhybrid.pageobjects.IndexPage;
import com.myhybrid.pageobjects.LoginPage;
import com.myhybrid.utility.Hash;
import com.myhybrid.utility.Log;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {
	public IndexPage indexPage;
	public LoginPage loginPage;
	public HomePage homePage;

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = { "Sanity", "Smoke" })
	public void loginTest(String uname, String passwd) {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to click on SignIn");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter Username and Password");
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname, passwd);
		String actualURL = homePage.getCurrentURL();
		Log.info("Verify if user is able to login");
		Assert.assertEquals(actualURL, "http://automationpractice.com/index.php?controller=my-account");
		Log.info("Login is success");
		Log.endTestCase("loginTest");

	}
}
