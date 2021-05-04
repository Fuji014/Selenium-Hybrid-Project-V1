package com.myhybrid.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myhybrid.actiondriver.Action;
import com.myhybrid.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//a[@class='login']")
	private WebElement _btnSignIn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement _txtMyStoreLogo;

	@FindBy(xpath = "//input[@id='search_query_top']")
	private WebElement _txtBoxSearchProductBox;

	@FindBy(xpath = "//button[@name='submit_search']")
	private WebElement _btnSearch;

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.click(getDriver(), _btnSignIn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		Action.fluentWait1(getDriver(), _txtMyStoreLogo, 10);
		return Action.isDisplayed(getDriver(), _txtMyStoreLogo);
	}

	public String getMyStoreTitle() {
		String myStoreTitle = getDriver().getTitle();
		return myStoreTitle;
	}

	public SearchResultPage searchProduct(String productName) {
		Action.type(_txtBoxSearchProductBox, productName);
		Action.click(getDriver(), _btnSearch);
		return new SearchResultPage();
	}

}
