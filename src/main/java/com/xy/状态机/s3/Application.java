package com.xy.状态机.s3;


import com.xy.状态机.Events;
import com.xy.状态机.States;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableStateMachine
public class Application implements CommandLineRunner {
    @Autowired
    private final StateMachine<States, Events> stateMachine;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    public Application(StateMachine<States, Events> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void run(String... args) {
        stateMachine.start();
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
        Map<Integer,Integer> map=new HashMap<>();

    }
}
