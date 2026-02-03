package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CommonMethods;
import utilities.ExcelUtils;
import utilities.ConfigReader;
import utilities.LoggerLoad;

import java.util.List;
import java.util.Map;

public class SignUpPage {

    WebDriver driver;
    CommonMethods common;
    ExcelUtils excel;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.common = new CommonMethods(driver);
        this.excel = new ExcelUtils(ConfigReader.getProperty("test_data_path"));
    }

    public By signUpButton = By.xpath("//button[contains(text(),'Sign Up')]");
    public By emailField = By.id(":r5:-form-item");
    public By passwordField = By.name("password");
    public By confirmPasswordField = By.name("confirmPassword");
    public By showPasswordIcon = By.xpath("//label[text()='Show passwords']");
    public By registerButton = By.xpath("//button[text()='Register']");
    public By loginLink = By.xpath("//button[text()='Log in']");
    public By termsCheckbox = By.id(":r8:-form-item");
    public By termsText = By.xpath("//*[@id=\"radix-:r0:-content-register\"]/div/div[2]/form/div[5]/div/label/button");
    public By errorMessage = By.cssSelector(".error");
    public By inputFields = By.cssSelector("input");
    public By background = By.cssSelector("body");
    By allTextboxes = By.xpath("//div[@class='space-y-2']//input");

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void enterEmail(String email){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String password){
        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void clickShowPassword() {
        driver.findElement(showPasswordIcon).click();
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void acceptTerms() {
        driver.findElement(termsCheckbox).click();
    }

    public boolean isEmailFieldVisible(){
        return driver.findElement(emailField).isDisplayed();
    }

    public boolean isPasswordFieldMasked(){
        return driver.findElement(passwordField).getDomAttribute("type").equals("password");
    }

    public boolean isConfirmPasswordFieldMasked(){
        return driver.findElement(confirmPasswordField).getDomAttribute("type").equals("password");
    }

    public boolean isShowPasswordIconVisible(){
        return driver.findElement(showPasswordIcon).isDisplayed();
    }

    public boolean isRegisterButtonEnabled(){
        return driver.findElement(registerButton).isEnabled();
    }

    public boolean isLoginLinkVisible(){
        return driver.findElement(loginLink).isDisplayed();
    }

    public boolean areInputFieldsAligned() {
        List<WebElement> fields = driver.findElements(inputFields);
        String baseMargin = fields.get(0).getCssValue("margin-bottom");
        for (WebElement field : fields) {
            if (!field.getCssValue("margin-bottom").equals(baseMargin)) {
                return false;
            }
        }
        return true;
    }

    public int getNumberOfInputFields() {
        return driver.findElements(allTextboxes).size();
    }

    public boolean isTermsTextPresent(){
        return driver.findElement(termsText).isDisplayed();
    }

    public boolean isTermsCheckboxPresent(){
        return driver.findElement(termsCheckbox).isDisplayed();
    }

    public boolean isThemeApplied() {
        WebElement body = driver.findElement(background);
        String bgImage = body.getCssValue("background-image");
        String fontFamily = body.getCssValue("font-family");

        boolean hasGradient = bgImage != null && bgImage.contains("linear-gradient");
        boolean hasBrandFont = fontFamily != null && fontFamily.toLowerCase().contains("inter");

        LoggerLoad.info("Background Image: " + bgImage + ", Font Family: " + fontFamily);
        return hasGradient && hasBrandFont;
    }

    public String getErrorMessage(){
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public void registerWithValidDynamicData() {
        String random = CommonMethods.generateRandomString();
        String email = random + "@gmail.com";
        String password = random + "@@123";

        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(password);
        acceptTerms();
        clickRegister();

        LoggerLoad.info("Registered with dynamic data => Email: " + email + ", Password: " + password);
    }

    public Map<String, String> getTestData(String testCaseID) {
        List<Map<String,String>> allData = excel.getDataAll("SignUp");
        return allData.stream()
                .filter(d -> d.get("TestCaseID").equals(testCaseID))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Test data not found for: " + testCaseID));
    }

    public void fillFormFromTestData(String testCaseID, boolean acceptTermsFlag) {
        Map<String, String> row = getTestData(testCaseID);
        enterEmail(row.get("Email"));
        enterPassword(row.get("Password"));
        enterConfirmPassword(row.get("ConfirmPassword"));
        if (acceptTermsFlag) acceptTerms();
    }
}
