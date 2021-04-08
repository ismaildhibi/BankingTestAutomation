package com.inetBanking.testcases;

import org.testng.annotations.Test;

import com.inetBanking.utilities.BaseTest;
import com.inetBanking.utilities.ReadConfig;
import com.intBanking.pages.CustomisedStatementPage;
import com.intBanking.pages.HomePage;
import com.intBanking.pages.LoginPage;
import com.intBanking.pages.ValidationCustomisedStatementPage;

public class TC_CustomisedStatementTest_007 extends BaseTest {
	ReadConfig readconfig = new ReadConfig();

	@Test
	public void deposit() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(readconfig.getUsername());
		loginPage.setPassword(readconfig.getPassword());
		HomePage homePage = loginPage.clickSubmit();
		CustomisedStatementPage customisedStatementPage = homePage.clickCustomisedStatement();
		customisedStatementPage.setAccountNo("123456");
		customisedStatementPage.setFdate("22", "02", "2020");
		customisedStatementPage.setTdate("22", "02", "2021");
		customisedStatementPage.setAmountLowerLimit("100");
		customisedStatementPage.setNumTransactionField("20");
		ValidationCustomisedStatementPage validationCustomisedStatementPage = customisedStatementPage.clickSubmit();

		validationCustomisedStatementPage.driver.switchTo().alert().accept();

	}
}
