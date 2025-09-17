package pattern.blackboard.service;

import org.springframework.context.ApplicationEvent;

import pattern.blackboard.core.BlackBoardObject;

import org.springframework.context.ApplicationEvent;

public class BlackBoardEvent extends ApplicationEvent {
    private final BlackBoardObject bbo;

    public BlackBoardEvent(Object source, BlackBoardObject bbo) {
        super(source);
        this.bbo = bbo;
    }

    public BlackBoardObject getBlackBoardObject() {
        return bbo;
    }
}

