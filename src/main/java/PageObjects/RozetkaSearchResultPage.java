package PageObjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;


public class RozetkaSearchResultPage extends PageWithHeader {

    @Step("RozetkaSearchResultPage: add to basket by clicking on {cartIconForParticularProductNumber}")
    public RozetkaSearchResultPage addToTheBasket(Integer cartIconForParticularProductNumber) {
        $x(String.format("(//button[@class='buy-button goods-tile__buy-button ng-star-inserted']) [%s]", cartIconForParticularProductNumber)).click();
        return new RozetkaSearchResultPage();
    }

    @Step("RozetkaSearchResultPage: verify quantity of {numberOfResults}")
    public void verifyQuantityOfResults(Integer numberOfResults) {
        $$x("//div[@class='goods-tile ng-star-inserted']").shouldHave(sizeGreaterThanOrEqual(numberOfResults));
    }

    @Step("RozetkaSearchResultPage: get price of the particular {productNumber}")
    public String priceOfTheParticularSearchResult(Integer productNumber) {
        return $x(String.format("(//div[@class='goods-tile ng-star-inserted']) [%s]", productNumber) +
                "//span[@class='goods-tile__price-value']").getText();
    }

    @Step("RozetkaSearchResultPage: open {productNumber}")
    public ProductPage openParticularProduct(Integer productNumber) {

        $x(String.format("(//div[@class='goods-tile__inner']) [%s]", productNumber)).click();

        return new ProductPage();
    }

    @Step("RozetkaSearchResultPage: get name of the particular {productNumber}")
    public String nameOfTheParticularSearchResult(Integer productNumber) {
        return $x(String.format("(//a[@class='goods-tile__heading ng-star-inserted']) [%s]", productNumber)).getText();
    }
}
