package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.CommonMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static utilities.CommonMethods.extractNumber;

public class WeightTrackFieldPage {

    WebDriver driver;
    private static Logger logger = LogManager.getLogger();

    public WeightTrackFieldPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    By activityInsightBtn = By.xpath("//span[text()='Activity Insights']/parent::button");
    By weightTrackingBtn = By.xpath("//a[contains(@href,'/track/weight')]");
    By actualHeaderText = By.xpath("//h1[text()='Weight Tracking']");
    By subText = By.xpath("//p[normalize-space(.)='free Plan - 7 Days Tracking']");
    By backToDashBoardBtn = By.xpath("//*[contains(text(),'Back to Dashboard')]");
    By cards = By.xpath("//div[@class='p-4']");
    By startingWeightText =By.xpath("//p[normalize-space()='Starting Weight']");
    By currentWeightText = By.xpath("//p[normalize-space()='Current Weight']");
    By lastestLogWeight = By.xpath("//p[@class='font-medium text-gray-900']");
    By goalWeightText = By.xpath("//p[normalize-space()='Goal Weight']");


    public void loginToPortal() {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("herbalanceteam1@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("herbalance1@");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void navigateToActivityInsight() throws InterruptedException {
        Thread.sleep(2000);
        CommonMethods.webClickByLocator(activityInsightBtn);
        CommonMethods.webClickByLocator(weightTrackingBtn);

    }

    public String getHeaderText() {
        String actualHeader = driver.findElement(actualHeaderText).getText();
        return actualHeader;
    }

    public String getSubText() {
        return driver.findElement(subText).getText();
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
        String elementName =cardName;
        List<String> cardNames = new ArrayList<>();
        for (WebElement card : cardsList) {
            String getCardTextElement =driver.findElement(By.xpath("//p[text()='"+elementName+"']")).getText();
            cardNames.add(card.getText().trim());
        }
        return cardNames;
    }

    public double verifyStartWeight(){
        String startWeight = driver.findElement(startingWeightText).getText();
        double startWeightValue = extractNumber(startWeight);
        return startWeightValue;
    }
    public double verifyCurrentWeight(){
        String currentWeight = driver.findElement(currentWeightText).getText();
        double currentWeightValue = extractNumber(currentWeight);
        return currentWeightValue;
    }
    public Object getLatestLogWeight(){
        List<WebElement> logWeights = driver.findElements(lastestLogWeight);
        if (logWeights.isEmpty()){
            return null;
        }
        String text = logWeights.get(0).getText();
        return extractNumber(text);

    }

    public void getGoalWeight(){

    }
}
