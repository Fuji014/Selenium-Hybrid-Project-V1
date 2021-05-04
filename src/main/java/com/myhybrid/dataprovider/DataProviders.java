package com.myhybrid.dataprovider;

import org.testng.annotations.DataProvider;

import com.myhybrid.utility.NewExcelLibrary;

public class DataProviders {
	NewExcelLibrary newExcelLibrary = new NewExcelLibrary();

	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = newExcelLibrary.getRowCount("Credentials");
		// Total Columns
		int column = newExcelLibrary.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = newExcelLibrary.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "getProduct")
	public Object[][] getProduct() {
		// Total rows count
		int rows = newExcelLibrary.getRowCount("ProductDetails");
		// Total columns
		int column = newExcelLibrary.getColumnCount("ProductDetails");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = newExcelLibrary.getCellData("ProductDetails", j, i + 2);
			}
		}
		return data;
	}
}
