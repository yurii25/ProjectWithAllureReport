package PageObjects;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class RozetkaHomePage extends PageWithHeader {

    @Step ("RozetkaHomePage: open homepage")
    public RozetkaHomePage open() {
        Configuration.browser = "chrome";
//        Configuration.holdBrowserOpen = true;
        Selenide.open("https://rozetka.com.ua/ua/");
        return this;
    }


}
