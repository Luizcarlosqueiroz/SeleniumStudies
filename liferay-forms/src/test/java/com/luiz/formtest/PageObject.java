package com.luiz.formtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

	protected WebDriver browser;

	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		if (browser == null) {
			this.browser = new ChromeDriver();
		}
		else {
			this.browser = browser;			
		}
		
		this.browser.manage().timeouts()
		.implicitlyWait(Duration.ofSeconds(5))
		.pageLoadTimeout(Duration.ofSeconds(10));
	}
	
	public void quit() {
		this.browser.quit();
	}
	
	public String getText(By by) {
		return browser.findElement(by).getText();
	}
	
	public WebElement getErrorElement(String label) {
		return browser.findElement(By.xpath("//label[contains(text(),'"+label+"')]/following-sibling::span[*[@class='form-feedback-item']]"));
	}
}
