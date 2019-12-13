package com.larscheng.www;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 描述:
 *
 * @author zhengql
 * @date 2018/8/8 10:28
 */
public class Book {
    @Id
    private String id;

    private Integer price;

    private String name;

    private String info;

    private String publish;

    private Date createTime;

    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public Book setInfo(String info) {
        this.info = info;
        return this;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }
}
