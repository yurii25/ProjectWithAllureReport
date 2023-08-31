package ua.com.rozetka;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SignInModal {

    @Step("SignInModal: verify if Sign in modal is visible")
    public void checkIfSignInModalDisplayed() {
        $x("//div[@class = 'modal__holder modal__holder_show_animation modal__holder--medium']")
                .shouldBe(Condition.visible);
    }


    @Step("SignInModal: verify if Sign in modal is not visible")
    public void checkIfSignInModalNotDisplayed() {
        $x("//div[@class = 'modal__holder modal__holder_show_animation modal__holder--medium']")
                .shouldNotBe(Condition.visible);
    }


}
