package com.company;

/**
 * Created by veron on 06.11.2016.
 */
public class Email {
    private String Text;
    private String Recipient;
    private String Cc;
    private String Subject;

    public Email(String recipient, String text, String cc, String subject) {
        Text = text;
        Recipient = recipient;
        Cc = cc;
        Subject = subject;
    }
    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getRecipient() {
        return Recipient;
    }

    public void setRecipient(String recipient) {
        Recipient = recipient;
    }

    public String getCc() {
        return Cc;
    }

    public void setCc(String cc) {
        Cc = cc;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    @Override
    public String toString() {
        return "Отправитель: "+getRecipient() + "\nСообщение: " + getText() + "\nКопия: " + getCc()+ "\nТема: "+ getSubject();
    }

}
