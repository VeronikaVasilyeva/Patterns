package com.company;

/**
 * Created by veron on 06.11.2016.
 */
public class EmailRecipientBuilder {

    private final String Recipient;

    public EmailRecipientBuilder(String rep) {
        Recipient = rep;
    }

    public FinalEmailBuilder appendText(String text) {
        return new FinalEmailBuilder(Recipient, text);
    }
}
