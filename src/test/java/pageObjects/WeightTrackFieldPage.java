package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WeightTrackFieldPage {

    WebDriver driver;

    public WeightTrackFieldPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[contains(text(), 'Activity Insights')]")
    WebElement activityInsightBtn

    public void loginToPortal() {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("herbalanceteam1@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("herbalance1@");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }


    public void navigateToActivityInsight() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(), 'Activity Insights')]")));
                menu.click();
       // driver.findElement(By.xpath("//button[contains(text(),'Activity Insights')]")).click();
        driver.findElement(By.xpath("//a[@href='/track/weight']")).click();
    }

    public void getHeaderText(String expectedHeader) {
        String actualHeader = driver.findElement(By.xpath("//h1[text()='Weight Tracking']")).getText();
    }
}
