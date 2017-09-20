package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuNode {
    String printInfo;
    List<MenuNode> fartherMenuNode = new ArrayList<>();
    List<MenuNode> childrenMenuNode = new ArrayList<>();
    BookManager bookManager;

    void setMyFarther(MenuNode fartherNode){
        fartherMenuNode.add(fartherNode);
    }
    void setMyChild(MenuNode childNode){
        childrenMenuNode.add(childNode);
    }
    public MenuNode menuFunction(BookManager bookManager) throws IOException {
        return null;
    }
}
