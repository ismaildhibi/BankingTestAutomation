package com.intBanking.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class AddCustomerPage {
	private WebDriver driver;
	private By nameField = By.name("name");
	private By radField = By.name("rad1");
	private By dobField = By.name("dob");
	private By addrField = By.name("addr");
	private By cityField = By.name("city");
	private By stateField = By.name("state");
	private By pinnoField = By.name("pinno");
	private By telephonenoField = By.name("telephoneno");
	private By emailField = By.name("emailid");
	private By passwdField = By.name("password");
	private By submitButton = By.name("sub");

	public AddCustomerPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void setName(String name) {
		driver.findElement(nameField).sendKeys(name);
	}

	public void setGender() {
		driver.findElement(radField).click();
	}

	public void setBirthday(String day, String month, String year) {
		driver.findElement(dobField).sendKeys(day, month, year);
	}

	public void setAddress(String address) {
		driver.findElement(addrField).sendKeys(address);
	}

	public void setCity(String city) {
		driver.findElement(cityField).sendKeys(city);
	}

	public void setState(String state) {
		driver.findElement(stateField).sendKeys(state);
	}

	public void setPin(String pin) {
		driver.findElement(pinnoField).sendKeys(pin);
	}

	public void setPhone(String phoneNum) {
		driver.findElement(telephonenoField).sendKeys(phoneNum);
	}

	public void setEmail(String email) {
		// driver.findElement(emailField).sendKeys(email);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		WebElement emaild = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(emailField);
			}
		});

		emaild.sendKeys(email);
	}

	public void setPassword(String password) {
		driver.findElement(passwdField).sendKeys(password);
	}

	public ValidationAddCustomerPage clickSubmit() {
		driver.findElement(submitButton).click();
		return new ValidationAddCustomerPage(driver);
	}

	public String generateRandomEmail() {
		String emailR = RandomStringUtils.randomAlphabetic(5);
		return emailR;
	}

}
