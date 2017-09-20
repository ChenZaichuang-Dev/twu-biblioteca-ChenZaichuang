package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;
public class MenuNodeForCheckOutBooksTest {
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    InputStream keyBoard = null;
    @Before
    public void setUp() throws Exception {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        keyBoard = System.in;
        System.setOut(new PrintStream(bytes));
    }
    @After
    public void tearDown() throws Exception {
        System.setOut(console);
        System.setIn(keyBoard);
    }
    @Test
    public void test() throws IOException {
        System.setIn(new FileInputStream("resource/inputOptionNumber0.txt"));
        MenuNodeForCheckOutBooks menuNodeForCheckOutBooks = new MenuNodeForCheckOutBooks();
        BookManager bookManager = new BookManager();
        menuNodeForCheckOutBooks.setMyFarther(null);
        MenuNode returnedMenuNode = menuNodeForCheckOutBooks.menuFunction(bookManager);
        String expectPrintString =  "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
                                    "and input q for quit:" + "That book is not available.\n";
        assertEquals(menuNodeForCheckOutBooks, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());

        System.setIn(new FileInputStream("resource/inputContentOfBookInfo.txt"));
        returnedMenuNode = menuNodeForCheckOutBooks.menuFunction(bookManager);
        expectPrintString +=    "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
                                "and input q for quit:" + "Thank you! Enjoy the book\n";
        assertEquals(null, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());

        System.setIn(new FileInputStream("resource/inputQForQuit.txt"));
        returnedMenuNode = menuNodeForCheckOutBooks.menuFunction(bookManager);
        expectPrintString +=    "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
                                "and input q for quit:";
        assertEquals(null, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());
    }
}
