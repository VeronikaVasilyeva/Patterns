package com.company;

public class Main {

    public static void main(String[] args) {
	    IСhat chat = new Chat();

        Message message = new Message();
        message.setRecipient("Адресат");
        message.setSender("Отправитель");
        message.setText("Привет я текст");

        //вызвать декораторы
        chat = new HidingUserDecorator(chat);
        chat = new EncrypteMessageDecorator(chat);

        chat.sendMessage(message);

        Message result = chat.getMessage();
        System.out.println(result.getSender()+"  "+result.getRecipient()+"  "+result.getText()+ "   " +((EncrypteMessageDecorator)chat).getEncryptedMessage());
    }
}
