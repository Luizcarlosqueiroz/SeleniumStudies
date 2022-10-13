package com.luiz.formtest.addform;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class FormTest {
	
	private FormPage formPage;
	
	@Before
	public void beforeEach() {
		this.formPage = new FormPage();
	}
	
	@After
	public void afterEach() {
		this.formPage.quit();
	}
	
	@Test
	public void shouldSubmitWithValidData() {		
		formPage.fillForms("Pelé", "01012000", "Because it's amazing");
		formPage.submitForms();
		
		Assert.assertTrue(formPage.getText(By.className("lfr-ddm__default-page-title"))
				.equals("Thank you."));
	}
	
	@Test
	public void shouldNotSubmitWithInvalidData() {
		formPage.fillForms("", "", "");
		formPage.submitForms();
		
		String errorMessage = "This field is required.";
		
		Assert.assertTrue(formPage.getErrorElement("What is your favorite soccer player?").getText().equals(errorMessage));
		Assert.assertTrue(formPage.getErrorElement("what was the date that Liferay was founded?").getText().equals(errorMessage));
		Assert.assertTrue(formPage.getErrorElement("Why did you join the testing area?").getText().equals(errorMessage));
	}
	
	@Test
	public void cantAddLettersToDate() {
		formPage.fillForms("Pelé", "ABCDE", "Because it's amazing");
		formPage.submitForms();

		String errorMessage = "This field is required.";

		Assert.assertTrue(formPage.getErrorElement("what was the date that Liferay was founded?").getText().equals(errorMessage));
	}
}