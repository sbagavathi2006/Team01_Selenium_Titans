package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CommonMethods;

import java.util.ArrayList;
import java.util.List;

import static utilities.CommonMethods.extractNumber;

public class WeightTrackPage {

	WebDriver driver;
	CommonMethods commonMethods;
	private static Logger logger = LogManager.getLogger();

	public WeightTrackPage(WebDriver driver) {
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);

	}

	By activityInsightBtn = By
			.xpath("//div[@class='max-w-7xl mx-auto flex items-center justify-center space-x-4']/button");
	By weightTrackLink = By.xpath("//a[@href='/track/weight']");
	By actualHeaderText = By.xpath("//h1[contains(text(),'Weight Tracking')]");
	By subText = By.xpath(
			"//p[contains(@class, 'capitalize') and contains(normalize-space(), 'free Plan - 7 Days Tracking')]");
	By backToDashBoardBtn = By.xpath("//*[contains(text(),'Back to Dashboard')]");
	By cards = By.xpath("//div[@class='p-4']");
	By startingWeightText = By.xpath("//p[normalize-space()='Starting Weight']");
	By currentWeightText = By.xpath("//p[contains(text(), 'Current Weight')]");
	By lastestLogWeight = By.xpath("//p[@class='font-medium text-gray-900']");
	By goalWeightText = By.xpath("//p[normalize-space()='Goal Weight']");
	By progressOverviewText = By.xpath("//h3[text()='Progress Overview']");
	By weightLossprogress = By.xpath("//span[text()='Weight Loss Progress']");
	By completionPercentage = By.xpath("(//span[contains(@class, 'text-violet-600')])[1]");
	By weightLostField = By.xpath("//p[contains(text(),'Weight Lost')]");
	By remainingWeightField = By.xpath("//p[contains(text(),'Remaining')]");
	By WeightProgressGraph = By.xpath("//h3[contains(text(),'Weight Progression Over Time')]");
	By xAxislabel = By.xpath("//div[@class='recharts-wrapper']//*[name()='svg'][1]/*[name()='g'][2]");
	By yAxislabel = By.xpath("//*[name()='tspan' and normalize-space(.)='Weight (kg)']");
	By logSectionHeader = By.xpath("//button[normalize-space(.)=\"Log Today's Weight\"]");
	By trackingdateField = By.xpath("(//*[text()='D'])[1]");
	By weightInputField = By.xpath("//input[@id='weight']");
	By logWeightBtn = By.xpath("//button[text()='Log Weight']");
	By bmiInputField = By.xpath("//input[@type='text']");
	By graphLine = By.xpath("//*[name()='path' and contains(@class,'recharts-line-curve')]");
	By errorMessage = By.xpath("//div[starts-with(normalize-space(.), 'Please enter a valid weight')]");

	public void loginToPortal() {
		commonMethods.loginFromOnBoarding();
		commonMethods.waitForPopupToDisappear();
	}

	public void activityInsightToBeClickable() {
		commonMethods.webClickByLocator(activityInsightBtn);
	}

	public void navigateToActivityInsight() {
		commonMethods.webClickByLocator(activityInsightBtn);
	}

	public void clickWeightTrackingBtn() {
		commonMethods.webClickByLocator(weightTrackLink);
	}

	public String getHeaderText() {
		WebElement headerText = CommonMethods.waitForVisibility(actualHeaderText);
		String actualHeader = headerText.getText();
		return actualHeader;
	}

	public String getSubText() {
		WebElement subTextElement = commonMethods.waitForVisibility(subText);
		return subTextElement.getText();
	}

	public void checkBackToDdBtn() {
		boolean isDisplayed = driver.findElement(backToDashBoardBtn).isDisplayed();
		if (isDisplayed) {
			logger.info("Back to Dashboard button is displayed");
		} else {
			logger.error("Back to dashBoard button is not displayed");
		}

	}

	public List<String> getCardText(String cardName) {
		List<WebElement> cardsList = driver.findElements(cards);
		List<String> cardNames = new ArrayList<>();
		for (WebElement card : cardsList) {
			String text = card.getText();
			if (text != null && !text.trim().isEmpty()) {
				cardNames.add(text.trim());
			}
		}
		return cardNames;
	}

	public double verifyStartWeight() {
		String startWeight = driver.findElement(startingWeightText).getText();
		double startWeightValue = extractNumber(startWeight);
		return startWeightValue;
	}

	public double verifyCurrentWeight() {
		WebElement element = commonMethods.waitForVisibility(currentWeightText);
		String currentWeight = commonMethods.waitForVisibility(element).getText().trim();
		return extractNumber(currentWeight);
	}

	public Object getLatestLogWeight() {
		List<WebElement> logWeights = driver.findElements(lastestLogWeight);
		if (logWeights.isEmpty()) {
			return null;
		}
		String text = logWeights.get(0).getText();
		try {
			return extractNumber(text);
		} catch (Exception e) {
			logger.error("Failed to parse latest log weight from text: " + text, e);
			return null;
		}
	}

	public String getGoalWeight() {
		return driver.findElement(goalWeightText).getText();
	}

	public String getProgressOverview() {
		return driver.findElement(progressOverviewText).getText();
	}

	public Boolean getWeightLossProgrees() {
		return commonMethods.isDisplayed(weightLossprogress);
	}

	public Boolean getCompletionPercentage() {

		try {
			WebElement element = commonMethods.waitForVisibility(completionPercentage);
			String text = element.getText();
			return text != null && text.contains("%") && element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean getWeightLostField() {
		return commonMethods.isDisplayed(weightLostField);
	}

	public Boolean getRemainingWeightField() {
		return commonMethods.isDisplayed(remainingWeightField);
	}

	public Boolean getGraphSectionHeader() {
		return commonMethods.isDisplayed(WeightProgressGraph);
	}

	public String getxAxisValues(String values) {
		try {
			By locator = By
					.xpath("//*[name()='svg']//*[name()='tspan' and contains(normalize-space(.), '" + values + "')]");

			WebElement element = commonMethods.waitForPresence(locator);

			if (element != null && element.isDisplayed()) {
				String text = element.getText().trim();
				System.out.println("DEBUG: Found X-Axis text: " + text);
				return text;
			}
		} catch (Exception e) {
			logger.error("Failed to get X-Axis value '" + values + "'. Exception: " + e.getMessage());
		}
		return "";
	}

	public Boolean getyaxislabel() {
		try {
			return commonMethods.waitForVisibility(yAxislabel).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean getLogSectionFields(String input, String inputField) {
		try {
			By locator = By.xpath("//label[@for='" + input + "' and normalize-space()='" + inputField + "']");
			WebElement element = commonMethods.waitForVisibility(locator);
			return element.isDisplayed();
		} catch (Exception e) {
			logger.error("Failed to find label: " + inputField);
			return false;
		}
	}

	public Boolean getCurrentTrackingDate() {
		return commonMethods.isDisplayed(trackingdateField);
	}

	public Boolean getLogWeightBtn() {
		Boolean logWeightBtnStatus = driver.findElement(logWeightBtn).isEnabled();
		return logWeightBtnStatus;
	}

	public void enterWeightValue(String weight) {
		commonMethods.waitForVisibility(weightInputField);
		driver.findElement(weightInputField).sendKeys(weight);
	}

	public String getBMIValue() {
		return driver.findElement(bmiInputField).getAttribute("value");
	}

	public Boolean getLogWeightBtnStatus() {
		Boolean logWeightBtnStatus = driver.findElement(logWeightBtn).isEnabled();
		return logWeightBtnStatus;
	}

	public void clickLogWeightButton() {
		commonMethods.webClickByLocator(logWeightBtn);

	}

	public String getGraphDValue() {
		return driver.findElement(graphLine).getAttribute("d");
	}

	public boolean verifyErrorMessage() {
		try {
			WebElement el = commonMethods.waitForVisibility(errorMessage);
			return el != null && el.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
