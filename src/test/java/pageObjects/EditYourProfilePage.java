package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CommonMethods;

public class EditYourProfilePage {

	
	private WebDriver driver;
	private CommonMethods commonMethods;
	
	public EditYourProfilePage(WebDriver driver) {
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);
		}
	
	
	By dashboardUserName = By.id("radix-:r9:");
	By editProfileLink = By.xpath("//a[@href='/profile/edit']");
	By editProfileText = By.xpath("//h1[@class='text-2xl font-semibold text-[#6A5ACD] mt-2']");
	By editProfileSubText = By.xpath("//p[@class='text-gray-600']");
	By editProfileTabs = By.xpath("//div[@role='tablist']/button");
	By editProfileBasicInfo = By.xpath("//button[normalize-space()='Basic Information']");
	By editProfileBack = By.xpath("//div[@class='mb-6']/button");
	By BasicInfoSubText = By.xpath("//p[@class='text-sm text-muted-foreground']");
	By basicInfoNextTab = By.xpath("//div[@class='flex justify-end']/button");
	By bodyMetricsTab = By.xpath("//button[normalize-space()='Body Metrics']");
	By basicInfoName = By.xpath("//input[@id='name']");
	By basicInfoAge = By.xpath("//input[@id='age']");
	By editProfileBackSub = By.xpath("//div[@class='flex justify-between']/button[contains(text(),'Back')]");
	By bodyMetricsWeight = By.xpath("//input[@id='weight']");
	By bodyMetricsHeight = By.xpath("//input[@id='height']");
	By bodyMetricsWeightDD = By.xpath("//div[@role='presentation']/div/span/following-sibling::span");
	
	
	public void clickUName() {
		 commonMethods.click(dashboardUserName);
	}
	
	public void clickEditProfile() {
		commonMethods.waitForClickable(editProfileLink);
		commonMethods.click(editProfileLink);
	}
	
	public String getEditProfileText() {
		return commonMethods.getText(editProfileText);
	}
	
	public String getEditProfileSubText() {
		return commonMethods.getText(editProfileSubText);
	}

	public List<String> getEditYourProfileTabs(){
		   return commonMethods.getElementsListText(editProfileTabs);
	   }
	
	public boolean basicInfoTabIsDisplayed() {
		return commonMethods.isDisplayed(editProfileBasicInfo);
	}
	
	public String getBasicInfoText() {
		return commonMethods.getText(editProfileBasicInfo);
	}
 
	public boolean backIsDisplayed() {
		return commonMethods.isDisplayed(editProfileBack);
	}
	
	public void clickBackButton() {
		commonMethods.waitForClickable(editProfileBack);
		commonMethods.click(editProfileBack);
	}
	
	public String getBasicInfoSubText() {
		return commonMethods.getText(BasicInfoSubText);
	}
	
	public void clickNextBodyMetrics() {
		commonMethods.click(basicInfoNextTab);
	}
	
	public String getBodyMetricsText() {
		return commonMethods.getText(bodyMetricsTab);
	}
	
	public String getBasicInfoName() {
		commonMethods.waitForPresence(basicInfoName);
		return driver.findElement(basicInfoName).getAttribute("value");
	}
	
	public String getBasicInfoAge() {
		commonMethods.waitForPresence(basicInfoAge);
		return driver.findElement(basicInfoAge).getAttribute("value");
	}
	
	public void clickBackSub() {
		commonMethods.click(editProfileBackSub);
	}
	
	public void clickBodyMetricsTab() {
		commonMethods.click(bodyMetricsTab);
	}
	
	public String getBodyMetricsWeight() {
		commonMethods.waitForPresence(bodyMetricsWeight);
		return driver.findElement(bodyMetricsWeight).getAttribute("value");
	}
	
	public String getBodyMetricsHeight() {
		commonMethods.waitForPresence(bodyMetricsHeight);
		return driver.findElement(bodyMetricsHeight).getAttribute("value");
	}
	
	public List<String> getBodyMetricsWeightDD(){
		return commonMethods.getElementsListText(bodyMetricsWeightDD);
	}
	
	
}
