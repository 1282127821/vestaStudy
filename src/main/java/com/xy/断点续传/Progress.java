package com.xy.断点续传;

import java.io.Serializable;

/**
 * @fileName:Progress
 * @author:xy
 * @date:2020/4/7
 * @description:
 */
public class Progress implements Serializable {
    private int progress;
    private int total;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "progress=" + progress +
                ", total=" + total +
                '}';
    }
}
