package com.xy.spring看书.event;

import org.springframework.context.ApplicationEvent;

/**
 * @fileName:MessageEvent
 * @author:xy
 * @date:2019/6/8
 * @description:
 */
public class MessageEvent extends ApplicationEvent {
    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MessageEvent(Object source) {
        super(source);
        msg= (String) source;
    }

    public String getMsg() {
        return msg;
    }
}
