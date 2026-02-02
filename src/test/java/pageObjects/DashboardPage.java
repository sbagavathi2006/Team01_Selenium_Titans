package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CommonMethods;

public class DashboardPage {

	private WebDriver driver;
	private CommonMethods commonMethods;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);
		}
	
	// temporary login locators
	By emailId = By.name("username");
	By password = By.name("password");
	By loginButton = By.xpath("//button[text()='LogIn']");
	    
	By dashboardTitle = By.xpath("//*[contains(text(), 'Free Plan Dashboard')]");
	By dashboardUserName = By.xpath("//span[@class='text-[#6A5ACD] group-hover:text-[#9370DB] font-medium']");
	By dashboardProfileIcon = By.xpath("//div[@class='h-8 w-8 rounded-full bg-[#6A5ACD] flex items-center justify-center mr-2']//*[name()='svg']//*[name()='path' and contains(@d,'M19 21v-2a')]");
	By dashboardBellIcon = By.xpath("//button[@class='relative p-2 rounded-full bg-white/10 backdrop-blur-lg border border-white/20 hover:bg-white/20 transition-all']//*[name()='svg']");
	
	By activityInsightsSubTab = By.xpath("//*[contains(text(),'Activity Insights')]");
	
	
	    //***********temporary login flow
	    
	   public void tempLogin() {
		   driver.findElement(emailId).sendKeys("mathumqa@gmail.com");
		   driver.findElement(password).sendKeys("Success@1");
		   driver.findElement(loginButton).click();	   
		   commonMethods.waitForVisibility(dashboardTitle);
	   }
	   
	   
	   public String getTitle() {
		return commonMethods.getText(dashboardTitle);	   
	   }
	   
	   
	   public void clickTrackWeight() {
		   commonMethods.click(activityInsightsSubTab);
		   
	   }
	   

	   public String getDashboardUserName() {
		   return commonMethods.getText(dashboardUserName);
	   }
		
	   public boolean isIconDisplayed() {
		  return commonMethods.isDisplayed(dashboardProfileIcon);
	   }
	   
	   public boolean isBellIconDisplayed() {
		   return commonMethods.isDisplayed(dashboardBellIcon);
	   }
	   
	  
	   
}
