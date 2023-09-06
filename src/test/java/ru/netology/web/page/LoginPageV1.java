package ru.netology.web.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageV1 {
    private final SelenideElement login = $("[data-test-id=login] input");
    private final SelenideElement password = $("[data-test-id=password] input");
    private final SelenideElement button = $("[data-test-id=action-login]");

    public  VerificationPage validLogin(DataHelper.AuthInfo info) {

        login.setValue(info.getLogin());
        password.setValue(info.getPassword());
        button.click();
        return new VerificationPage();
    }
}