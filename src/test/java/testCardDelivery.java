import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class testCardDelivery {
    void checkOrderFormDeliveryCard() {
        open("http://localhost:9999/");
        $("[data-test-id=city]").setValue("Грозный");
        $("data-test-id=date").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        $("data-test-id=date").sendKeys("30.11.2019");
        $("data-test-id=name").setValue("Луцкий Артем");
        $("data-test-id=phone").setValue("+79164443322");
        $("data-test-id=agreement").click();
        $$("class=button__text").find(exactText("Забронировать")).click();
        $("data-test-id=notification").waitUntil(visible,15000);
        $("[data-test-id=notification].notification__title").should(Condition.exactText("Успешно!"));
    }
}