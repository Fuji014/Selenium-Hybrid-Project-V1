package com.myhybrid.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myhybrid.base.BaseClass;
import com.myhybrid.dataprovider.DataProviders;
import com.myhybrid.pageobjects.AddToCartPage;
import com.myhybrid.pageobjects.IndexPage;
import com.myhybrid.pageobjects.OrderPage;
import com.myhybrid.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

	@Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class, groups = { "Regression" })
	public void verifyTotalPrice(String productName, String qty, String size) throws Exception {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProceedToCheckout();
		double unitPrice = orderPage.getUnitPrice();
		double totalPrice = orderPage.getTotalPrice();
		double totalExpectedPrice = (unitPrice * Double.parseDouble(qty)) + 2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}
}
