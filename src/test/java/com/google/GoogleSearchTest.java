package com.google;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.webdriver;

public class GoogleSearchTest {


    @Test(testName = "Verify the first result contains the input")
    void verifyTheFirstResultContainsTheInput() {
        var searchResultPage = new GoogleHomePage().open().search("funny kittens");
        Assert.assertTrue(searchResultPage.getFirstSearchResultText().contains("kitten"));
    }

    @Test(testName = "Verify the quantity of displayed results")
    void verifyTheQuantityOfDisplayedResults() {
        new GoogleHomePage().open().search("funny dogs");
        new GoogleSearchResultPage().getDisplayedResultsQuantity(9);
    }

    @Test(testName = "Verify if user is able to return back to the homepage")
    void verifyIfUserIsAbleToReturnBackToTheHomepage() {
        var searchResultPage = new GoogleHomePage().open().search("Selene");
        Assert.assertTrue(searchResultPage.getFirstSearchResultText().contains("Selene"));
        new GoogleHomePage().goBackToHomePage();
        Assert.assertTrue(webdriver().driver().url().contains("https://www.google.com/webhp?hl="));
    }

}
