package ua.com.rozetka;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RozetkaHeader {

    @Step("RozetkaHeader: search for {input}")
    public RozetkaSearchResultPage search(String input) {
        $(By.name("search")).setValue(input).pressEnter();
        return new RozetkaSearchResultPage();
    }
}
