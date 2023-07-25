package PageObjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class BasketModal {

    @Step("BasketModal: get name of the particular product in the basket")
    public String nameOfTheParticularProductInBasket() {
        return $x("//div[@class='cart-product__main']").getText();
    }

    @Step("BasketModal: get price of the particular product in the basket")
    public String priceOfTheParticularProductInBasket() {
        return $x("//div[@class='cart-receipt__sum-price']").getText();
    }
}
