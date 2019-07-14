package com.xy.hotPlugin;

import java.io.Serializable;

/**
 * @fileName:PluginConfig
 * @author:xy
 * @date:2019/7/13
 * @description: 插件信息封装类
 */
public class PluginConfig implements Serializable {
    /** 唯一id*/
    private int id;
    /** 版本*/
    private String version;
    /** 远程jar url*/
    private String jarRemoteUrl;
    /** 全类名*/
    private String className;
    /** 作用*/
    private String name;
    /** 是否激活*/
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getJarRemoteUrl() {
        return jarRemoteUrl;
    }

    public void setJarRemoteUrl(String jarRemoteUrl) {
        this.jarRemoteUrl = jarRemoteUrl;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
