package com.myhybrid.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.myhybrid.base.BaseClass;
import com.myhybrid.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;

	@Test(groups = { "Smoke" })
	public void verifyLogo() {
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}

	@Test(groups = { "Smoke" })
	public void verifyTitle() {
		String title = indexPage.getMyStoreTitle();
		Assert.assertEquals(title, "My Store");
	}
}
