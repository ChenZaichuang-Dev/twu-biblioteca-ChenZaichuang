package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BookManager {
    private List<BookClass> bookList = new ArrayList<BookClass>();
    BookManager(){
        String bookName = "Book";
        String author = "Author";
        Integer year = 1970;
        for(; year < 1975; year++){
            BookClass newBook = new BookClass(bookName + year.toString() , author + year.toString() , year);
            bookList.add(newBook);
        }
    }
    private int findIndexInBookList(BookClass bookObj){
        BookClass bookTemp ;
        for(int index = 0; index < this.bookList.size(); index++){
            bookTemp = this.bookList.get(index);
            if(bookTemp.checkIfASameBook(bookObj)){
                return index;
            }
        }
        return -1;
    }
    boolean checkOutABook(BookClass bookObj){
        int index = this.findIndexInBookList(bookObj);
        if(index == -1){
            return false;
        }
        if(this.bookList.get(index).isCheckedOut()){
            return false;
        }
        this.bookList.get(index).checkOutTheBook();
        return true;
    }
    boolean returnABook(BookClass bookObj){
        int index = findIndexInBookList(bookObj);
        if(index == -1){
            return false;
        }
        if(!this.bookList.get(index).isCheckedOut()){
            return false;
        }
        this.bookList.get(index).returnTheBook();
        return true;
    }
    private String generateSpecificLengthOfString(int contentLength , String item){
        String restSpaceString = item;
        for(int i = 0; i < contentLength - item.length(); i++){
            restSpaceString += " ";
        }
        return restSpaceString;
    }
    void printBookListNotCheckedOut(int contentLength){
        String printInfo = "";
        BookClass bookTemp;
        printInfo += this.generateSpecificLengthOfString(contentLength , "Book Name") +
                this.generateSpecificLengthOfString(contentLength , "Author/Year Published") + "\n";
        for(int index = 0; index < this.bookList.size(); index++){
            bookTemp = this.bookList.get(index);
            if(!bookTemp.isCheckedOut()) {
                printInfo += bookTemp.generatePrintInfoOfThisBook(contentLength);
            }
        }
        System.out.println(printInfo);
    }
    static BookClass generateBookObjFromString(String bookInfo){
        String pattern = "([^,]+),([^,]+),(\\d+)";
        Pattern patternObj = Pattern.compile(pattern);
        Matcher matcherObj = patternObj.matcher(bookInfo);
        if (matcherObj.find() && matcherObj.groupCount() == 3){
            return new BookClass(matcherObj.group(1) , matcherObj.group(2) , Integer.parseInt(matcherObj.group(3)));
        } else {
            return null;
        }
    }
}
