package com.twu.biblioteca;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuNodeHead extends MenuNode{
    public MenuNode menuFunction(BookManager bookManager) throws IOException {
        String input;
        this.bookManager = bookManager;
        ConsoleIOFunc.clearTheConsoleContent();
        this.printInfo = "\t\tWelcome\t\t\n" + "1.List Books\n" + "2.Check Out Books\n" +
                        "3.Return Books\n" + "4.Quit\n" + "input the option number:";
        input = ConsoleIOFunc.showInfoAndReadDataFromConsole(this.printInfo);
        int result = this.handleInput(input);
        this.handleInputResult(result);
        return result == -1 ? this : this.childrenMenuNode.get(result - 1);
    }
    private int handleInput(String input){
        String pattern = "^([1234])$";
        Pattern patternObj = Pattern.compile(pattern);
        Matcher matcherObj = patternObj.matcher(input);
        if (matcherObj.find() && matcherObj.groupCount() == 1){
                String handleResult = matcherObj.group(1);
            return Integer.parseInt(handleResult);
        } else {
            return -1;
        }
    }
    private void handleInputResult(int result){
        this.printInfo = result == -1 ? "Select a valid option!\n" : "";
        ConsoleIOFunc.showInfoToConsole(this.printInfo);
    }
}
