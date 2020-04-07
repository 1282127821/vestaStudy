package com.xy.状态机.s1;

import com.xy.状态机.Events;
import com.xy.状态机.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;

import java.util.EnumSet;

/**
 * @fileName:Config1Enums
 * @author:xy
 * @date:2019/11/23
 * @description:
 */
@Configuration
@EnableStateMachine
public class Config1Enums
        extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states.withStates()
                .initial(States.AVAILABLE)
                .states(EnumSet.allOf(States.class));
    }

}
