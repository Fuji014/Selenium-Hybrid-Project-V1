package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="//div[@class='product-container']//a[contains(text(), 'Faded Short Sleeve T-shirts')]")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() {
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
	
}
