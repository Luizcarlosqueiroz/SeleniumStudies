package com.luiz.formtest.successpage;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.luiz.formtest.addform.FormPage;

public class SuccessTest {
	
	private FormPage formPage;
	private SuccessPage successPage;
	List<String> formsValue = Arrays.asList("Ronaldo","11111111","I love bugs");
	
	@Before
	public void beforeEach() {
		this.formPage = new FormPage();
		formPage.fillForms(formsValue.get(0),formsValue.get(1),formsValue.get(2));
		this.successPage = formPage.submitForms();
	}
	
	@After
	public void afterEach() {
		this.formPage.quit();
		this.successPage.quit();
	}

	@Test
	public void canSubmitAnotherForm() {
		this.successPage.clickSubmitAgain();
		
		Assert.assertTrue(formPage.getText(By.className("lfr-ddm__default-page-header-title"))
				.equals("This is a Liferay Forms"));
	}
	
	@Test
	public void canSubmitEqualForms() {
		this.successPage.clickSubmitAgain();

		formPage.fillForms(formsValue.get(0),formsValue.get(1),formsValue.get(2));
		formPage.submitForms();
		
		Assert.assertTrue(formPage.getText(By.className("lfr-ddm__default-page-title"))
				.equals("Thank you."));
	}
}
