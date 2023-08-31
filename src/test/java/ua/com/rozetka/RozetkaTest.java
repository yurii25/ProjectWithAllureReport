package ua.com.rozetka;

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

    @AfterMethod
    public void afterMethod() {
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void verifyProductSearchDetails() {
        var resultPage = new RozetkaHomePage()
                .open()
                .getHeader()
                .search("iphone");

        resultPage.verifyQuantityOfResults(5);

        var priceOnTheSearchResultsPage = resultPage.priceOfTheParticularSearchResult(3);

        resultPage.openParticularProduct(3);

        var priceOnTheProductPage = new ProductPage().getProductPrice();

        Assert.assertEquals(priceOnTheProductPage, priceOnTheSearchResultsPage);
    }

    @Test
    public void verifyLoginModal() {
        var homePage = new RozetkaHomePage().open();
        homePage.clickOnAccountIcon();

        SignInModal signInModal = new SignInModal();

        signInModal.checkIfSignInModalDisplayed();

        homePage.closeSignInModal();
        signInModal.checkIfSignInModalNotDisplayed();
    }

    @Test
    public void verifyProductSearchDetailsAndBasketInfo() {
        var resultPage = new RozetkaHomePage()
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
