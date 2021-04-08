package com.inetBanking.testcases;

import org.testng.annotations.Test;

import com.inetBanking.utilities.BaseTest;
import com.intBanking.pages.LoginPage;

public class TC_LoginTest_001 extends BaseTest {

	@Test
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername("mngr315366");
		loginPage.setPassword("yrEsEpU");
		loginPage.clickSubmit();
	}
}
