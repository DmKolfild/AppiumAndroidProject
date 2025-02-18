package org.example.appiumandroidproject;

import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;
import org.example.appiumandroidproject.tests.BaseTest;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.net.MalformedURLException;


public class MyExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws MalformedURLException {
        String base64String = ((CanRecordScreen) BaseTest.getDriver()).stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        if (extensionContext.getExecutionException().isPresent()) AllureAttachmentsManager.attachVideoToAllure(data);
    }
}
