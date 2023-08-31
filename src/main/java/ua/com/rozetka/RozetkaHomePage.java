package ua.com.rozetka;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.Builder;
import lombok.val;


public class RozetkaHomePage extends PageWithHeader {

    @Step ("RozetkaHomePage: open homepage")
    public RozetkaHomePage open() {
        Configuration.browser = "chrome";
//        Configuration.holdBrowserOpen = true;
        Selenide.open("https://rozetka.com.ua/ua/");
        return this;
    }

}
