package com.luiz.formtest.successpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.luiz.formtest.PageObject;

public class SuccessPage extends PageObject {

	public SuccessPage(WebDriver browser) {
		super(browser);
	}

	public void clickSubmitAgain() {
		this.browser.findElement(By.xpath("//button[text()='Submit Again']")).click();
	}
}
