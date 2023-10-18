package StepDefinition;

import Core.Helper;
import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ProductPurchaseFullCycleStepdefs {
    // Create a static variable called driver to hold the WebDriver instance
    public static WebDriver driver;
    // Create instances of Page Objects for different pages in the application
    HomePage homePage;
    CartPage cartPage;
    LoginPage loginPage;
    SignupPage signupPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;

    // Create an instance of SoftAssert to perform soft assertions
    SoftAssert softAssert;

    @Given("User lands on the home page and verify that home page is visible")
    public void userLandsOnTheHomePageAndVerifyThatHomePageIsVisible() {
        // Create an instance of the Helper class to set up the WebDriver
        Helper helper = new Helper();
        // Initialize the WebDriver and assign it to the driver variable
        driver = helper.ChromeTest();
        // Create instances of Page Objects for different pages and associate them with respective variables
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);

        // Initialize the SoftAssert for performing soft assertions
        softAssert = new SoftAssert();
        //soft assert to check page title
        softAssert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page title is incorrect.");
        // Check if the home page is visible
        boolean isHomePageVisibleCorrectly = homePage.isHomePageVisible();
        if (isHomePageVisibleCorrectly) {
            System.out.println("Home page is visible successfully.");
        } else {
            System.out.println("Home page is not visible.");
        }
    }

    @When("Add products to cart")
    public void addProductsToCart() throws InterruptedException {
        homePage.addToCart();
    }

    @And("Click on the Cart button")
    public void clickOnTheCartButton() throws InterruptedException {
        homePage.viewCartBttnClick();
    }

    @Then("Verify that cart page is displayed")
    public void verifyThatCartPageIsDisplayed() {
        String expectedPageTitle = "Shopping Cart";
        String actualPageTitle = cartPage.getTabTitleText();
        //soft assert to check page title
        softAssert.assertTrue(actualPageTitle.contains(expectedPageTitle), "Page title assertion failed");
    }

    @When("Click on the Proceed To Checkout button")
    public void clickOnTheProceedToCheckoutButton() {
        cartPage.checkoutBttnClick();
    }

    @And("Click on the Register or Login button")
    public void clickOnTheRegisterOrLoginButton() throws InterruptedException {
        cartPage.regOrLoginBttnClick();
    }

    @And("Insert {string} and {string}")
    public void insertNameAndEmail(String name, String email) {
        loginPage.enterNameAndEmail(name, email);
    }

    @And("Click on the signup button")
    public void clickOnTheSignupButton() throws InterruptedException {
        loginPage.signupBttnClick();
    }

    @And("Insert {string},{string},{string},{string},{string},{string},{string},{string}")
    public void insertPasswordFirstNameLastNameAddressStateCityZipcodeMobileNumber(String password, String firstName,
                                                                                   String lastName, String address,
                                                                                   String state, String city, String zipcode,
                                                                                   String mobileNumber) throws InterruptedException {
        signupPage.formFillUp(password, firstName, lastName, address, state, city, zipcode, mobileNumber);
    }

    @And("Click on the create account button")
    public void clickOnTheCreateAccountButton() {
        signupPage.createAccBttnClick();
    }

    @Then("Verify that ACCOUNT CREATED and click on Continue button")
    public void verifyThatACCOUNTCREATEDAndClickOnContinueButton() throws InterruptedException {
        String expectedMessage = "Account Created!";
        String actualMessage = signupPage.getAccCreatedText();
        //soft assert to check message title
        softAssert.assertTrue(actualMessage.contains(expectedMessage), "Message assertion failed");
        signupPage.continueBttnClick();
    }

    @And("Verify Logged in as username at top")
    public void verifyLoggedInAsUsernameAtTop() {
        softAssert.assertTrue(homePage.isLoggedButtonVisible(), "User is not logged in.");
    }

    @When("Click on the Cart button from the top menu bar")
    public void clickOnTheCartButtonFromTheTopMenuBar() throws InterruptedException {
        homePage.topCartMenuClick();

    }

    @And("Click on the Checkout button")
    public void clickOnTheCheckoutButton() {
        cartPage.checkoutBttnClick();
    }

    @Then("Verify Address Details and Review Your Order")
    public void verifyAddressDetailsAndReviewYourOrder() {
        checkoutPage.scrollToComment();
    }

    @And("Enter description in {string} text area and click on the Place Order button")
    public void enterDescriptionInCommentTextAreaAndClickOnThePlaceOrderButton(String comment) throws InterruptedException {
        checkoutPage.commentAndProceed(comment);
    }

    @When("Enter payment details: {string}, {string}, {string}, {string},{string}")
    public void enterPaymentDetailsCardNameCardNumberCVCExpirationMonthExpirationYear(String CardName, String CardNumber,
                                                                                      String CVC, String ExpirationMonth, String ExpirationYear) {
        paymentPage.enterCardDetails(CardName, CardNumber, CVC, ExpirationMonth, ExpirationYear);
    }

    @And("Click on the Pay and Confirm Order button")
    public void clickOnThePayAndConfirmOrderButton() throws InterruptedException {
        paymentPage.confirmOrder();
    }

    @Then("Verify the success message Your order has been placed successfully!")
    public void verifyTheSuccessMessageYourOrderHasBeenPlacedSuccessfully() {
        String expectedOrderSuccessMessage = "Congratulations! Your order has been confirmed!";
        String actualOrderSuccessMessage = paymentPage.getOrderConfirmMessage();
        //soft assert to check message title
        softAssert.assertTrue(actualOrderSuccessMessage.contains(expectedOrderSuccessMessage), "Message assertion failed");
    }

    @And("Logout from the site")
    public void logoutFromTheSite() throws InterruptedException {
        paymentPage.logout();
    }
}
