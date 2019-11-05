import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.*;

class testCardDeliveryTest {

    @Test
    void checkOrderFormDeliveryCard() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Грозный");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        $("[data-test-id=date] input").sendKeys("30.11.2019");
        $("[data-test-id=name] input").setValue("Луцкий Артем");
        $("[data-test-id=phone] input").setValue("+79164443322");
        $("[data-test-id=agreement]").click();
        $$("[class=button__text]").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").waitUntil(Condition.visible, 15000);
        $("[class=notification__title]").should(Condition.exactText("Успешно!"));
    }
}