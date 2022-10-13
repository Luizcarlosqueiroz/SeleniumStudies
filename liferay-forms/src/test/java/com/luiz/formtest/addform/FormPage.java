package com.luiz.formtest.addform;

import org.openqa.selenium.By;

import com.luiz.formtest.PageObject;
import com.luiz.formtest.successpage.SuccessPage;

public class FormPage extends PageObject {

	public FormPage() {
		super(null);
		browser.navigate().to(url_form);
	}

	private static final String url_form = "https://forms.liferay.com/web/forms/shared/-/form/122548";
	
	private static By xpath_date = By.xpath("//*[@name='datePicker']/following-sibling::*[contains(@dir,'ltr')]");
	private static By xpath_player = By.xpath("//label[contains(text(),'soccer player')]/following-sibling::*[contains(@dir,'ltr')]");
	private static By xpath_whyTesting = By.xpath("//label[contains(text(),'testing area')]/following-sibling::*[contains(@dir,'ltr')]");
	private static By xpath_submit = By.xpath("//button[@type='submit' and not (@hidden)]");	

	public void fillForms(String playerName, String date, String whyTesting) {
		browser.findElement(xpath_player).sendKeys(playerName);
		browser.findElement(xpath_date).sendKeys(date);
		browser.findElement(xpath_whyTesting).sendKeys(whyTesting);
	}
	
	public SuccessPage submitForms() {
		browser.findElement(xpath_submit).submit();
		return new SuccessPage(browser);
	}
}