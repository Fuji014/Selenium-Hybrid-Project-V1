package com.myhybrid.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myhybrid.base.BaseClass;
import com.myhybrid.pageobjects.AddToCartPage;
import com.myhybrid.pageobjects.AddressPage;
import com.myhybrid.pageobjects.IndexPage;
import com.myhybrid.pageobjects.LoginPage;
import com.myhybrid.pageobjects.OrderConfirmationPage;
import com.myhybrid.pageobjects.OrderPage;
import com.myhybrid.pageobjects.OrderSummaryPage;
import com.myhybrid.pageobjects.PaymentPage;
import com.myhybrid.pageobjects.SearchResultPage;
import com.myhybrid.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;

	@Test(groups = { "Regression" })
	public void endToEndTest() throws Exception {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProceedToCheckout();
		loginPage = orderPage.clickCheckOut();
		addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = addressPage.clickOnCheckOut();
		shippingPage.checkTermsOfService();
		paymentPage = shippingPage.clickOnProceedToCheckOut();
		orderSummaryPage = paymentPage.clickOnBankWire();
		orderConfirmationPage = orderSummaryPage.clickOnConfirmOrderBtn();
		String actualMessage = orderConfirmationPage.validateConfirmMessage();
		String expectedMessage = "Your order on My Store is complete.";
		Assert.assertEquals(expectedMessage, actualMessage);
	}
}
