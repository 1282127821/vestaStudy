package com.xy.spring看书.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @fileName:Config
 * @author:xy
 * @date:2019/6/8
 * @description:
 */
@Configuration
//@Import(Config2.class)
@Import(Animal.class)
public class Config {
    @Bean
    public Dog name() {
        return new Dog();
    }
}
/**其实@Import就是把某个类也当做 配置类的一部分,比如下面的Config2没有使用@Configuration注解修饰
 * 如果我们直接获取bean  ctx.getBean("name2") 会导致如下错误：
 *No bean named 'name2' available
 * 但是如果在@Configuration所在类使用@Import(Config2.class)就可以正常获取到
 *
 * 当然还有第二个作用，可以直接把一个类放入spring容器,注意他和@Bean不同，@Bean是将发放名作为beanName
 * 但是@Import是将，所以我这里按照类型获取的ctx.getBean(Animal.class) 他不是将animal作为beanName
 * 而是将全类名作为beanName  com.xy.spring看书.config.Animal
 *
 */
class Config2 {
    @Bean
    public Cat name2() {
        return new Cat();
    }
}

class Dog {
}

class Cat{
}

