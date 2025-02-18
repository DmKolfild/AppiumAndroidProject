package org.example.appiumandroidproject.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.appiumandroidproject.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;


public class IntroScreen {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(IntroScreen.class));
    private final AndroidDriver driver;

    @AndroidFindBy(id = "com.gcteam.tonote:id/fab")
    private WebElement createNoteButton;

    @AndroidFindBy(id = "com.gcteam.tonote:id/title_text")
    private WebElement titleOfNote;

    @AndroidFindBy(id = "com.gcteam.tonote:id/content_text")
    private WebElement contentOfNote;

    @AndroidFindBy(id = "com.gcteam.tonote:id/card_view")
    private WebElement cardView;

    @AndroidFindBy(id = "com.gcteam.tonote:id/menu_item_search")
    private WebElement searchButton;

    public IntroScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressCreateNoteButton() {
        LOG.info("Кликнуть по кнопке создания новой заметки");
        createNoteButton.click();
    }

    public String getTitle() {
        LOG.info("Получение заголовка заметки");
        return titleOfNote.getText();
    }

    public String getContent() {
        LOG.info("Получение содержания заметки");
        return contentOfNote.getText();
    }

    public void pressCardView() {
        LOG.info("Клик по карточке заметки");
        cardView.click();
    }

    public void pressSearch() {
        LOG.info("Клик по кнопке поиска");
        searchButton.click();
    }
}
