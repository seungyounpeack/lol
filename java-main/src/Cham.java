package src;

import java.util.ArrayList;
import java.util.List;

public class Cham {
    String name;
    int py ;
    int deal;
    List<String> chat;
    public String getAttackMent(){
        int index = (int)(Math.random() * (chat.size() - 1));
        return chat.get(index);
    }

}
