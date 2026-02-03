package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonMethods;

import java.time.Duration;

public class WeightTrackFieldPage {

    WebDriver driver;
    private static Logger logger = LogManager.getLogger();

    public WeightTrackFieldPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    By activityInsightBtn = By.xpath("//span[text()='Activity Insights']/parent::button");;
    By weightTrackingBtn = By.xpath("//a[contains(@href,'/track/weight')]");
    By actualHeaderText = By.xpath("//h1[text()='Weight Tracking']");
    By subText = By.xpath("//p[contains(., '7 Days Tracking')]");
    By backToDashBoardBtn = By.xpath("//a[@class='text-sm']");

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
       String actualHeader =driver.findElement(actualHeaderText).getText();
      return actualHeader;
    }

    public String getSubText(){
        return driver.findElement(subText).getText();
    }

    public void checkBackToDdBtn(){
        boolean isDisplayed = driver.findElement(backToDashBoardBtn).isDisplayed();
        if(isDisplayed){
            logger.info("Back to Dashboard button is displayed");
        }else{
            logger.error("Back to dashBoard button is not displayed");
        }
    }
}
