package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactTest extends BaseTest{
    @Test
    public void createContact() {
        loginPage.
                open().
                login("drak@tms.sandbox","Password01!!" ).
                isPageOpened();
        contactCreationPage.
                open().
                createContact("3752589555", "37245854455", "Laura", "Smidt", "546545645","Cargo",
                "785145556", "Sunshine", "9552455", "abc@gh.com",
                "Ivanov", "959599797", "momom@mom.mom", "Grodno", "Belucha",
                "Mogilev", "White State","322626", "RF", "7474741",
                "USA", "English","Vivo Street", "Nova Street", "Be happy!!").
                saveDate();

        assertEquals(contactCreationPage.getTitle(),"Activity", "the contact has not been created");
    }
}
