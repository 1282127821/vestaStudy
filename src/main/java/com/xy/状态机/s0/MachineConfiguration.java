package com.xy.状态机.s0;

import com.xy.状态机.Events;
import com.xy.状态机.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class MachineConfiguration extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
                .initial(States.AVAILABLE)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                .withExternal()
                .source(States.AVAILABLE)
                .target(States.BORROWED)
                .event(Events.BORROW)
                .and()
                .withExternal()
                .source(States.BORROWED)
                .target(States.AVAILABLE)
                .event(Events.RETURN)
                .and()
                .withExternal()
                .source(States.AVAILABLE)
                .target(States.IN_REPAIR)
                .event(Events.START_REPAIR)
                .and()
                .withExternal()
                .source(States.IN_REPAIR)
                .target(States.AVAILABLE)
                .event(Events.END_REPAIR);
    }
    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config.withConfiguration()
                .autoStartup(true);
    }
}
