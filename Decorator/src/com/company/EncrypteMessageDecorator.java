package com.company;

/**
 * Created by veron on 02.11.2016.
 */
public class EncrypteMessageDecorator extends ChatDecoratorBase {

    public EncrypteMessageDecorator(IСhat chat) {
        super(chat);
    }

    @Override
    public void sendMessage(Message message) {
        Message result = new Message();
        result.setText("<code>"+message.getText()+"</code>");
        result.setRecipient(message.getRecipient());
        result.setSender(message.getSender());

        super.decoratee.sendMessage(result);
    }

    @Override
    public Message getMessage() {
        Message message = super.decoratee.getMessage();
        String encryptedText = message.getText();
        String decrypredText = encryptedText.substring(6,20);

        Message result = new Message();
        result.setText(decrypredText);
        result.setRecipient(message.getRecipient());
        result.setSender(message.getSender());

        return result;
    }

    public String getEncryptedMessage() {
        return super.decoratee.getMessage().getText();
    }
}
