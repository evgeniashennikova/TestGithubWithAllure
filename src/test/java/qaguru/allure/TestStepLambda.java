package qaguru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBase.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static testBase.TestData.*;

public class TestStepLambda {

    TestData testdata = new TestData();

    @Test
    @Owner("eshennikova")
    @Link(name = "GitHub", url = "https://github.com")
    @Feature("Разделы в репозитории")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия раздела Issues на странице репозитория")
    public void testGithubLambda() {

        step("Открыть главную страницу GitHub", () -> open(testdata.getNameWebsite()));
        step("Ввести в поле поиска название репозитория" + testdata.getRepositorySearch(), () -> {
            nameWebsiteSelector.click();
            nameWebsiteSelector.sendKeys(testdata.getRepositorySearch());
            nameWebsiteSelector.submit();
        });
        step("Перейти в репозиторий" + testdata.getRepositorySearch(), () -> $(linkText(testdata.getRepositorySearch())).click());
        step("Проверить, что на странице репозитория есть раздел Issues", () -> {
            issuesSelector.shouldBe(Condition.visible).shouldHave(Condition.text(testdata.getTextSearch()));
        });
    }
}
