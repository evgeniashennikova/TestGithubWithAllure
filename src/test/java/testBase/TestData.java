package testBase;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TestData {

    private String nameWebsite = "https://github.com";
    private String repositorySearch = "evgeniashennikova/TestDragAndDrop";
    private String textSearch = "Issues";
    public static SelenideElement
            nameWebsiteSelector = $("input[placeholder=\"Search GitHub\"]"),
            issuesSelector = $("#issues-tab");

    public String getNameWebsite() {
        return nameWebsite;
    }

    public String getRepositorySearch() {
        return repositorySearch;
    }

    public String getTextSearch() {
        return textSearch;
    }

}
