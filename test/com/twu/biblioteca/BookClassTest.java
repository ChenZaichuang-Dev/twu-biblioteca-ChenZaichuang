package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookClassTest {
    @Test
    public void test() {
        BookClass bookTest1 = new BookClass("1" , "A" , 1);
        BookClass bookTest2 = new BookClass("1" , "A" , 1);
        BookClass bookTest3 = new BookClass("2" , "A" , 1);
        assertEquals(bookTest1.checkIfASameBook(bookTest2) , true);
        assertEquals(bookTest1.checkIfASameBook(bookTest3) , false);
        assertEquals(bookTest1.isCheckedOut() , false);
        bookTest1.checkOutTheBook();
        assertEquals(bookTest1.isCheckedOut() , true);
        bookTest1.returnTheBook();
        assertEquals(bookTest1.isCheckedOut() , false);
        String testString = bookTest1.generatePrintInfoOfThisBook(4);
        assertEquals(testString , "1   " + "A/1 " + "\n");
    }
}
