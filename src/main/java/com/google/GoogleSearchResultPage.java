package com.google;


import com.codeborne.selenide.Condition;


import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchResultPage {

    public void getDisplayedResultsQuantity(int expectedResultsQuantity) {
        $$x("// h3[@class='LC20lb MBeuO DKV0Md']").shouldHave(size(expectedResultsQuantity));
    }

    public String getFirstSearchResultText() {

        String result = $x("//h3[@class='GmE3X kWYf3c']")
                .shouldBe(Condition.visible)
                .getText();
        return result;
    }
}
