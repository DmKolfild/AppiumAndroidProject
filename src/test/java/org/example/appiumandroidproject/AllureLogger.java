package org.example.appiumandroidproject;

import io.qameta.allure.Step;
import org.slf4j.Logger;

import java.net.MalformedURLException;


public class AllureLogger {
    private final Logger logger;

    public AllureLogger(Logger logger) {
        this.logger = logger;
    }

    @Step("{logText}")
    public void info(String logText) {
        logger.info(logText);
    }

    @Step("{logText}")
    public void infoWithScreenshot(String logText) throws MalformedURLException {
        logger.info(logText);
        AllureAttachmentsManager.attachScreenshotToAllure();
    }

}

