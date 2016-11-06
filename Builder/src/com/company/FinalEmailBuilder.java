package com.company;

/**
 * Created by veron on 06.11.2016.
 */
public class FinalEmailBuilder {
    private final String Recipient;
    private String Text;
    private String Cc;
    private String Subject;

    public FinalEmailBuilder(String rep, String text) {
        Recipient = rep;
        Text = text;
    }

    public FinalEmailBuilder appendText(String text) {
        Text += text;
        return this;
    }

    public FinalEmailBuilder addCopyTo(String cc) {
        Cc = cc;
        return this;
    }

    public FinalEmailBuilder addSubject(String sub) {
        Subject = sub;
        return this;
    }

    public Email Build() {
        return new Email(Recipient, Text, Cc, Subject);
    }
}
