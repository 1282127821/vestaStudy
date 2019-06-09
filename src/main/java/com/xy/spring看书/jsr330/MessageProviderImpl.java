package com.xy.spring看书.jsr330;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @fileName:MessageProviderImpl
 * @author:xy
 * @date:2019/6/8
 * @description:
 */
@Named("messageProvider")
public class MessageProviderImpl implements MessageProvider {
    /**
     * @Named  修饰在类上面和spring的@Component注解功能一样
     * @Inject 如果修饰在非类上面则和@AutoWired注解功能一样,按照类型装配，如果要按照名称装配(多了同类型的)
     * 此时需要结合@Named  这样的组合类似@AutoWired@Qualifier
     *
     * 然后@Inject他比@AutoWired强大，他可以修饰在其他非属性上面，修饰在构造方法上面表示使用构造方法注入
     * 而我们知道构造方法注入 不都是无参构造，如果是有参构造就必须结合@Named给形参进行初始化，否则就会报错
     * 但是注意哈经过我的测试它默认会按照类型装配去找形参对应的bean，所以也就是说我们在使用构造的时候就算没有
     * 明显使用@Named指定那个bean，他也会尝试找形参类型的bean！
     * 另外对于形参是我们自定义的还好说，如果是 String这种呢?我们无法使用@Component去修饰String方法，但是可以变通
     * 一下使用 @Bean注解将他放入spring容器即可
     * 然后jsr330还有一个注解就是Singleton 这个不多说就是修饰该类是一个单例，因为jsr330和spring不同它默认是多例
     * 然后jsr330注解就算大概学完了，就这几个重要的
     */
    private String message = "default message";
//    @Inject
//    @Named("message")
    private Message msg;

    private Message msg2;

    public MessageProviderImpl() {
    }

//    @Inject
//    @Named("message")
    public MessageProviderImpl(Message msg2) {
        this.msg2 = msg2;
    }
    @Inject
    public MessageProviderImpl(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Message getMsg() {
        return msg;
    }

    public Message getMsg2() {
        return msg2;
    }
}
