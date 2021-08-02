package com.myhybrid.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.myhybrid.base.BaseClass;
import com.myhybrid.dataprovider.DataProviders;
import com.myhybrid.pageobjects.AddToCartPage;
import com.myhybrid.pageobjects.IndexPage;
import com.myhybrid.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@Test(groups = { "Regression", "Sanity" }, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result = addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
	}

}
