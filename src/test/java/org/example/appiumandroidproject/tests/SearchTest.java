package org.example.appiumandroidproject.tests;

import org.example.appiumandroidproject.MyExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class SearchTest extends BaseTest {
    @Override
    @BeforeEach
    public void setUp() throws MalformedURLException {
        super.setUp();
    }

    @Test
    @DisplayName("Поиск созданной заметки по заголовку")
    public void searchNoteByTitle() throws MalformedURLException {
        String title = "Find test in title";
        String searchText = "test";
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        getNoteScreen().sendTitle(title);
        getNoteScreen().pressSaveButton();
        getIntroScreen().pressSearch();
        getSearchScreen().sendTextInTheSearchField(searchText);
        getSearchScreen().pressCardView();
        getNoteScreen().pressOkButtonInTheHelpForms();
        assertTrue(getNoteScreen().checkTitleContainsText(searchText));
    }

    @Test
    @DisplayName("Поиск созданной заметки по ссодержанию")
    public void searchNoteByContent() throws MalformedURLException {
        String content = "Find test in title";
        String searchText = "test";
        getIntroScreen().pressCreateNoteButton();
        getNoteScreen().pressOkButtonInTheHelpForms();
        getNoteScreen().sendContent(content);
        getNoteScreen().pressSaveButton();
        getIntroScreen().pressSearch();
        getSearchScreen().sendTextInTheSearchField(searchText);
        getSearchScreen().pressCardView();
        getNoteScreen().pressOkButtonInTheHelpForms();
        assertTrue(getNoteScreen().checkContentContainsText(searchText));
    }
}
