package com.luiz.formtest.successpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.luiz.formtest.PageObject;

import dataproviders.ConfigFileReader;

public class SuccessPage extends PageObject {

	ConfigFileReader configFileReader;
	
	public SuccessPage(WebDriver browser) {
		super(browser);
		configFileReader = new ConfigFileReader();
	}

	public void clickSubmitAgain() {
		this.browser.findElement(By.xpath(configFileReader.getXpath("favoritePlayer"))).click();
	}
}
