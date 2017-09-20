package com.twu.biblioteca;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuNodeTest {

    @Test
    public void test() throws Exception {
        String expectReturnedMenuNode = null;
        MenuNode menuNode = new MenuNode();
        BookManager bookManager = new BookManager();
        assertEquals(expectReturnedMenuNode , menuNode.menuFunction(bookManager));
    }
}
