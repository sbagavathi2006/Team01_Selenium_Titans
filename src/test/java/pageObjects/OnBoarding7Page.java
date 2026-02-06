package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.CommonMethods;

public class OnBoarding7Page {

	private By dropDownKg = By.xpath("//*[@value='kg']");
	private By dropDowncms = By.xpath("//*[text()='cm']");
	private By dropDownlbs = By.xpath("//*[@value='lbs']");
	private By dropDown_ftin = By.xpath("//*[@value='ft/in']");
	private By continueButton = By.xpath("//*[contains(text(),'Continue')]");
	private By errorforWeight = By.xpath("//*[text()='Weight is required']");
	private By errorforHeight = By.xpath("//*[text()='Height is required']");
	private By weightTextBox = By.xpath("//*[@id='weight']");
	private By heightTextBox = By.xpath(" //*[@id='height']");
	private By errorforInvalidWeight = By.xpath(" //*[contains(text(),'Please enter a valid weight')]");
	private By errorforInvalidHeight = By.xpath("//*[contains(text(),'Please enter a valid height')]");
	private By step7BackButton = By.xpath(" //*[contains(text(),'Back')]");
	private By verify_step8 = By.xpath("//span[normalize-space()='8 of 10']");
	private By headingTextstep8 = By.xpath("//*[contains(text(),'Dietary Preferences')]");
	private By textBelowHeadingstep8 = By.xpath("//*[contains(text(),'Let us know about your ')]");
	private By pescatarianSection = By.xpath("//*[contains(text(),'Pescatarian Diet')]");
	private By nonVegetarianSection = By.xpath("//*[contains(text(),'Non-Vegetarian')]");
	private By vegetarianSection = By.xpath("//*[contains(text(),'Vegetarian Diet')]");
	private By veganSection = By.xpath("//*[contains(text(),'Vegan Diet')]");
	private By infoMessage = By.xpath("//*[contains(text(),'Understanding your dietary preferences')]");
	private By bmiLabelCalculation = By.xpath("//*[contains(text(),'BMI Calculation')]");
	private By bmiBar = By.xpath("//*[@class='mt-2']");
	private By bmiBarLabels = By.xpath("//div[contains(@class,'text-[#6A5ACD]')]//span");
	private By phaseNote = By.xpath("//h5[contains(normalize-space(),'Phase Note')]");
	private By feedBack = By.xpath("//h5[contains(text(),'BMI Feedback:')]");
	private By phaseNoteText=By.xpath("//h5[contains(.,'Phase Note')]/following-sibling::p");
	private By feedBackText = By.xpath("//p[contains(text(),'Your BMI')]");
	//p[contains(text(),'Your BMI')]
	private WebDriver driver;
	private CommonMethods commonMethods;
	private OnBoarding6Page onBoard6Pg;

