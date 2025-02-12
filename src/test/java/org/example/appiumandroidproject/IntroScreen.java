package org.example.appiumandroidproject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/
public class IntroScreen {
    @AndroidFindBy(id = "com.gcteam.tonote:id/fab")
    private WebElement createNoteButton;

    public Boolean checkCreateNoteButtonIsEnable() {
        return createNoteButton.isEnabled();
    }

    public IntroScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
