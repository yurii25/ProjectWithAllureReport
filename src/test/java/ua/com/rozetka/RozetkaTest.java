package ua.com.rozetka;

import com.codeborne.selenide.Configuration;
import ua.com.rozetka.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class RozetkaTest {

    @BeforeClass
    public void beforeTestClass(){
        System.out.println("The Rozetka tests started");
    }

    @AfterClass
    public void afterTestClass(){
        System.out.println("The Rozetka tests ended");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("The single test has started");
    }


    static {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
    }

    RozetkaHomePage rozetkaHomePage = new RozetkaHomePage();
    

    @Test(testName = "Verify product search results")
    void verifyProductSearchResults() {
        var resultPage = rozetkaHomePage
                .open()
                .getHeader()
                .search("iphone");

        resultPage.verifyQuantityOfResults(5);

        var priceOnTheSearchResultsPage = resultPage.priceOfTheParticularSearchResult(3);

        resultPage.openParticularProduct(3);

        var priceOnTheProductPage = new ProductPage().getProductPrice();

        Assert.assertEquals(priceOnTheProductPage, priceOnTheSearchResultsPage);
    }

    @Test(testName = "Verify login modal presence")
    void verifyLoginModalPresence() {
        var homePage = rozetkaHomePage.open();

        homePage.clickOnAccountIcon();

        SignInModal signInModal = new SignInModal();

        signInModal.checkIfSignInModalDisplayed();

        homePage.closeSignInModal();
        signInModal.checkIfSignInModalNotDisplayed();

    }

    @Test(testName = "Verify product search details and basket info")
    void verifyProductSearchDetailsAndBasketInfo() {
        var resultPage = rozetkaHomePage
                .open()
                .getHeader()
                .search("dell");

        resultPage.verifyQuantityOfResults(10);

        var priceOnTheSearchResultsPage = resultPage
                .priceOfTheParticularSearchResult(5);

        var nameOnTheSearchResultsPage = resultPage
                .nameOfTheParticularSearchResult(5);

        new RozetkaSearchResultPage().addToTheBasket(5);

        resultPage.clickOnBasketIcon();

        BasketModal basketModal = new BasketModal();

        var priceOnTheBasketModal = basketModal.priceOfTheParticularProductInBasket();

        var nameOnTheBasketModal = basketModal.nameOfTheParticularProductInBasket();

        Assert.assertEquals(priceOnTheSearchResultsPage, priceOnTheBasketModal);
        Assert.assertEquals(nameOnTheSearchResultsPage, nameOnTheBasketModal);


    }
}
