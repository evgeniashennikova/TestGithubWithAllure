package qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBase.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static testBase.TestData.*;

public class TestWithListener {

    TestData testdata = new TestData();

    @Test
    @Owner("eshennikova")
    @Link(name = "GitHub", url = "https://github.com")
    @Feature("Разделы в репозитории")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия раздела Issues на странице репозитория")

    public void testGithub() {

        SelenideLogger.addListener("Allure", new AllureSelenide());

//Открыть GitHub
        open(testdata.getNameWebsite());

//Ввести в поле поиска название репозитория
        nameWebsiteSelector.click();
        nameWebsiteSelector.sendKeys(testdata.getRepositorySearch());
        nameWebsiteSelector.submit();

//Перейти в репозиторий
        $(linkText(testdata.getRepositorySearch())).click();

//Проверить, что на странице репозитория есть раздел Issues
        issuesSelector.shouldBe(Condition.visible).shouldHave(Condition.text(testdata.getTextSearch()));

    }
}
