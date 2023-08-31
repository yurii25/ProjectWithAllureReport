package ua.com.rozetka;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    @Step("ProductPage: get product price")
    public String getProductPrice() {

        return $x("//p[@class='product-price__big product-price__big-color-red']").getText();
    }
}
