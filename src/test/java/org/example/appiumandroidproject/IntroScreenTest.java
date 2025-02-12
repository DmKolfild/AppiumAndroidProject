package org.example.appiumandroidproject;// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client

import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntroScreenTest {

    private AndroidDriver driver;
    private IntroScreen introScreen;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        var options = new BaseOptions()
                .amend("appium:app", "/home/dnkolfild/Downloads/Notes_1.57_APKPure.apk")
                .amend("platformName", "Android")
                .amend("appium:deviceName", "TestDevice")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub/");

        driver = new AndroidDriver(remoteUrl, options);
        introScreen = new IntroScreen(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sampleTest() {
        assertTrue(introScreen.checkCreateNoteButtonIsEnable(), "Не доступна кнопка добавления новой заметки");
    }

}