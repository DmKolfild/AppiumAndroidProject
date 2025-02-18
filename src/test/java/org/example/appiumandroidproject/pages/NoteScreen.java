package org.example.appiumandroidproject.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.appiumandroidproject.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class NoteScreen {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(NoteScreen.class));
    private final AndroidDriver driver;

    @AndroidFindBy(id = "com.gcteam.tonote:id/titleEdit")
    private WebElement titleOfNote;

    @AndroidFindBy(id = "com.gcteam.tonote:id/contentEdit")
    private WebElement contentOfNote;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okButtonInTheHelpForms;

    @AndroidFindBy(id = "com.gcteam.tonote:id/menu_item_save")
    private WebElement saveButton;

    @AndroidFindBy(id = "com.gcteam.tonote:id/notifyIcon")
    private WebElement notifyIcon;

    @AndroidFindBy(id = "com.gcteam.tonote:id/widgetIcon")
    private WebElement widgetIcon;

    @AndroidFindBy(id = "com.gcteam.tonote:id/encryptIcon")
    private WebElement encryptIcon;

    @AndroidFindBy(id = "com.gcteam.tonote:id/colorCard")
    private WebElement colorCard;

    @AndroidFindBy(id = "com.gcteam.tonote:id/pinnedIndicator")
    private WebElement pinnedIndicator;

    @AndroidFindBy(id = "com.gcteam.tonote:id/eventButton")
    private WebElement eventButton;

    public NoteScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void sendTitle(String title) {
        LOG.info("Ввод заголовка для заметки");
        titleOfNote.sendKeys(title);
    }

    public void sendContent(String contex) {
        LOG.info("Ввод содержания для заметки");
        contentOfNote.sendKeys(contex);
    }

    public void pressOkButtonInTheHelpForms() {
        LOG.info("Клик по кнопке OK");
        okButtonInTheHelpForms.click();
    }

    public void pressSaveButton() {
        LOG.info("Клик по кнопке SAVE");
        saveButton.click();
    }

    public Boolean checkIfKeyBoardIsShown() {
        LOG.info("Проверка, что отображается клавиатура");
        return driver.isKeyboardShown();
    }

    public Boolean checkIfNotifyIconIsEnableAndDisplayed() {
        LOG.info("Проверка, что отображается иконка уведомлений");
        return notifyIcon.isDisplayed() && notifyIcon.isEnabled();
    }

    public Boolean checkIfWidgetIconIsEnableAndDisplayed() {
        LOG.info("Проверка, что отображается иконка виджета");
        return widgetIcon.isDisplayed() && widgetIcon.isEnabled();
    }

    public Boolean checkIfEncryptIconIsEnableAndDisplayed() {
        LOG.info("Проверка, что отображается иконка установки пароля");
        return encryptIcon.isDisplayed() && encryptIcon.isEnabled();
    }

    public Boolean checkIfColorCardIsEnableAndDisplayed() {
        LOG.info("Проверка, что отображается палитра выбора цвета для карточки");
        return colorCard.isDisplayed() && colorCard.isEnabled();
    }

    public Boolean checkIfPinnedIndicatorIsEnableAndDisplayed() {
        LOG.info("Проверка, что отображается иконка закрепления заметки");
        return pinnedIndicator.isDisplayed() && pinnedIndicator.isEnabled();
    }

    public Boolean checkIfEventButtonIsEnableAndDisplayed() {
        LOG.info("Проверка, что отображается иконка календаря");
        return eventButton.isDisplayed() && eventButton.isEnabled();
    }

    public Boolean checkTitleContainsText(String text) {
        return titleOfNote.getText().contains(text);
    }

    public Boolean checkContentContainsText(String text) {
        return contentOfNote.getText().contains(text);
    }
}
