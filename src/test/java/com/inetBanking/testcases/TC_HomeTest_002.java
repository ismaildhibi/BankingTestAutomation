package com.inetBanking.testcases;

import org.testng.annotations.Test;

import com.inetBanking.utilities.BaseTest;
import com.inetBanking.utilities.ReadConfig;
import com.intBanking.pages.HomePage;
import com.intBanking.pages.LoginPage;

public class TC_HomeTest_002 extends BaseTest {
	ReadConfig readconfig = new ReadConfig();

	@Test
	public void goHome() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(readconfig.getUsername());
		loginPage.setPassword(readconfig.getPassword());
		HomePage homePage = loginPage.clickSubmit();
		homePage.clickAddCustomer();
	}
}
