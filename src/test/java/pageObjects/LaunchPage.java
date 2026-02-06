package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CommonMethods;

public class LaunchPage {

	private WebDriver driver;
	private CommonMethods common;

	public LaunchPage(WebDriver driver) {
		this.driver = driver;
		this.common = new CommonMethods(driver);
	}

	private By loginButton = By.xpath("//button[contains(text(),'Log In')]");

	private By signUpButton = By.xpath("//button[contains(text(),'Sign Up')]");

	private By getStartedNowButton = By.xpath("//*[contains(text(),'Get Started Now')]");

	private By startPersonalizedJourneyButton = By.xpath("//*[contains(text(),'Start Your Personalized Journey')]");

	private By cycleTrackingAppSection = By.xpath("//*[contains(text(),'Cycle Tracking App')]");
	private By empowerInfoText = By
			.xpath("//p[contains(normalize-space(.),'Hormonal shifts during your menstrual cycle')]");
	private By syncWeightLossImagesSection = By.xpath("//img[@alt='Workout Exercises for Women']");
	private By body = By.tagName("body");

	public boolean isLoginButtonVisible() {
		return driver.findElement(loginButton).isDisplayed();
	}

	public boolean isSignUpButtonVisible() {
		return driver.findElement(signUpButton).isDisplayed();
	}

	public String getBackgroundColor() {
		return driver.findElement(body).getCssValue("background-color");
	}

	public boolean isTextContentPresent() {
		return driver.findElements(By.xpath("//*[text()]")).size() > 0;
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public void clickSignUp() {
		driver.findElement(signUpButton).click();
	}

	public boolean isGetStartedNowButtonVisible() {
		return scrollAndCheck(getStartedNowButton);
	}

	public boolean isStartPersonalizedJourneyButtonVisible() {
		return scrollAndCheck(startPersonalizedJourneyButton);
	}

	public void clickGetStartedNow() {
		WebElement element = driver.findElement(getStartedNowButton);
		common.scrollIntoViewWait(element);
		element.click();
	}

	public void clickStartPersonalizedJourney() {
		WebElement element = driver.findElement(startPersonalizedJourneyButton);
		common.scrollIntoViewWait(element);
		element.click();
	}

	public boolean isCyclePhaseVisible(String phase) {
		By locator = By.xpath("//*[contains(text(),'" + phase + "')]");
		WebElement element = driver.findElement(locator);
		common.scrollIntoViewWait(element); // scroll + wait
		return element.isDisplayed();
	}

	public boolean isCycleTrackingAppVisible() {
		return scrollAndCheck(cycleTrackingAppSection);
	}

	public boolean isSyncWeightLossImagesVisible() {
		return scrollAndCheck(syncWeightLossImagesSection);
	}

	public boolean isEmpowerTextVisible() {
		return scrollAndCheck(empowerInfoText);
	}

	private boolean scrollAndCheck(By locator) {
		WebElement element = driver.findElement(locator);
		common.scrollIntoViewWait(element);
		return element.isDisplayed();
	}

}
