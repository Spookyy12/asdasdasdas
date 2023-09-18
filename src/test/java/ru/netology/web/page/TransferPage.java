package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private final SelenideElement amount = $("[data-test-id='amount'] input");
    private final SelenideElement transferCard = $("[data-test-id='from'] input");
    private final SelenideElement transferButton = $("[data-test-id='action-transfer']");

    private final SelenideElement errorMessage = $("[data-test-id='error-message']");


    public TransferPage() {

        transferButton.shouldBe(visible);
    }

    public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();
    }

    public void makeTransfer(String sumTransfer, DataHelper.CardInfo cardInfo) {
        amount.setValue(sumTransfer);
        transferCard.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }
    public void errorMessage(String expectedText){
        errorMessage.shouldHave(exactText(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}
