package com.company;

/**
 * Created by veron on 06.11.2016.
 */
public class EmailBuilder {

    public EmailRecipientBuilder addRecipient(String rep) {
        return new EmailRecipientBuilder(rep);
    }
}
