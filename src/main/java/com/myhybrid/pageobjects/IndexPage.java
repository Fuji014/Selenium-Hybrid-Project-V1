package com.myhybrid.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement searchProductBox;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchButton;
	
	// Create constructor
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.click(driver, signIn);
		return new LoginPage();
	}
	
	public boolean  validateLogo() {
		return Action.isDisplayed(driver, myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle = driver.getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}
	
}
