package testBase;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static testBase.TestData.*;

public class WebSteps {

    TestData testdata = new TestData();

    @Step("Открыть главную страницу GitHub")
    public void openGithubPage() {
        open(testdata.getNameWebsite());
    }

    @Step("Ввести в поле поиска название репозитория")
    public void searchForRepository() {
        nameWebsiteSelector.click();
        nameWebsiteSelector.sendKeys(testdata.getRepositorySearch());
        nameWebsiteSelector.submit();

    }

    @Step("Перейти в репозиторий")
    public void goToRepository() {
        $(linkText(testdata.getRepositorySearch())).click();
    }

    @Step("Проверить, что на странице репозитория есть раздел Issues")
    public void shouldSeeIssue() {
        issuesSelector.shouldBe(Condition.visible).shouldHave(Condition.text(testdata.getTextSearch()));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
