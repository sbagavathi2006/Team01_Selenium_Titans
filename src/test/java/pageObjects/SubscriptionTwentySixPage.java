package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionTwentySixPage {

    WebDriver driver;
    CommonMethods commonMethods;

    public SubscriptionTwentySixPage(WebDriver driver) {
        this.driver = driver;
        commonMethods = new CommonMethods(driver);
    }

    By emailId = By.name("username");
    By password = By.name("password");
    By loginButton = By.xpath("//button[text()='LogIn']");


    By profileSubMenu = By.xpath("(//button[@type ='button']/span)[1]");
    By subscriptionOption = By.xpath("//a[@href='/subscription']");
    By SubManagementText = By.xpath("//h1[contains(text(),'Subscription Management')]");
    By visibileSectionList = By.xpath("//div[@class='max-w-7xl mx-auto py-8 px-4 sm:px-6']/div/div/h3");
    By currentSubsText = By.xpath("//h3[contains(text(),'Current Subscription')]");

    public void loginToPortal() {
        commonMethods.loginFromOnBoarding();
        commonMethods.waitForPopupToDisappear();
    }

    public void clickProfileSubMenu() {
        driver.findElement(profileSubMenu).click();
    }

    public void selectSubscription() {
        commonMethods.waitForClickable(subscriptionOption);
        driver.findElement(subscriptionOption).click();
    }

    public String VerifySubManagementTxt() {
        return commonMethods.getText(SubManagementText);
    }


    public List<WebElement> getAllSections() {
        return driver.findElements(visibileSectionList);
    }

    public List<String> verifySectionHeaders(String sectionName) {
        List<WebElement> uiElementsList = driver.findElements(visibileSectionList);
        List<String> matchedResults = new ArrayList<>();

        for (WebElement element : uiElementsList) {
            String uiText = element.getText().trim();
            if (uiText.equalsIgnoreCase(sectionName.trim())) {
                matchedResults.add(uiText);
                break;
            }
        }
        return matchedResults;
    }

    public String getCurrentSubsHeaderTxt() {
        return commonMethods.getText(currentSubsText);
    }

}


