package com.inetBanking.testcases;

import org.testng.annotations.Test;

import com.inetBanking.utilities.BaseTest;
import com.inetBanking.utilities.ReadConfig;
import com.intBanking.pages.FundTranserPage;
import com.intBanking.pages.HomePage;
import com.intBanking.pages.LoginPage;
import com.intBanking.pages.ValidationFundTransferPage;

public class TC_FundTransferTest_006 extends BaseTest {
	ReadConfig readconfig = new ReadConfig();

	@Test
	public void deposit() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(readconfig.getUsername());
		loginPage.setPassword(readconfig.getPassword());
		HomePage homePage = loginPage.clickSubmit();
		FundTranserPage fundTranserPage = homePage.clickFundTranser();
		fundTranserPage.setPayers("123456");
		fundTranserPage.setPayeer("678910");
		fundTranserPage.setAmmount("300");
		fundTranserPage.setDescription("Fund Transfer");

		ValidationFundTransferPage fundTransferPage = fundTranserPage.clickSubmit();

		fundTransferPage.driver.switchTo().alert().accept();

	}
}
