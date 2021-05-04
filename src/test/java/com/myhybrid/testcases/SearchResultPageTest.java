package com.myhybrid.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.myhybrid.base.BaseClass;
import com.myhybrid.pageobjects.IndexPage;
import com.myhybrid.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;

	@Test(groups = { "Smoke" })
	public void productAvailabilityTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);

	}

}
