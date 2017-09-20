package com.twu.biblioteca;

public class BookClass {
    private String bookName;
    private String author;
    private Integer yearPublished;
    private boolean isCheckedOut = false;
    public BookClass(String bookName, String author , Integer yearPublished) {
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
    }
    public boolean checkIfASameBook(BookClass bookObj){
        return (bookObj.bookName.equals(this.bookName) && bookObj.author.equals(this.author) && bookObj.yearPublished.equals(this.yearPublished));
    }
    public void checkOutTheBook(){
        this.isCheckedOut = true;
    }
    public void returnTheBook(){
        this.isCheckedOut = false;
    }
    public boolean isCheckedOut(){
        return this.isCheckedOut;
    }
    private String generateSpecificLengthOfString(int contentLength , String item){
        String restSpaceString = item;
        for(int i = 0; i < contentLength - item.length(); i++){
            restSpaceString += " ";
        }
        return restSpaceString;
    }
    public String generatePrintInfoOfThisBook(int contentLength){
        return generateSpecificLengthOfString(contentLength , this.bookName) +
                generateSpecificLengthOfString(contentLength , this.author + "/" + this.yearPublished.toString()) + "\n";
    }
}
