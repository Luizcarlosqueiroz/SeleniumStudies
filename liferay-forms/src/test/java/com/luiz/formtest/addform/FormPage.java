package com.luiz.formtest.addform;

import org.openqa.selenium.By;

import com.luiz.formtest.PageObject;
import com.luiz.formtest.successpage.SuccessPage;

import dataproviders.ConfigFileReader;

public class FormPage extends PageObject {
	
	ConfigFileReader configFileReader;

	public FormPage() {
		super(null);
		configFileReader = new ConfigFileReader();
		browser.navigate().to(configFileReader.getXpath("url"));
	}

	public void fillForms(String playerName, String date, String whyTesting) {
		browser.findElement(By.xpath(configFileReader.getXpath("favoritePlayer"))).sendKeys(playerName);
		browser.findElement(By.xpath(configFileReader.getXpath("dateLiferay"))).sendKeys(date);
		browser.findElement(By.xpath(configFileReader.getXpath("whyTesting"))).sendKeys(whyTesting);
	}
	
	public SuccessPage submitForms() {
		browser.findElement(By.xpath(configFileReader.getXpath("submit"))).submit();
		return new SuccessPage(browser);
	}
}