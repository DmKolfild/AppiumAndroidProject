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

    public IntroScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public Boolean checkCreateNoteButtonIsEnable() {
        LOG.info("Проверка наличия кнопки добавления новой заметки");
        return createNoteButton.isEnabled();
    }
}
