package com.company;

public class Main {

    public static void main(String[] args) {
        RunEmailbuilder();
    }

    private static void RunEmailbuilder() {
        Email email1 = new EmailBuilder()
                .addRecipient("Вася")
                .appendText("Я поехал в девревню\n")
                .appendText("Скоро вернусь.")
                .Build();
        Email email2 = new EmailBuilder()
                .addRecipient("Кузя")
                .appendText("Чуваки, классные пары у вас")
                .addCopyTo("Андрей")
                .addSubject("Благодарность")
                .Build();

        System.out.println(email1);
        System.out.println(email2);
    }
}
