package com.lzr.apigatewaydynamicfilter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author linzerong
 * @create 2019-06-24 11:05
 */
@ConfigurationProperties("zuul.filter")
public class FilterConfiguration {

    private String root;
    private Integer interval;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }
}
