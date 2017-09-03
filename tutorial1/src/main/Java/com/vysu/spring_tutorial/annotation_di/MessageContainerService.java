package com.vysu.spring_tutorial.annotation_di;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageContainerService {

    private List<String> msgContainer = new ArrayList<String>();

    private void readMessage(List<String> msg){
        this.msgContainer = msg;
    }

    public void showMessages(int count){
        for (String msg:msgContainer) {
            if(msgContainer.indexOf(msg)==count)break;
            else System.out.println(msg);
        }
    }

    public List<String> getMsgContainer() {
        return msgContainer;
    }

    public void setMsgContainer(List<String> msgContainer) {
        this.msgContainer = msgContainer;
    }

}
