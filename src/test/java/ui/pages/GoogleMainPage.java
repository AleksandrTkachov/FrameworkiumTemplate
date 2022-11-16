package ui.pages;

import com.frameworkium.core.ui.UITestLifecycle;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleMainPage extends BasePage<GoogleMainPage> {

    @Name("Search input")
    @Visible
    @FindBy(css = ".gLFyf.gsfi")
    private WebElement searchInput;

    @Name("Search button")
    @FindBy(xpath = "//*[@class = 'FPdoLc lJ9FBc']//input[@class = 'gNO89b']")
    private WebElement searchBtn;

    @Name("Searching result list")
    @FindBy(css = "#search .g")
    private List<WebElement> searchResults;


    public GoogleMainPage() {
    }

    @Step("Open Google main page")
    public static GoogleMainPage open() {
        UITestLifecycle.get().getWebDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return PageFactory.newInstance(GoogleMainPage.class, "https://google.com");
    }

    @Step("Search for {0}")
    public GoogleMainPage search(String searchRequest) {
        searchInput.sendKeys(searchRequest);
        searchBtn.click();
        return PageFactory.newInstance(GoogleMainPage.class);
    }

    @Step("Return number of results of the request")
    public int getResultsNumber() {
        List<WebElement> resultList = wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
        return resultList.size();
    }
}
