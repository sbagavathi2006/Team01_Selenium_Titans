package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CommonMethods;

public class LaunchPage {

    private WebDriver driver;
   // private WebDriverWait wait;
    private CommonMethods common;

    

    public LaunchPage(WebDriver driver) {
        this.driver = driver;
        //this.driver = DriverFactory.getDriver();
        this.common = new CommonMethods(driver);

       // this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // ----------------------------
    // Locators
    // ----------------------------

    private By loginButton =
            By.xpath("//button[contains(text(),'Log In')]");

    private By signUpButton =
            By.xpath("//button[contains(text(),'Sign Up')]");

//    private By getStartedNowButton =
//            By.xpath("//button[contains(text(),'Get Started Now')]");  
//
//    private By startPersonalizedJourneyButton =
//            By.xpath("//*[contains(text(),'Start Your Personalized Journey')]");
//    
    private By getStartedNowButton =
            By.xpath("//*[contains(text(),'Get Started Now')]");

    private By startPersonalizedJourneyButton =
            By.xpath("//*[contains(text(),'Start Your Personalized Journey')]");


    private By body =
            By.tagName("body");

    // ----------------------------
    // Visibility Checks
    // ----------------------------

    public boolean isLoginButtonVisible() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public boolean isSignUpButtonVisible() {
        return driver.findElement(signUpButton).isDisplayed();
    }

//    public boolean isGetStartedNowButtonVisible() {
//        return driver.findElement(getStartedNowButton).isDisplayed();
//    }
//
//    public boolean isStartPersonalizedJourneyButtonVisible() {
//        return driver.findElement(startPersonalizedJourneyButton).isDisplayed();
//    }

//    public boolean isGetStartedNowButtonVisible() {
//        return scrollAndCheck(getStartedNowButton);
//    }
//
//    public boolean isStartPersonalizedJourneyButtonVisible() {
//        return scrollAndCheck(startPersonalizedJourneyButton);
//    }

    
//    public boolean isCyclePhaseVisible(String phase) {
//        return driver.findElement(
//                By.xpath("//*[contains(text(),'" + phase + "')]")
//        ).isDisplayed();
//    }
    
//    public boolean isCyclePhaseVisible(String phase) {
//        By locator = By.xpath("//*[contains(text(),'" + phase + "')]");
//
//        // Find the element
//        WebElement element = driver.findElement(locator);
//
//        // Scroll it into view
//        ((JavascriptExecutor) driver)
//            .executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
//
//        // Wait until visible
//        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(element));
//
//        return element.isDisplayed();
//    }

    
 
    public boolean isCyclePhaseVisible(String phase) {
        By locator = By.xpath("//*[contains(text(),'" + phase + "')]");
        WebElement element = driver.findElement(locator);
        common.scrollIntoViewWait(element); // scroll + wait
        return element.isDisplayed();
    }


    public String getBackgroundColor() {
        return driver.findElement(body).getCssValue("background-color");
    }

    public boolean isTextContentPresent() {
        return driver.findElements(By.xpath("//*[text()]")).size() > 0;
    }


    
//    private boolean scrollAndCheck(By locator) {
//        WebElement element = driver.findElement(locator);
//
//        // Scroll into view
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
//
//        // Wait until element is visible
//        wait.until(ExpectedConditions.visibilityOf(element));
//
//        return element.isDisplayed();
//    }
//
//    
    
    
    // ----------------------------
    // Actions
    // ----------------------------

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickSignUp() {
        driver.findElement(signUpButton).click();
    }

//    public void clickGetStartedNow() {
//        driver.findElement(getStartedNowButton).click();
//    }

//    public void clickStartPersonalizedJourney() {
//        driver.findElement(startPersonalizedJourneyButton).click();
//    }
    
//    public void clickStartPersonalizedJourney() {
//        WebElement element = driver.findElement(startPersonalizedJourneyButton);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        element.click();
//    }
    
    
    private By getStartedNowFooterButton = By.xpath("//footer//button[contains(text(),'Get Started Now')]");
   // private By startPersonalizedJourneyButton = By.xpath("//button[contains(text(),'Start Your Personalized Journey')]");
    private By cycleTrackingAppSection = By.xpath("//*[contains(text(),'Cycle Tracking App')]");
   // private By syncWeightLossImagesSection = By.xpath("//*[contains(text(),'Sync your weight loss journey')]");
   // private By empowerTextSection = By.xpath("//*[contains(text(),'hormonal shifts and metabolism')]");
   // private By empowerTextSection =  By.xpath("//h1[contains(normalize-space(.),'Empower Your Weight Loss')]");

   private By empowerInfoText =
    	    By.xpath("//p[contains(normalize-space(.),'Hormonal shifts during your menstrual cycle')]");

    By syncWeightLossImagesSection =
    	    By.xpath("//img[@alt='Workout Exercises for Women']");

    // ------------------------
    // Generic scroll and check method
    // ------------------------
//    private boolean scrollAndCheck(By locator) {
//        WebElement element = driver.findElement(locator);
//
//        ((JavascriptExecutor) driver)
//                .executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", element);
//
//        wait.until(ExpectedConditions.visibilityOf(element));
//
//        return element.isDisplayed();
//    }

    // ------------------------
    // Specific element methods
    // ------------------------
   
   
//    public boolean isStartPersonalizedJourneyButtonVisible() {
//        return scrollAndCheck(startPersonalizedJourneyButton);
//    }

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
        common.scrollIntoViewWait(element);  // use lightweight scroll + wait
        return element.isDisplayed();
    }

    // Now your visibility methods become:
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

   
}

    

