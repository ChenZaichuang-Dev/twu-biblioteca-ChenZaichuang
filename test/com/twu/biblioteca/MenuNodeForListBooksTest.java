package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MenuNodeForListBooksTest {
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    @Before
    public void setUp() throws Exception {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }
    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }
    @Test
    public void test() throws Exception {
        MenuNodeForListBooks menuNodeForListBooks = new MenuNodeForListBooks();
        BookManager bookManager = new BookManager();
        menuNodeForListBooks.setMyFarther(menuNodeForListBooks);
        MenuNode returnedMenuNode = menuNodeForListBooks.menuFunction(bookManager);
        String expectPrintString =  "Book Name                " + "Author/Year Published    " + "\n" +
                                    "Book1970                 " + "Author1970/1970          " + "\n" +
                                    "Book1971                 " + "Author1971/1971          " + "\n" +
                                    "Book1972                 " + "Author1972/1972          " + "\n" +
                                    "Book1973                 " + "Author1973/1973          " + "\n" +
                                    "Book1974                 " + "Author1974/1974          " + "\n" + "\n";
        assertEquals(menuNodeForListBooks, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());
    }
}
