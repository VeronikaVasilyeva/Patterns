package com.company;

/**
 * Created by veron on 02.11.2016.
 */
public abstract class ChatDecoratorBase implements IСhat {

    protected final IСhat decoratee;

    protected ChatDecoratorBase(IСhat chat) {
        this.decoratee = chat;
    }
}
