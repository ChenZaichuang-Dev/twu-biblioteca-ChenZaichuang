package com.twu.biblioteca;

import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class ConsoleIOFuncTest {
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
    public void test() throws Exception {
        String inputString = "Hello World\n";
        String expectPrintString = inputString;
        ConsoleIOFunc.showInfoToConsole(inputString);
        assertEquals(expectPrintString, bytes.toString());
        System.setIn(new FileInputStream("resource/inputOptionNumber0.txt"));
        ConsoleIOFunc.showInfoAndReadDataFromConsole(inputString);
        expectPrintString += inputString;
        assertEquals(expectPrintString, bytes.toString());
    }
}
