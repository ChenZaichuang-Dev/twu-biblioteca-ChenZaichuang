package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MenuNodeHeadTest {
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
        String expectPrintString =  "\t\tWelcome\t\t\n" + "1.List Books\n" + "2.Check Out Books\n" +
                "3.Return Books\n" + "4.Quit\n" + "input the option number:" +
                "Select a valid option!\n";
        MenuNodeHead menuNodeHead = new MenuNodeHead();
        BookManager bookManager = new BookManager();
        MenuNode expectMenuNode = menuNodeHead;
        menuNodeHead.setMyChild(null);
        assertEquals(expectMenuNode, menuNodeHead.menuFunction(bookManager));
        assertEquals(expectPrintString, bytes.toString());

        expectPrintString +=  "\t\tWelcome\t\t\n" + "1.List Books\n" + "2.Check Out Books\n" +
                "3.Return Books\n" + "4.Quit\n" + "input the option number:";
        System.setIn(new FileInputStream("resource/inputOptionNumber1.txt"));
        expectMenuNode = null;
        assertEquals(expectMenuNode, menuNodeHead.menuFunction(bookManager));
        assertEquals(expectPrintString, bytes.toString());
    }
}
