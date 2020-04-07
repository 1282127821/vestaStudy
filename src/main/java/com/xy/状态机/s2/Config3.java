package com.xy.状态机.s2;

import com.xy.状态机.Events;
import com.xy.状态机.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * @fileName:Config3
 * @author:xy
 * @date:2019/11/24
 * @description:
 */
@Configuration
@EnableStateMachine
public class Config3 extends EnumStateMachineConfigurerAdapter<States, Events> {
    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.S1)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.S1).target(States.S2)
                .event(Events.E1)
                .and()
                .withInternal()
                .source(States.S2)
                .event(Events.E2)
                .and()
                .withLocal()
                .source(States.S2).target(States.S3)
                .event(Events.E3);
    }
}
