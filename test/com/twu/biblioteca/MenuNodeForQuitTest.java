package com.twu.biblioteca;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuNodeForQuitTest {

    @Test
    public void test() throws Exception {
        String expectReturnedMenuNode = null;
        MenuNodeForQuit menuNodeForQuit = new MenuNodeForQuit();
        BookManager bookManager = new BookManager();
        assertEquals(expectReturnedMenuNode , menuNodeForQuit.menuFunction(bookManager));
    }
}
