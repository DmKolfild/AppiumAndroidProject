package org.example.appiumandroidproject.tests;// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client

import java.net.MalformedURLException;

import org.example.appiumandroidproject.MyExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class IntroScreenTest extends BaseTest {
    @Override
    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
    }

    @Test
    public void sampleTest() throws MalformedURLException {
        assertTrue(getIntroScreen().checkCreateNoteButtonIsEnable(), "Не доступна кнопка добавления новой заметки");
    }

}