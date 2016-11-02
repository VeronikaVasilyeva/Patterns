package com.company;

/**
 * Created by veron on 02.11.2016.
 */
public class HidingUserDecorator extends ChatDecoratorBase {

    public HidingUserDecorator(IСhat chat) {
        super(chat);
    }

    @Override
    public void sendMessage(Message message) {
        Message result = new Message();
        result.setText(message.getText());
        result.setRecipient((message.getRecipient().hashCode())+"");
        result.setSender((message.getSender().hashCode())+"");

        super.decoratee.sendMessage(result);
    }

    @Override
    public Message getMessage() {
        return super.decoratee.getMessage();
    }
}
