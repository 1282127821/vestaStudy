package com.xy.spring看书.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @fileName:MessageListener
 * @author:xy
 * @date:2019/6/8
 * @description:
 */
@Component
public class MessageListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent event) {
        String msg = event.getMsg();
        System.out.println(msg);
    }
}
