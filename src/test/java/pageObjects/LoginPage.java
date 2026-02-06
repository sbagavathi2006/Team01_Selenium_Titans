package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactorySetUp.DriverFactory;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	public LoginPage() {
		this.driver = DriverFactory.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private By loginButton = By.xpath("//button[contains(text(),'Log In')]");
	public By email = By.name("username");
	private By password = By.name("password");
	private By loginTab = By.xpath("//button[contains(text(),'Login')]");
	private By loginButtonOnLogin = By.xpath("//button[contains(text(),'LogIn')]");
	private By showPwd = By.xpath("//label[contains(text(),'Show password')]");
	private By logo = By.cssSelector("header img");
	private By forgotPwd = By.xpath(" //button[contains(text(),'Forgot password?')]");
	private By signUpLink = By.xpath("//button[text()='Sign up']");
	private By tabs = By.xpath("//button[@role='tab']");
	private By errorMsgs = By.xpath("//*[contains(text(),'Invalid') or contains(text(),'required')]");
	private By allTextboxes = By.xpath("//div[@class='space-y-2']//input");
	private By rightPanelHeading = By.xpath("//h2[text()='Transform Your Weight Loss Journey']");
	private By cycleSyncedPlans = By.xpath("//h3[text()='Cycle-Synced Plans']");
	private By bloodWorkAnalysis = By.xpath("//h3[text()='Blood Work Analysis']");
	private By personalizedDashboard = By.xpath("//h3[text()='Personalized Dashboard']");
	private By testimonialText = By.xpath("//p[contains(text(),'After 3 months with HerBalance')]");
	private By testimonialName = By.xpath("//p[contains(text(),'Sarah')]");

	private WebElement waitFor(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void enterEmail(String val) {
		WebElement el = waitFor(email);
		el.clear();
		el.sendKeys(val);
	}

	public void enterPassword(String val) {
		WebElement el = waitFor(password);
		el.clear();
		el.sendKeys(val);
	}

	public void clickLoginONLanch() {
		waitFor(loginButton).click();
	}

	public void clickLogin() {
		waitFor(loginButtonOnLogin).click();
	}

	public void clickLoginTab() {
		waitFor(loginTab).click();
	}

	public void toggleShowPassword() {
		waitFor(showPwd).click();
	}

	public String getPasswordType() {
		return waitFor(password).getDomAttribute("type");
	}

	public void clickForgotPassword() {
		waitFor(forgotPwd).click();
	}

	public void clickTab(String tabName) {
		List<WebElement> list = driver.findElements(tabs);
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(tabName)) {
				el.click();
				break;
			}
		}
	}

	public boolean isLogoDisplayed() {
		return waitFor(logo).isDisplayed();
	}

	public boolean isLoginTabActive() {
		return driver.findElements(tabs).get(0).getAttribute("class").contains("active");
	}

	public int getTabCount() {
		return driver.findElements(tabs).size();
	}

	public int getNumberOfInputFields() {
		return driver.findElements(allTextboxes).size();
	}

	public List<WebElement> getTabs() {
		return driver.findElements(tabs);
	}

	public boolean isEmailFieldVisible() {
		return driver.findElement(email).isDisplayed();

	}

	public boolean isPasswordInputFieldVisible() {
		return driver.findElement(email).isDisplayed();
	}

	public boolean isShowPasswordVisible() {
		return driver.findElement(showPwd).isDisplayed();
	}

	public boolean isLoginButtonVisible() {
		return driver.findElement(loginTab).isDisplayed();
	}

	public boolean isLoginTabVisible() {
		return driver.findElement(loginTab).isDisplayed();
	}

	public boolean isLoginTabEnabled() {
		return driver.findElement(loginTab).isEnabled();
	}

	public boolean isForgotPasswordVisible() {
		return driver.findElement(forgotPwd).isDisplayed();
	}

	public boolean isSignUpVisible() {
		return driver.findElement(signUpLink).isDisplayed();
	}

	public WebElement getEmailField() {
		return driver.findElement(email);
	}

	public WebElement getPasswordField() {
		return driver.findElement(password);
	}

	public boolean isRightPanelHeadingDisplayed() {
		return driver.findElement(rightPanelHeading).isDisplayed();
	}

	public boolean isCycleSyncedPlansDisplayed() {
		return driver.findElement(cycleSyncedPlans).isDisplayed();
	}

	public boolean isBloodWorkAnalysisDisplayed() {
		return driver.findElement(bloodWorkAnalysis).isDisplayed();
	}

	public boolean isPersonalizedDashboardDisplayed() {
		return driver.findElement(personalizedDashboard).isDisplayed();
	}

	public String getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgs));
		List<WebElement> errors = driver.findElements(errorMsgs);
		if (errors.isEmpty()) {
			throw new RuntimeException("Expected error message but none was displayed");
		}
		return errors.get(0).getText();
	}

	public List<String> getValidationMessages() {
		return driver.findElements(errorMsgs).stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public boolean isTestimonialDisplayed(String name, int age) {
		String nameText = driver.findElement(testimonialName).getText();
		return driver.findElement(testimonialText).isDisplayed() && nameText.contains(name + ", " + age);
	}

	public boolean areEmailAndPasswordVerticallyAligned() {

		WebElement emailField = getEmailField();
		WebElement passwordField = getPasswordField();

		Point emailLocation = emailField.getLocation();
		Point passwordLocation = passwordField.getLocation();

		Dimension emailSize = emailField.getSize();
		Dimension passwordSize = passwordField.getSize();

		return emailLocation.getX() == passwordLocation.getX() && passwordLocation.getY() > emailLocation.getY()
				&& emailSize.getWidth() == passwordSize.getWidth();
	}

}
