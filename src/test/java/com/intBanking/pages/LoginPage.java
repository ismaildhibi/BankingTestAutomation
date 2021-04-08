package com.intBanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	private By usernameField = By.name("uid");
	private By passwordField = By.name("password");
	private By submitButton = By.name("btnLogin");

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void setUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public HomePage clickSubmit() {
		driver.findElement(submitButton).click();
		return new HomePage(driver);
	}

}
