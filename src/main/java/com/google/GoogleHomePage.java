package com.google;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleHomePage {

    public void goBackToHomePage() {
        $(By.xpath("//div [@class='logo']")).shouldBe(Condition.visible).click();
        $x("//img[@alt='Google']").shouldBe(Condition.visible);
        $x("//div[@class='SDkEP']").shouldBe(Condition.visible);
    }

    public GoogleHomePage open() {
        Selenide.open("https://www.google.com/");
        return this;
    }

    public GoogleSearchResultPage search(String locator) {
        $(By.name("q")).setValue(locator).pressEnter();
        return new GoogleSearchResultPage();
    }
}
