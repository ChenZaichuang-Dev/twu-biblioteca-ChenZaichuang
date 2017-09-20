package com.twu.biblioteca;

import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class BookManagerTest {
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
        BookManager bookManager = new BookManager();
        BookClass bookObjInList = new BookClass("Book1970" , "Author1970" , 1970);
        BookClass bookObjNotInList = new BookClass("Book1970" , "Author1970" , 1971);
        bookManager.printBookListNotCheckedOut(25);
        String expectPrintString =  "Book Name                " + "Author/Year Published    " + "\n" +
                                    "Book1970                 " + "Author1970/1970          " + "\n" +
                                    "Book1971                 " + "Author1971/1971          " + "\n" +
                                    "Book1972                 " + "Author1972/1972          " + "\n" +
                                    "Book1973                 " + "Author1973/1973          " + "\n" +
                                    "Book1974                 " + "Author1974/1974          " + "\n" + "\n";
        assertEquals(expectPrintString, bytes.toString());
        boolean resultOfcheckOutABook;
        resultOfcheckOutABook = bookManager.checkOutABook(bookObjNotInList);
        assertEquals(false , resultOfcheckOutABook);
        resultOfcheckOutABook = bookManager.checkOutABook(bookObjInList);
        assertEquals(true , resultOfcheckOutABook);
        bookManager.printBookListNotCheckedOut(25);
        expectPrintString +=    "Book Name                " + "Author/Year Published    " + "\n" +
                                "Book1971                 " + "Author1971/1971          " + "\n" +
                                "Book1972                 " + "Author1972/1972          " + "\n" +
                                "Book1973                 " + "Author1973/1973          " + "\n" +
                                "Book1974                 " + "Author1974/1974          " + "\n" + "\n";
        assertEquals(expectPrintString, bytes.toString());
        resultOfcheckOutABook = bookManager.checkOutABook(bookObjInList);
        assertEquals(false , resultOfcheckOutABook);
        bookManager.printBookListNotCheckedOut(25);
        expectPrintString +=    "Book Name                " + "Author/Year Published    " + "\n" +
                                "Book1971                 " + "Author1971/1971          " + "\n" +
                                "Book1972                 " + "Author1972/1972          " + "\n" +
                                "Book1973                 " + "Author1973/1973          " + "\n" +
                                "Book1974                 " + "Author1974/1974          " + "\n" + "\n";
        assertEquals(expectPrintString, bytes.toString());
        boolean resultOfReturnABook;
        resultOfReturnABook = bookManager.returnABook(bookObjNotInList);
        assertEquals(false , resultOfReturnABook);
        resultOfReturnABook = bookManager.returnABook(bookObjInList);
        assertEquals(true , resultOfReturnABook);
        bookManager.printBookListNotCheckedOut(25);
        expectPrintString +=    "Book Name                " + "Author/Year Published    " + "\n" +
                                "Book1970                 " + "Author1970/1970          " + "\n" +
                                "Book1971                 " + "Author1971/1971          " + "\n" +
                                "Book1972                 " + "Author1972/1972          " + "\n" +
                                "Book1973                 " + "Author1973/1973          " + "\n" +
                                "Book1974                 " + "Author1974/1974          " + "\n" + "\n";
        assertEquals(expectPrintString, bytes.toString());
        resultOfcheckOutABook = bookManager.returnABook(bookObjInList);
        assertEquals(false , resultOfcheckOutABook);
        bookManager.printBookListNotCheckedOut(25);
        expectPrintString +=    "Book Name                " + "Author/Year Published    " + "\n" +
                                "Book1970                 " + "Author1970/1970          " + "\n" +
                                "Book1971                 " + "Author1971/1971          " + "\n" +
                                "Book1972                 " + "Author1972/1972          " + "\n" +
                                "Book1973                 " + "Author1973/1973          " + "\n" +
                                "Book1974                 " + "Author1974/1974          " + "\n" + "\n";
        assertEquals(expectPrintString, bytes.toString());
        String bookInfo = "Book1970,Author1970,1970";
        BookClass expectedReturnedBookObj = new BookClass("Book1970" , "Author1970" , 1970);
        boolean isTheSame = expectedReturnedBookObj.checkIfASameBook(BookManager.generateBookObjFromString((bookInfo)));
        assertEquals(true , isTheSame);
        bookInfo = "Book1970,Author1970,1971";
        isTheSame = expectedReturnedBookObj.checkIfASameBook(BookManager.generateBookObjFromString((bookInfo)));
        assertEquals(false , isTheSame);
    }
}
