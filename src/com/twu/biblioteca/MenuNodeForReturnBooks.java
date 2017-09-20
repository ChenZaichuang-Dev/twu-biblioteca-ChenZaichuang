package com.twu.biblioteca;

import java.io.IOException;

public class MenuNodeForReturnBooks extends MenuNode{
    public MenuNode menuFunction(BookManager bookManager) throws IOException {
        String input;
        this.bookManager = bookManager;
        ConsoleIOFunc.clearTheConsoleContent();
        this.printInfo = "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
                "and input q for quit:";
        input = ConsoleIOFunc.showInfoAndReadDataFromConsole(this.printInfo);
        if(input.equals("q")){
            return this.fartherMenuNode.get(0);
        }
        boolean result = this.handleInput(input);
        this.handleInputResult(result);
        return result ? this.fartherMenuNode.get(0) : this;
    }
    private boolean handleInput(String input){
        BookClass bookObj = BookManager.generateBookObjFromString(input);
        return bookObj != null && this.bookManager.returnABook(bookObj);
    }
    private void handleInputResult(boolean result){
        this.printInfo = result ? "Thank you for returning the book.\n" : "That is not a valid book to return.\n";
        ConsoleIOFunc.showInfoToConsole(this.printInfo);
    }
}
