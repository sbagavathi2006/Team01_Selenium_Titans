package pageObjects;

import org.openqa.selenium.WebDriver;

import utilities.CommonMethods;

public class EditYourProfilePage {

	
	private WebDriver driver;
	private CommonMethods commonMethods;
	
	public EditYourProfilePage(WebDriver driver) {
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);
		}
	
	
}
