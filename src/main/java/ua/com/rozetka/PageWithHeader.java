package ua.com.rozetka;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public abstract class PageWithHeader {
    private RozetkaHeader header = new RozetkaHeader();

    @Step ("PageWithHeader: get header")
    public RozetkaHeader getHeader() {
        return header;
    }

    @Step ("PageWithHeader: click on account icon")
    public SignInModal clickOnAccountIcon() {
        $x("(//button[@class='header__button ng-star-inserted']) [1]").click();
        return new SignInModal();
    }

    @Step ("PageWithHeader: close sign in modal")
    public RozetkaHomePage closeSignInModal(){
        $x("//button[@class = 'modal__close']").click();
        return new RozetkaHomePage();
    }

    @Step ("PageWithHeader: click on the basket icon")
    public BasketModal clickOnBasketIcon() {
        $x("//button[@class='header__button ng-star-inserted header__button--active']").click();
        return new BasketModal();
    }
}
