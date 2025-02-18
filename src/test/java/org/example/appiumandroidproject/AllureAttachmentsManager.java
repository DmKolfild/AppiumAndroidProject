package org.example.appiumandroidproject;

import io.qameta.allure.Attachment;
import org.example.appiumandroidproject.tests.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;


public class AllureAttachmentsManager {
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshotToAllure() throws MalformedURLException {
        return ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "video", type = "video/mp4")
    public static byte[] attachVideoToAllure(byte[] video) {
        return video;
    }
}
