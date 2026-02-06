package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CommonMethods;

public class OnBoarding8Page {

	private WebDriver driver;
	private CommonMethods commonMethods;
	private By radioBtnPescatarian = By.xpath("//*[contains(text(),'Pescatarian Diet')]");
	private By radioBtnNonVegetarian = By.xpath("//*[contains(text(),'Non-Vegetarian')]");
	private By radioBtnVegetarian = By.xpath("//*[contains(text(),'Vegetarian Diet')]");
	private By radioBtnVegan = By.xpath("//*[contains(text(),'Vegan Diet')]");
	private By continueButton = By.xpath("//*[contains(text(),'Continue')]");
	private By progressBar = By.xpath("//span[normalize-space()='9 of 10']");
	private By titleStep9 = By.xpath("//*[contains(text(),'Physical Activity Level')]");
	private By descriptionText = By.xpath("//*[contains(text(),'Help us understand')]");
	private By sedentaryRadioBtn = By.xpath("//*[contains(text(),'Sedentary')]");
	private By lightlyActiveRadioBtn = By.xpath("//*[contains(text(),'Lightly Active')]");
	private By moderately_activeRadioBtn = By.xpath("//*[contains(text(),'Moderately Active')] ");
	private By veryactiveRadioBtn = By.xpath("//*[contains(text(),'Very Active')]");
	private By sedentaryRadioBtnText = By.xpath("//*[contains(text(),'Little to no regular exercise')]");
	private By lightlyActiveRadioBtnText = By.xpath("//*[contains(text(),'Light exercise 1-3 days per week')]");
	private By moderately_activeRadioBtnText = By.xpath("//*[contains(text(),'Moderate exercise 3-5 days per week')]");
	private By veryactiveRadioBtnText = By.xpath("//*[contains(text(),'Hard exercise 6-7')]");
	private By infoNote = By.xpath("//*[contains(text(),'Your activity level helps us design a fitness')]");
	private By verify_step7 = By.xpath("//span[normalize-space()='7 of 10']");

	public OnBoarding8Page(WebDriver driver) {
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);
	}

	private Map<String, By> radioButtons() {
		Map<String, By> map = new HashMap<>();
		map.put("PescatarianDiet", radioBtnPescatarian);
		map.put("Non-Vegetarian", radioBtnNonVegetarian);
		map.put("VegetarianDiet", radioBtnVegetarian);
		map.put("VeganDiet", radioBtnVegan);
		return map;
	}

	public WebElement getDietRadio(String dietOption) {
		By locator = radioButtons().get(dietOption);

		if (locator == null) {
			throw new IllegalArgumentException("Invalid diet option: " + dietOption);
		}

		return commonMethods.waitForClickable(locator);
	}

	public void selectDietOption(String dietOption) {
		WebElement radio = getDietRadio(dietOption);

		if (!radio.isSelected()) {
			radio.click();
		}
	}

	public boolean isDietOptionSelected(String dietOption) {
		WebElement radioButton = getDietRadio(dietOption);
		return radioButton.isSelected();
	}

	public boolean isContinueButtonEnabled() {
		return driver.findElement(continueButton).isEnabled();
	}

	private Map<String, By> step9ElementMap() {
		Map<String, By> map = new HashMap<>();
		map.put("ProgressBar", progressBar);
		map.put("Titleofstep9", titleStep9);
		map.put("Descriptionstep9", descriptionText);
		map.put("SedentaryRadioButton", sedentaryRadioBtn);
		map.put("LightlyActiveRadioButton", lightlyActiveRadioBtn);
		map.put("ModeratelyActiveRadioButton", moderately_activeRadioBtn);
		map.put("VeryActiveRadioButton", veryactiveRadioBtn);
		map.put("SedentaryTxt", sedentaryRadioBtnText);
		map.put("LightlyTxt", lightlyActiveRadioBtnText);
		map.put("ModeratelyTxt", moderately_activeRadioBtnText);
		map.put("VeryActiveTxt", veryactiveRadioBtnText);
		map.put("Infonote", infoNote);
		return map;
	}

	public boolean verifyUIElements_forStep9(String elementName) {
		By locator = step9ElementMap().get(elementName);
		if (locator == null) {
			throw new IllegalArgumentException("No locator found for: " + elementName);
		}

		return commonMethods.isDisplayed(locator);
	}

	public void selectPescatarianDietDietOption() {
		commonMethods.click(radioBtnPescatarian);

	}

	public String verify_step8back_button() {
		return commonMethods.getText(verify_step7);

	}

}
