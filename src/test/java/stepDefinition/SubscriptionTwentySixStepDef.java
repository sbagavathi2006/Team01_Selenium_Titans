package stepDefinition;

import context.TestContextSetup;
import driverFactorySetUp.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.SubscriptionTwentySixPage;

import java.util.Arrays;
import java.util.List;

public class SubscriptionTwentySixStepDef {

    private TestContextSetup testContext;
    SubscriptionTwentySixPage subscriptionTwentySixPage;
    List<String> results;

    public SubscriptionTwentySixStepDef() {
        subscriptionTwentySixPage = new SubscriptionTwentySixPage(DriverFactory.getDriver());
    }

    @Given("User is on the Her Balance Dashboard with the Profile submenu expanded")
    public void user_is_on_the_her_balance_dashboard_with_the_profile_submenu_expanded() {
        subscriptionTwentySixPage.loginToPortal();
    }

    @When("User clicks on Subscription to verify the subscription information")
    public void user_clicks_on_subscription_to_verify_the_subscription_information() {
        subscriptionTwentySixPage.clickProfileSubMenu();
        subscriptionTwentySixPage.selectSubscription();
    }

    @Then("{string} text should be visible on the page")
    public void text_should_be_visible_on_the_page(String expectedText) {
       Assert.assertEquals(subscriptionTwentySixPage.VerifySubManagementTxt(),expectedText,"Title" +expectedText+"is not displayed");
    }
    @Then("Exactly {int} sections should be visible")
    public void exactly_sections_should_be_visible(Integer expectedValue) {
        // Use the new method that doesn't need parameters
        List<WebElement> headers = subscriptionTwentySixPage.getAllSections();
        Assert.assertEquals((int)expectedValue, headers.size(),"The number of sections displayed is incorrect!");
    }

    @Then("The mentioned {string} should br displayed")
    public void the_mentioned_should_br_displayed(String sectionHeaders) {

        results = subscriptionTwentySixPage.verifySectionHeaders(sectionHeaders);
        System.out.println("size of results: " + results.size());
    }
    @Then("The mentioned header text {string} should be displayed")
    public void the_mentioned_header_text_should_be_displayed(String title) {
        Assert.assertEquals(subscriptionTwentySixPage.getCurrentSubsHeaderTxt(),title,"Header Text"+title+"is not displayed as expected");
    }



}
