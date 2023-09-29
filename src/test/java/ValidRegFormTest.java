import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class ValidRegFormTest {

    @Test
    void ValidForm() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Ханты-Мансийск");
        $("[data-test-id=date] input").setValue("02.10.2023");
        $("[data-test-id=name] input").setValue("Курский Виктор");
        $("[data-test-id=phone] input").setValue("+79824133177");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $(withText("Мы гарантируем безопасность")).shouldBe(visible);
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(30));
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на "));
    }
}
