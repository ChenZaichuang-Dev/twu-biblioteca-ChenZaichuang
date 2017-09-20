package com.twu.biblioteca;

import java.io.IOException;

class MenuNodeManager {
    private MenuNodeHead menuNodeHead = new MenuNodeHead();
    private BookManager bookManager = new BookManager();
    MenuNodeManager(){
        MenuNodeForListBooks menuNodeForListBooks = new MenuNodeForListBooks();
        MenuNodeForCheckOutBooks menuNodeForCheckOutBooks = new MenuNodeForCheckOutBooks();
        MenuNodeForReturnBooks menuNodeForReturnBooks = new MenuNodeForReturnBooks();
        MenuNodeForQuit menuNodeForQuit = new MenuNodeForQuit();
        setFatherAndChild(this.menuNodeHead , menuNodeForListBooks);
        setFatherAndChild(this.menuNodeHead , menuNodeForCheckOutBooks);
        setFatherAndChild(this.menuNodeHead , menuNodeForReturnBooks);
        setFatherAndChild(this.menuNodeHead , menuNodeForQuit);
    }
    private void setFatherAndChild(MenuNode fartherNode , MenuNode childNode){
        fartherNode.setMyChild(childNode);
        childNode.setMyFarther(fartherNode);
    }
    void runMenu() throws IOException {
        MenuNode runMenuNodeObj = this.menuNodeHead;
        while(runMenuNodeObj != null){
            runMenuNodeObj = runMenuNodeObj.menuFunction(bookManager);
        }
    }
}
