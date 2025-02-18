package org.example.appiumandroidproject.tests;


import org.example.appiumandroidproject.MyExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class NoteScreenTest extends BaseTest {
    @Override
    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
    }

    @Test
    @DisplayName("Отображается клавиатура при создании новой заметки")
    public void keyboardIsShownWhenCreatingANewNote() throws MalformedURLException {
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        assertTrue(getNoteScreen().checkIfKeyBoardIsShown(), "Не отображается клавиатура");
    }

    @Test
    @DisplayName("Не отображается клавиатура при открытии созданной заметки")
    public void keyboardIsNotShownWhenOpeningNote() throws MalformedURLException {
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        getNoteScreen().sendTitle("without keyboard");
        getNoteScreen().pressSaveButton();
        getIntroScreen().pressCardView();
        getNoteScreen().pressOkButtonInTheHelpForms();
        assertFalse(getNoteScreen().checkIfKeyBoardIsShown(), "Отображается клавиатура");
    }

    @Test
    @DisplayName("Кликабельна иконка уведомлений")
    @Tag("smoke")
    public void notifyIconIsEnabledAndDisplayed() throws MalformedURLException {
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        assertTrue(getNoteScreen().checkIfNotifyIconIsEnableAndDisplayed(), "Не доступна иконка уведомлений");
    }

    @Test
    @DisplayName("Кликабельна и отображается иконка уведомлений")
    @Tag("smoke")
    public void widgetIconIsEnabledAndDisplayed() throws MalformedURLException {
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        assertTrue(getNoteScreen().checkIfWidgetIconIsEnableAndDisplayed(), "Не доступна иконка виджета");
    }

    @Test
    @DisplayName("Кликабельна и отображается иконка установки пароля")
    @Tag("smoke")
    public void encryptIconIsEnabledAndDisplayed() throws MalformedURLException {
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        assertTrue(getNoteScreen().checkIfEncryptIconIsEnableAndDisplayed(), "Не доступна иконка установки пароля");
    }

    @Test
    @DisplayName("Кликабельна и отображается палитра выбора цвета для карточки")
    @Tag("smoke")
    public void colorCardIsEnabledAndDisplayed() throws MalformedURLException {
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        assertTrue(getNoteScreen().checkIfColorCardIsEnableAndDisplayed(), "Не доступна палитра выбора цвета для карточки");
    }

    @Test
    @DisplayName("Кликабельна и отображается иконка закрепления заметки")
    @Tag("smoke")
    public void pinnedIndicatorIsEnabledAndDisplayed() throws MalformedURLException {
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        assertTrue(getNoteScreen().checkIfPinnedIndicatorIsEnableAndDisplayed(), "Не доступна иконка закрепления заметки");
    }

    @Test
    @DisplayName("Кликабельна и отображается иконка календаря")
    @Tag("smoke")
    public void eventButtonIsEnabledAndDisplayed() throws MalformedURLException {
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        assertTrue(getNoteScreen().checkIfEventButtonIsEnableAndDisplayed(), "Не доступна иконка календаря");
    }
}
