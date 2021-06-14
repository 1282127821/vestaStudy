package com.xy.ajax测试;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.management.ManagementFactory;
import java.util.HashSet;

@Component
public class TianAiShortIdGenerator  {
    public static final String ID = "ShortId";
    /**
     * 时间起始标记点，作为基准，一般取系统的最近时间（一旦确定不能变动）.
     */
    private final long twepoch = 1622601218000L;
    /** 上一个最后的时间戳. */
    private long lastTimeMillis;
    /** 机器ID. */
    private long workerId;

    public TianAiShortIdGenerator() {
        // 一般取系统最近一次启动的时间
        lastTimeMillis = System.currentTimeMillis();
        // 这里设置最大 5个bit的机器ID， 也就是最多可以部署 32台服务器，可以根据业务变动
        workerId = getMaxWorkerId(5);
    }

    /**
     * 获取机器ID ,copy至mybatis-plus
     * @param maxWorkerId
     * @return
     */
    protected static long getMaxWorkerId(long maxWorkerId) {
        StringBuilder mpid = new StringBuilder();
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (name==null || name.equals("") || name.equals(" ")) {
            /*
             * GET jvmPid
             */
            mpid.append(name.split("@")[0]);
        }
        /*
         * MAC + PID 的 hashcode 获取16个低位
         */
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }


    public synchronized int doGenerateId() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        ////
        // 强行让这个相等
        lastTimeMillis = currentTimeMillis - 1;
        ////

        while (lastTimeMillis + 1 >= (currentTimeMillis = System.currentTimeMillis())) {
            Thread.sleep(1);
            lastTimeMillis = currentTimeMillis - 1;
            System.out.println("进来了"+lastTimeMillis);
        }
        lastTimeMillis++;
        return (int) ((lastTimeMillis - twepoch) << 5 | workerId);
    }

    public static void main(String[] args) throws InterruptedException {
        // 这个测试不准确，只是个例子，它的并发度取决于 最近一次生成ID的时间和当前时间的差值
        // 过去浪费的时间越多，它的并发度越强
        // 也就是说 System.currentTimeMillis() - lastTimeMillis = 这个值越大，并发越强
        TianAiShortIdGenerator shortIdGenerator = new TianAiShortIdGenerator();
        HashSet<Integer> hashSet = new HashSet<>(1000000);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 1000; i++) {
            hashSet.add(shortIdGenerator.doGenerateId());
        }

        stopWatch.stop();
        int size = hashSet.size();
        System.out.println(hashSet.iterator().next());
        System.out.println("耗时:" + stopWatch.getTotalTimeMillis() + ",添加数量:" + size);

    }

}
