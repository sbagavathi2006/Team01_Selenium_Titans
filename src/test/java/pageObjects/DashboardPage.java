package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	By dashboardSearchBar = By.xpath("//input[@placeholder='Search...']");
	By dashboardButtons = By.xpath("//button");
	By dashboardPlanText = By.xpath("//div[@class='mb-8']/div/p");
	By dashboardSectionTitle = By.xpath("//div[@class='grid grid-cols-1 md:grid-cols-2 gap-6']/div//div[@class='flex items-center']/span");
	By dashboardWeight = By.xpath("//*[@class='lucide lucide-scale h-4 w-4 text-[#9370DB] mr-1.5']/parent::div/following-sibling::p");
	By dashboardHeight = By.xpath("//*[@class='lucide lucide-ruler h-4 w-4 text-[#9370DB] mr-1.5']/parent::div/following-sibling::p");
	By dashboardBmi = By.xpath("//*[@class='lucide lucide-activity h-4 w-4 text-[#9370DB] mr-1.5']/parent::div/following-sibling::p[1]");
	By dashboardCurrentWeight = By.xpath("//*[@class='lucide lucide-scale h-4 w-4 text-green-600 mr-1.5']/parent::div/following-sibling::p");
	By dashboardGoalWeight = By.xpath("//span[contains(text(),'Goal:')]");
	By dashboardSubscription = By.xpath("//*[@class='lucide lucide-trending-down h-4 w-4 text-[#9370DB] mr-1.5']/ancestor::div[@class='flex items-center']/following-sibling::span");
	By dashboardInfo = By.xpath("//h3[@class='text-sm font-medium text-gray-700']/following-sibling::span[@class='text-xs bg-[#9370DB] text-white px-2 py-0.5 rounded-full']");
	By dashboardFreePlanInfor = By.xpath("//div[@class='text-xs text-gray-500 mt-1 italic text-center']");
	By dashboardSlider = By.xpath("//div[@class='relative h-8 rounded-md mb-2']");
	By dashboardSliderCategory = By.xpath("//div[@class='relative h-8 rounded-md mb-2']/following-sibling::div");
	By dashboardHealthConditionText = By.xpath("//p[@class='text-xs text-gray-600 leading-relaxed']");
	By dashboardNoHealthText = By.xpath("//span[normalize-space()='Health Conditions']/ancestor::div[@class='flex flex-col space-y-1.5 p-6 bg-[#F8F5FF] pb-3 pt-4 px-4']/following-sibling::div//p[@class='text-sm font-semibold text-green-600 mb-1']");
	By dashboardUploadBloodReport = By.xpath("//button[@data-testid='button-upload-blood-report']");
	By dashboardUploadBloodReportMessage = By.xpath("//p[@class='text-sm text-gray-500 mb-6 max-w-sm']");
	By dashboardSubJoinedDate = By.xpath("//p[normalize-space()='Joined Date']/parent::div/following-sibling::p[@class='text-sm font-medium']");
	By dashboardSubTodayDate = By.xpath("//p[contains(normalize-space(.), \"Today's Date\")]/parent::div/following-sibling::p[@class='text-sm font-medium']");
	By dashboardSubPlanName = By.xpath("//span[@class='font-medium text-sm']");
	By dashboardSubUpgrade = By.xpath("//*[contains(text(),'Upgrade to Premium')]");
	By dashboardviewFullCycyle = By.xpath("//span[normalize-space()='View Full Cycle Details']");
	By dashboardMenstrualCycle = By.xpath("//h1[@class='text-4xl font-bold text-[#6A5ACD] mb-4 md:mb-0']");
	By dashboardMenstrualInfo = By.xpath("//div[@class='text-xs text-gray-400 mt-1 text-center']");
	
	

	By activityInsightsSubTab = By.xpath("//*[contains(text(),'Activity Insights')]");
	
	
	    //***********temporary login flow
	    
	   public void Login(String uName, String pwd) {
		   driver.findElement(emailId).sendKeys(uName);
		   driver.findElement(password).sendKeys(pwd);
		   driver.findElement(loginButton).click();	   
		//   commonMethods.waitForVisibility(dashboardTitle);
		   commonMethods.waitForPopupToDisappear();
	   }
	   
	   
	   public String getTitle() {
		return commonMethods.getText(dashboardTitle);	   
	   }
	   
	   public void clickTrackWeight() {
		   commonMethods.click(activityInsightsSubTab);}
	   
	   public String getDashboardUserName() {
		   return commonMethods.getText(dashboardUserName);
	   }
		
	   public boolean isIconDisplayed() {
		  return commonMethods.isDisplayed(dashboardProfileIcon);
	   }
	   
	   public boolean isBellIconDisplayed() {
		   return commonMethods.isDisplayed(dashboardBellIcon);
	   }
	   
	   public boolean isSearchBarDisplayed() {
		   return commonMethods.isDisplayed(dashboardSearchBar);
	   }
	  
	   public int getMenusCount() {
		   return commonMethods.getElementsCount(dashboardButtons);
	   }
	   
	   public List<String> getMenusText() {
		   return commonMethods.getElementsListText(dashboardButtons);
	   }
	   
	   public List<String> getDashboardPlansText(){
		   return commonMethods.getElementsListText(dashboardPlanText);
	   }
	   
	   public String checkAlign() {
		   return  driver.findElement(dashboardPlanText).getCssValue("text-align");
		   
	   }
	   
	   public List<String> getDashboardSectionText(){
		   return commonMethods.getElementsListText(dashboardSectionTitle);
	   }
	   
	   public By getDashboardBodyWeightSubTitle(String subTitle) {
			return By.xpath("//*[normalize-space(text())='" + subTitle + "']");
	   }
	   
	   public List<String> getDashboardBodySectionTitle(String subTitle) {
		   return commonMethods.getElementsListText(getDashboardBodyWeightSubTitle(subTitle));
	   }
	   
	   public String getDashboardCustomText(String subTitle) {
		   return commonMethods.getText(getDashboardBodyWeightSubTitle(subTitle));
	   }
	   
	   public String getDashboardWeight() {
		   return commonMethods.getText(dashboardWeight).split(" ")[0];
	   }
	   
	   public String getDashboardHeight() {
		   return commonMethods.getText(dashboardHeight).split(" ")[0];
	   }
	   
	   public String getDashboardBMI() {
		   return commonMethods.getText(dashboardBmi).split(" ")[0];
	   }
	   
	   public String getDashboardCurrentWeight() {
		   return commonMethods.getText(dashboardCurrentWeight);
	   }
	   
	   public String getDashboardGoalWeight() {
		   commonMethods.waitForVisibility(dashboardGoalWeight);
		   return commonMethods.getText(dashboardGoalWeight);
	   }
	   
	   public String getDashboardSubscription() {
		   return commonMethods.getText(dashboardSubscription);
	   }
	   
	   public String getDashboardInfo() {
		   return commonMethods.getText(dashboardInfo);
	   }
	   
	   public String getDashboardFreePlanINfor() {
		   return commonMethods.getText(dashboardFreePlanInfor);
	   }
	   
	   public boolean sliderIsDisplayed() {
		   return commonMethods.isDisplayed(dashboardSlider);
	   }
	   
	   public boolean sliderCategoryIsDisplayed() {
		   return commonMethods.isDisplayed(dashboardSliderCategory);
	   }
	   
	   public String getDashboardSlider() {
			commonMethods.waitForPresence(dashboardSlider);
			return driver.findElement(dashboardSlider).getAttribute("style");
		}
	   
	   public String getDashboardSliderCategory(){
		   return commonMethods.getText(dashboardSliderCategory);
	   }
		
	   public String getDashboardHealthCondition(String text) {
		   String temp = "//p[normalize-space()='"+text+"']";
		  WebElement element =  driver.findElement(By.xpath(temp));
		  return element.getText().trim();
		   
	   }
	   
	   public String getDashboardHealthConditionMessage(String condition) {
		    String xpath = "//p[normalize-space()='" + condition + "']/parent::div/following-sibling::div/p";
		    WebElement messageElement = driver.findElement(By.xpath(xpath));
		    return messageElement.getText().trim();
		}
	   
	   public String getNoHealthText() {
		   return commonMethods.getText(dashboardNoHealthText);
	   }
	   
	   public boolean withoutBloodReportIsDisplayed() {
		   return commonMethods.isDisplayed(dashboardUploadBloodReport);
	   }
	   
	   
	   public String getUploadReportText() {
		   return commonMethods.getText(dashboardUploadBloodReportMessage);
	   }
	   
	   public boolean withoutBloodReportIsEnabled() {
		   return commonMethods.isEnabled(dashboardUploadBloodReport);
	   }
	   
	   
	   public boolean dashboardSubJoinedDateIsDisplayed() {
		   return commonMethods.isDisplayed(dashboardSubJoinedDate);
	   }
	   
	   public boolean dashboardSubTodayDateIsDisplayed() {
		   return commonMethods.isDisplayed(dashboardSubTodayDate);
	   }
	   
	   public String dashboardSubPlanNameGet() {
		   return commonMethods.getText(dashboardSubPlanName);
	   }
	   
	   public String dashboardSubUpgradeGet() {
		   return commonMethods.getText(dashboardSubUpgrade);
	   }
	   
	   public void clickdashboardviewFullCycyle() {
		   
		   commonMethods.click(dashboardviewFullCycyle);
	   }
	   
	   public String getdashboardMenstrualCycle() {
		   return commonMethods.getText(dashboardMenstrualCycle);
	   }
	   
	   public String getdashboardMenstrualInfo() {
		   return commonMethods.getText(dashboardMenstrualInfo);
	   }
}
