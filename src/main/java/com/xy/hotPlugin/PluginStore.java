package com.xy.hotPlugin;

import org.springframework.web.servlet.mvc.LastModified;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @fileName:PluginStore
 * @author:xy
 * @date:2019/7/14
 * @description:
 */
public class PluginStore implements Serializable {
    /** 最后修改时间*/
    private Date lastModify;
    /** 插件*/
    private Collection<PluginConfig> plugin;

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

    public Collection<PluginConfig> getPlugin() {
        return plugin;
    }

    public void setPlugin(Collection<PluginConfig> plugin) {
        this.plugin = plugin;
    }
}
