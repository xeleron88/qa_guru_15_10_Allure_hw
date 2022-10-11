package guru.xel.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.xel.steps.WebSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest extends TestBase{

    private static final String REPOSITORY = "xeleron88/qa_guru_15_3_demoqa_hw";
    private static final int ISSUE = 1;

    @Test
    public void testLambdaStep() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }



}
