package com.google;

import com.google.GoogleHomePage;
import com.google.GoogleSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.webdriver;

public class GoogleSearchTest {

    @Test
    public void verifyFirstResultLinkContainsKitten_PO() {
        var searchResultPage = new GoogleHomePage().open().search("funny kittens");
        Assert.assertTrue(searchResultPage.getFirstSearchResultText().contains("kitten"));
    }

    @Test
    public void verifyDisplayedResultsQuantity_PO() {
        new GoogleHomePage().open().search("funny dogs");
        new GoogleSearchResultPage().getDisplayedResultsQuantity(9);
    }

    @Test
    public void verifyUserIsAbleToNavigateBackToTheHomepage_PO() {
        var searchResultPage = new GoogleHomePage().open().search("Selene");
        Assert.assertTrue(searchResultPage.getFirstSearchResultText().contains("Selene"));
        new GoogleHomePage().goBackToHomePage();
        Assert.assertTrue(webdriver().driver().url().contains("https://www.google.com/webhp?hl="));

    }
}
