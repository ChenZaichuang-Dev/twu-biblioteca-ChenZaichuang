package com.twu.biblioteca;

import java.io.IOException;

public class MenuNodeForListBooks extends MenuNode {
    public MenuNode menuFunction(BookManager bookManager) throws IOException {
        this.bookManager = bookManager;
        ConsoleIOFunc.clearTheConsoleContent();
        int contentLength = 25;
        this.bookManager.printBookListNotCheckedOut(contentLength);
        return this.fartherMenuNode.get(0);
    }
}
