package org.example.appiumandroidproject.tests;// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client

import java.net.MalformedURLException;

import org.example.appiumandroidproject.MyExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MyExtension.class)
public class IntroScreenTest extends BaseTest {
    @Override
    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
    }

    @Test
    @DisplayName("Создание заметки c заголовком и содержанием")
    @Tag("smoke")
    public void createNoteWithTitleAndContent() throws MalformedURLException {
        String title = "test title";
        String content = "test content";
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        getNoteScreen().sendTitle(title);
        getNoteScreen().sendContent(content);
        getNoteScreen().pressSaveButton();
        assertEquals(title, getIntroScreen().getTitle(), "Заголовок не соответствуют заданному");
        assertEquals(content, getIntroScreen().getContent(), "Содержание не соответствует заданному");
    }

    @ParameterizedTest(name = "#{index} - создание заметки с заголовком \"{0}\" ({1})")
    @CsvSource({
            "latin, латиница",
            "кириллица, кириллица",
            "UPPER CASE, текст в верхнем регистре",
            "lower case, текст в нижнем регистре",
            "СмеШаннЫЙ РеГИстр, смешанный регистр",
            "~`!@#$%^&*()_+?:\"{}[];’, спец. символы",
            "0123456789, цифры",
            "'           ', строка из пробелов",
            "'   пробелы в начале, в середине, в конце ', пробелы в начале, в середине, в конце строки",
            "öäβ, буквы других алфавитов",
            "▲♦♥, смайлкики"
    })
    @DisplayName("Создание заметки c различными заголовками")
    public void createNoteOnlyWithTitle(String title, String description) throws MalformedURLException {
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        getNoteScreen().sendTitle(title);
        getNoteScreen().pressSaveButton();
        assertEquals(title, getIntroScreen().getTitle(), "Заголовок не соответствуют заданному");
    }

    @ParameterizedTest(name = "#{index} - создание заметки с содержанием \"{0}\" ({1})")
    @CsvSource({
            "latin, латиница",
            "кириллица, кириллица",
            "UPPER CASE, текст в верхнем регистре",
            "lower case, текст в нижнем регистре",
            "СмеШаннЫЙ РеГИстр, смешанный регистр",
            "~`!@#$%^&*()_+?:\"{}[];’, спец. символы",
            "0123456789, цифры",
            "'           ', строка из пробелов",
            "'   пробелы в начале, в середине, в конце ', пробелы в начале, в середине, в конце строки",
            "öäβ, буквы других алфавитов",
            "▲♦♥, смайлкики"
    })
    @DisplayName("Создание заметки c различным содержанием")
    public void createNoteOnlyWithContex(String title, String description) throws MalformedURLException {
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        getNoteScreen().sendContent(title);
        getNoteScreen().pressSaveButton();
        assertEquals(title, getIntroScreen().getContent(), "Содержание не соответствует заданному");
    }

}