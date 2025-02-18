package org.example.appiumandroidproject;

import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.example.appiumandroidproject.pages.IntroScreen;
import org.example.appiumandroidproject.tests.BaseTest;
import org.openqa.selenium.ScreenOrientation;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;


public class Helper {
    private static final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(IntroScreen.class));

    public static void rotateScreenLandspace() throws MalformedURLException {
        LOG.info("Смена ориентации экрана на горизонтальную");
        BaseTest.getDriver().rotate(ScreenOrientation.LANDSCAPE);
    }

    public static void rotateScreenPortrait() throws MalformedURLException {
        LOG.info("Смена ориентации экрана на вертикальную");
        BaseTest.getDriver().rotate(ScreenOrientation.PORTRAIT);
    }

    public static void enabledWiFiConnection() throws MalformedURLException {
        LOG.info("Включение Wi-Fi");
        BaseTest.getDriver().setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
    }

    public static void disabledWiFiConnection() throws MalformedURLException {
        LOG.info("Выключение Wi-Fi");
        BaseTest.getDriver().setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
    }

    public static void pressEnter() throws MalformedURLException {
        LOG.info("Клик по кнопке 'ENTER'");
        BaseTest.getDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public static void pressSearch() throws MalformedURLException {
        LOG.info("Клик по кнопке 'SEARCH'");
        BaseTest.getDriver().pressKey(new KeyEvent(AndroidKey.SEARCH));
    }
}
