package assignment.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import assignment.qa.base.Base;
import assignment.qa.pages.HomePage;

public class HomePageTest extends Base {
	
	HomePage hp;
	
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		hp = new HomePage();
	}

	
	//1.Verify that the text input element with xpath .//input[@name='my-disabled'] is disabled in the form

	@Test
	public void verifyTextInputElementXpath() {	
		//If text is input is disabled false will be the boolean value
		Assert.assertFalse(hp.verifyInputElement(),"Text input element with xpath is disabled.");
		
	}
	
	
	//2.Verify that the text input with value 'Readonly input' is in readonly state by using 2 xpaths
	
	@Test
	public void verifyReadonlyState() {	
		Assert.assertTrue(hp.verifyReadonlyState1(), "Text input with value 'Readonly input' is in readonly state");
		

	}
	
	
	//3.Verify that the dropdown field to select color is having 8 elements using 2 xpaths
	//Xpath1
	@Test
	public void verifyDropdownXpath1() {	
		Assert.assertEquals(hp.verifyDropdownXpath1(),8);
		

	}
	
	//Xpath2
	@Test
	public void verifyDropdownXpath2() {	
		Assert.assertEquals(hp.verifyDropdownXpath2(),8);
		
	}
	
	
	//4.Verify that the submit button is disabled when no data is entered in Name field
	
	@Test
	public void submitButtonDisabledName() {	
		
		Assert.assertFalse(hp.verifySubmitButtonStatus(),"Submit button is disabled");
		
	}
	

	
	//5.Verify that the submit button enabled when both Name and Password field is entered
	
	@Test
	public void submitButtonEnabled() throws Exception {	
		
		Assert.assertFalse(hp.verifySubmitButtonStatus(),"Submit button is disabled");
		Thread.sleep(1000);
		hp.enterUserName();
		Assert.assertFalse(hp.verifySubmitButtonStatus(),"Submit button is disabled");
		hp.enterPassword();
		Thread.sleep(2000);
		Assert.assertTrue(hp.verifySubmitButtonStatus(),"Submit button is Enabled");
		
	}
	
	
	
	//6.Verify that on submit of 'Submit' button the page shows 'Received' text

	@Test
	public void verifyTextAfterSubmit() throws Exception {	
		
		hp.enterUserName();
		hp.enterPassword();
		Thread.sleep(2000);
		hp.clickonSubmit();
		Assert.assertEquals(hp.verifyText(), "Received!");
		
		
	}
	
	
	
	//7.Verify that on submit of form all the data passed to the URL
	
	@Test
	public void verifyUrlDataPassed() throws Exception {	
		
		hp.enterUserName();
		hp.enterPassword();
		Thread.sleep(2000);
		hp.clickonSubmit();
		Assert.assertTrue(hp.getCurrentUrl().contains(prop.getProperty("Name")), "User name check");
		Assert.assertTrue(hp.getCurrentUrl().contains(prop.getProperty("Password")), "Password check");
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	
	
}


