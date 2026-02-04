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
        private By loginTab = By.id("radix-:r5:-trigger-login"); 
        private By signUpTab = By.id("radix-:r5:-trigger-register"); 
        private By email = By.name("username");
        private By password = By.name("password");
        private By loginBtn = By.xpath(" //button[contains(text(),'LogIn')]"); 
        private By showPwd = By.xpath("//label[contains(text(),'Show password')]");
        private By logo = By.cssSelector("header img");
        private By forgotPwd = By.xpath(" //button[contains(text(),'Forgot password?')]");
        private By signUpLink = By.linkText("Sign up");
        private By tabs = By.cssSelector(".auth-tabs li");
        private By errorMsgs = By.xpath("//*[contains(text(),'Invalid') or contains(text(),'required')]");
        private By inputs = By.tagName("input");


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

        public void clickLogin() {
            waitFor(loginBtn).click();
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
            return driver.findElements(tabs)
                    .get(0)
                    .getAttribute("class")
                    .contains("active");
        }

        public int getTabCount() {
            return driver.findElements(tabs).size();
        }

        public int getInputCount() {
            return driver.findElements(inputs).size();
        }

        public List<WebElement> getTabs() {
            return driver.findElements(tabs);
        }

        public boolean isShowPasswordVisible() {
            return driver.findElement(showPwd).isDisplayed();
        }

        public boolean isLoginButtonVisible() {
            return driver.findElement(loginBtn).isDisplayed();
        }

        public boolean isLoginButtonEnabled() {
            return driver.findElement(loginBtn).isEnabled();
        }

        public boolean isForgotPasswordVisible() {
            return driver.findElement(forgotPwd).isDisplayed();
        }

        public boolean isSignUpVisible() {
            return driver.findElement(signUpLink).isDisplayed();
        }

       
        public String getErrorMessage() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgs));
            List<WebElement> errors = driver.findElements(errorMsgs);
            if (errors.isEmpty()) {
                throw new RuntimeException(
                    "Expected error message but none was displayed");
            }
            return errors.get(0).getText();
        }

        
        public List<String> getValidationMessages() {
            return driver.findElements(errorMsgs)
                    .stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
        }
}