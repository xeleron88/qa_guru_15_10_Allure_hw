package guru.xel.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase{
    @Test
    public void testIssueSearch() {

        open("/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("xeleron88/qa_guru_15_3_demoqa_hw");
        $(".header-search-input").submit();

        $(linkText("xeleron88/qa_guru_15_3_demoqa_hw")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}
