package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


@Tag("selenide_android")
public class BrowserStackAndroidSelenideTests extends TestBase {

    @Test
    @DisplayName("Enter login and check if its value exists")
    void loginTest(){
        step("Type search",()->
                $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click());
        step("Tap login",()->
                $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_account_container")).click());
        step("Enter login",()->
                $(MobileBy.id("org.wikipedia.alpha:id/login_username_text")).setValue("1234"));
        step("Login is presented",()->
                $(MobileBy.id("org.wikipedia.alpha:id/login_username_text")).shouldHave(Condition.text("1234")));
    }
}