	public OnBoarding7Page(WebDriver driver) {
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);
		this.onBoard6Pg = new OnBoarding6Page(driver);
	}

	public void clickdropDown() {
		commonMethods.click(dropDownKg);
	}

	public boolean verifyWeightdropDown() {
		commonMethods.click(dropDownKg);
		boolean isKgDisplayed = commonMethods.isDisplayed(dropDownKg);
		boolean isLbsDisplayed = commonMethods.isDisplayed(dropDownlbs);
		return isKgDisplayed && isLbsDisplayed;

	}

	public boolean verifyHeightdropDown() {
		commonMethods.click(dropDowncms);
		boolean isCmsDisplayed = commonMethods.isDisplayed(dropDowncms);
		boolean isftDisplayed = commonMethods.isDisplayed(dropDown_ftin);
		;
		return isCmsDisplayed && isftDisplayed;

	}

	public void clickStep7ContinueButton() {
		driver.findElement(continueButton).click();

	}

	public String errorForWeight() {
		String error = driver.findElement(errorforWeight).getText();
		return error;
	}

	public String errorForHeight() {
		String error = driver.findElement(errorforHeight).getText();
		return error;
	}

	public String errorForInvalidWeight() {
		String error = driver.findElement(errorforInvalidWeight).getText();
		return error;
	}

	public String errorForInvalidHeight() {
		String error = driver.findElement(errorforInvalidHeight).getText();
		return error;
	}

	public void enterInputValues(String weight, String height) {
		driver.findElement(weightTextBox).clear();
		driver.findElement(weightTextBox).sendKeys(weight);

		driver.findElement(heightTextBox).clear();
		driver.findElement(heightTextBox).sendKeys(height);

	}

	public void clickBackButtonInstep7() {
		driver.findElement(step7BackButton).click();

	}

	public String verify_step8() {
		String findStep = driver.findElement(verify_step8).getText();
		return findStep;

	}

	private Map<String, By> step7ElementMap() {
		Map<String, By> map = new HashMap<>();
		map.put("Progress bar", verify_step8);
		map.put("Heading", headingTextstep8);
		map.put("Description", textBelowHeadingstep8);
		map.put("Pescatarian Diet section", pescatarianSection);
		map.put("Non-Vegetarian section", nonVegetarianSection);
		map.put("Vegetarian Diet section", vegetarianSection);
		map.put("Vegan Diet section", veganSection);
		map.put("Info note message", infoMessage);
		map.put("Continue button", continueButton);
		return map;
	}

	public boolean verifyStep8Element(String elementName) {
		By locator = step7ElementMap().get(elementName);
		if (locator == null) {
			throw new IllegalArgumentException("No locator found for: " + elementName);
		}
		return commonMethods.isDisplayed(locator); // Uses your existing isDisplayed method
	}

	public List<String> getBmiBarLabels() {

		return commonMethods.getElements(bmiBarLabels).stream().map(e -> e.getText().trim())
				.collect(Collectors.toList());
	}

	private String normalize(String s) {
		return s == null ? "" : s.trim().toLowerCase().replaceAll("\\s+", "");
	}

	public void verifyBmiUiElements(List<String> uiElements) {

		SoftAssert sa = new SoftAssert();

		for (String uiElement : uiElements) {

			switch (normalize(uiElement)) {

			case "bmibar":
				sa.assertTrue(commonMethods.isDisplayed(bmiBar), "BMI bar is not visible");
				break;
				
			case "bmicalculations":
				sa.assertTrue(commonMethods.isDisplayed(bmiLabelCalculation), "BMICalculations section is not visible");
				break;

			case "phasenotesection":
				sa.assertTrue(commonMethods.isDisplayed(phaseNote), "PhaseNote section is not visible");
				break;

			case "feedbacksection":
				sa.assertTrue(commonMethods.isDisplayed(feedBack), "Feedback section is not visible");
				break;

			default:
				sa.fail("Unknown UI element: " + uiElement);
			}
		}

		sa.assertAll();
	}
	public String getBmiDisplayedText() {
	    return commonMethods.getText(bmiLabelCalculation).trim();
	}
	public String buildExpectedBmiText(String weightKgStr , String heightCmStr ) {
	    double heightCm = Double.parseDouble(heightCmStr.trim());
	    double weightKg = Double.parseDouble(weightKgStr.trim());
	    double heightMeters = heightCm / 100.0;
	    double bmi = weightKg / (heightMeters * heightMeters);
	    double rounded = Math.round(bmi * 10.0) / 10.0;
	    return "BMI Calculation: Your BMI is " + String.format("%.1f", rounded);
	}
	private static final Map<String, String> expectedPhaseNotes = Map.of(
            "Menstrual",
            "Bloating and water retention can make the scale fluctuate a bit, but this is just temporary!",
            "Luteal",
            "Your metabolism is working hard, but cravings and water retention can make your BMI seem a little higher for now.",
            "Follicular",
            "Your metabolism is in full gear, and any water retention is dropping, so your BMI might be a bit lower right now!",
            "Ovulatory",
            "You might notice a little water retention, so your BMI could be a bit higher temporarily."
    );
	public String getCurrentPhase() {
        String phase = commonMethods.getText(phaseNote).trim();
        return phase.replace("Phase Note:", "").trim();
    }
    public String getPhaseNoteText() {
        return commonMethods.getText(phaseNoteText).trim();
    }

    public boolean isPhaseNoteCorrectForCurrentPhase() {
    	String phase = getCurrentPhase();
        String actualNote = getPhaseNoteText();
        System.out.print("actual:" +actualNote);
        if (!expectedPhaseNotes.containsKey(phase)) {
            throw new AssertionError("Unknown phase displayed in UI: " + phase);
        }
        String expectedNote = expectedPhaseNotes.get(phase);
        System.out.print("actual:"+expectedNote);
        return actualNote.equals(expectedNote);
    }
    
    private static final Map<String, String> BMI_FEEDBACK = Map.of(
    	    "Underweight", "Your BMI suggests you may need to gain a little weight for optimal health. We're here to guide you every step of the way.",
    	    "Normal",      "Your BMI is within the normal range. Great job! Keep maintaining a healthy lifestyle.",
    	    "Overweight",  "Your BMI suggests you may benefit from some weight management. Small changes can make a big difference, and we're here to help.",
    	    "Obese",       "Your BMI suggests a little weight loss could help with your health. We're here to support you every step of the way."
    	);
    public double extractBmiValue(String bmiText) {
        String value = bmiText.replaceAll("[^0-9.]", "");
        return Double.parseDouble(value);
    }

    	public String getBmiFeedbackMessageFromUI() {
    	    return commonMethods.getText(feedBackText).trim();
    	}
    	public String getBmiCategoryFromValue(double bmi) {
    	    if (bmi < 18.5) return "Underweight";
    	    if (bmi < 25)   return "Normal";
    	    if (bmi < 30)   return "Overweight";
    	    return "Obese";
    	}
    	public String getExpectedBmiFeedbackMessage(String weightKgStr, String heightCmStr) {
    	    String bmiText = buildExpectedBmiText(weightKgStr, heightCmStr);
    	    double bmiValue = extractBmiValue(bmiText);
    	    String category = getBmiCategoryFromValue(bmiValue);
    	    return BMI_FEEDBACK.get(category);
    	}
    	


}
