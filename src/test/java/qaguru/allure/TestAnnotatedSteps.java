package qaguru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBase.WebSteps;

public class TestAnnotatedSteps {

    private WebSteps steps = new WebSteps();

    @Test
    @Owner("eshennikova")
    @Link(name = "GitHub", url = "https://github.com")
    @Feature("Разделы в репозитории")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия раздела Issues на странице репозитория")

    public void testGithubAnnotated() {

        steps.openGithubPage();
        steps.searchForRepository();
        steps.goToRepository();
        steps.shouldSeeIssue();
        steps.takeScreenshot();

    }
}
