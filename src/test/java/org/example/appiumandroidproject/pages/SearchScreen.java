package org.example.appiumandroidproject.pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.appiumandroidproject.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class SearchScreen {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(IntroScreen.class));
    private final AndroidDriver driver;

    @AndroidFindBy(id = "com.gcteam.tonote:id/searchText")
    private WebElement searchField;

    @AndroidFindBy(id = "com.gcteam.tonote:id/card_view")
    private WebElement cardView;

    public SearchScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void sendTextInTheSearchField(String text) {
        searchField.sendKeys(text);
    }

    public void pressCardView() {
        LOG.info("Клик по карточке заметки");
        cardView.click();
    }
}
