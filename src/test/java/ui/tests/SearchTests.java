package ui.tests;

import org.testng.annotations.Test;
import ui.pages.GoogleMainPage;

import static com.google.common.truth.Truth.assertThat;

public class SearchTests extends BaseTest {

    @Test
    public void positiveSearchTest() {

        GoogleMainPage page = GoogleMainPage
                .open()
                .search("Search request");

        int searchingResultNumber = page.getResultsNumber();

        assertThat(searchingResultNumber).isEqualTo(9);
    }
}

