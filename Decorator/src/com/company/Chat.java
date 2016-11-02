package com.company;

/**
 * Created by veron on 02.11.2016.
 */
public class Chat implements IСhat{

    private Message savedMessage;

    @Override
    public void sendMessage(Message message) {
        this.savedMessage = message;
    }

    @Override
    public Message getMessage() {
        return savedMessage;
    }
}
