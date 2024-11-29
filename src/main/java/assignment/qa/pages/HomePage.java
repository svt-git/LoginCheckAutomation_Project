package assignment.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import assignment.qa.base.Base;

public class HomePage  extends Base {

	//Page Objects
	@FindBy(name ="my-name")
	WebElement username;
	
	@FindBy(name="my-password")
	WebElement password;
	
	@FindBy(xpath="//input[@name='my-disabled']")
	WebElement  verifyxpath;
	
	@FindBy(xpath="//input[@placeholder='Disabled input']")
	WebElement  disabledinput;
	
	@FindBy(xpath="//input[@value='Readonly input']")
	WebElement  readonlyinput1;
	
	@FindBy(xpath="//input[@name='my-readonly']")
	WebElement  readonlyinput2;
	
	
	@FindBy(xpath="//select[@class='form-select']")
	WebElement  dropdown1;
	
	@FindBy(xpath="//select[@name='my-select']")
	WebElement  dropdown2;
	
	@FindBy(xpath="//button[@class='btn btn-success mt-3 float-end']")
	WebElement  submitbtn;
	

	
	@FindBy(xpath="//p[@id='message']")
	WebElement  verifytext;
	
	//select[@class="form-select"]
	//select[@class="form-select"]/option
	//option
	//select[@name='my-select']
	//button[@class="btn btn-success mt-3 float-end"]
	//p[@id="message"]
	
	//Initializing the Page Object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	//Actions:
	
	public void enterUserName() {
		username.sendKeys(prop.getProperty("Name"));
	}
	
	public void enterPassword() {
		password.sendKeys(prop.getProperty("Password"));
	}
	
	public void clickonSubmit() {
		submitbtn.click();
	}
	
	
	//1.Verify that the text input element with xpath .//input[@name='my-disabled'] is disabled in the form

	public boolean verifyInputElement () {
		return verifyxpath.isEnabled();		
	}
	
	
	//2.Verify that the text input with value 'Readonly input' is in readonly state by using 2 xpaths
	
	public boolean verifyReadonlyState1 () {
		return readonlyinput1.getAttribute("readonly")!= null;		
	}	
	
	public boolean verifyReadonlyState2 () {
		return readonlyinput2.getAttribute("readonly")!= null;		
	}	
	
	
	//3.Verify that the dropdown field to select color is having 8 elements using 2 xpaths

	public int verifyDropdownXpath1 () {
		
		Select color = new Select(dropdown1);
		List<WebElement> options = color.getOptions();
	    return options.size();
		
	}
	
	
    public int verifyDropdownXpath2 () {
		
		Select color = new Select(dropdown2);
		List<WebElement> options = color.getOptions();
	    return options.size();
	}
	
	
   //4. Verify that the submit button is disabled when no data is entered in Name field
    
    
    
  //5. Verify that the submit button enabled when both Name and Password field is entered
    
   
    public boolean verifySubmitButtonStatus() {
    	return submitbtn.isEnabled();
		
	}	
    
	
   //6. Verify that on submit of 'Submit' button the page shows 'Received' text

    
    public String verifyText () {
		return verifytext.getText();		
	}	
    
  
    
    //7.Verify that on submit of form all the data passed to the URL

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
