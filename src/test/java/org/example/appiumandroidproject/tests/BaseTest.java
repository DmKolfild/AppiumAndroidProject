package org.example.appiumandroidproject.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.example.appiumandroidproject.Helper;
import org.example.appiumandroidproject.pages.IntroScreen;
import org.example.appiumandroidproject.pages.NoteScreen;
import org.example.appiumandroidproject.pages.SearchScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.ScreenOrientation;

import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;
import java.util.Objects;


public class BaseTest {
    private static AndroidDriver driver;
    // Запуск тестов с заданной ориентацией экрана: mvn clean test -Dorientation=landscape
    private static final String ORIENTATION = System.getProperty("orientation");
    // Запуск тестов с wifi: mvn clean test -Dwifi=enabled
    private static final String WIFI = System.getProperty("wifi");

    @BeforeEach
    public void setUp() throws MalformedURLException {
        getDriver();
        setOrientation();
        setWiFi();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ((CanRecordScreen) getDriver()).startRecordingScreen();
    }

    public static AndroidDriver getDriver() throws MalformedURLException {
        if (driver == null)
            createDriver();
        if (driver.toString().contains("(null)"))
            createDriver();
        return driver;
    }

    private static void createDriver() throws MalformedURLException {
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
    }

    public IntroScreen getIntroScreen() throws MalformedURLException {
        return new IntroScreen(getDriver());
    }

    public NoteScreen getNoteScreen() throws MalformedURLException {
        return new NoteScreen(getDriver());
    }

    public SearchScreen getSearchScreen() throws MalformedURLException {
        return new SearchScreen(getDriver());
    }

    private static void setOrientation() throws MalformedURLException {
        if (Objects.equals(ORIENTATION, ScreenOrientation.LANDSCAPE.value()))
            Helper.rotateScreenLandspace();
        else if (Objects.equals(ORIENTATION, ScreenOrientation.PORTRAIT.value()))
            Helper.rotateScreenPortrait();
    }

    private static void setWiFi() throws MalformedURLException {
        if (Objects.equals(WIFI, "enabled"))
            Helper.enabledWiFiConnection();
        else if (Objects.equals(WIFI, "disabled"))
            Helper.disabledWiFiConnection();
    }

    private static void returnWiFiToOriginalState() throws MalformedURLException {
        if (Objects.equals(WIFI, "enabled"))
            Helper.disabledWiFiConnection();
        else if (Objects.equals(WIFI, "disabled"))
            Helper.enabledWiFiConnection();
    }

    @AfterEach
    public void tearDown() throws MalformedURLException {
        returnWiFiToOriginalState();
        ((CanRecordScreen) getDriver()).stopRecordingScreen();
        getDriver().quit();
    }
}
