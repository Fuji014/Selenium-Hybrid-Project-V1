package com.myhybrid.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.myhybrid.base.BaseClass;
import com.myhybrid.pageobjects.HomePage;
import com.myhybrid.pageobjects.IndexPage;
import com.myhybrid.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@Test(groups = { "Smoke" })
	public void wishListTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateWishList();
		Assert.assertTrue(result);
	}

	@Test(groups = { "Smoke" })
	public void orderHistoryandDetailsTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
	}
}
