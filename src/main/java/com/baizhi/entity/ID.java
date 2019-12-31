package com.baizhi.entity;

/**
 * @ClassName ID
 * @Discription
 * @Author
 * @Date2019/11/13 23:14
 */
public class ID {
    private String id;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID{" +
                "id='" + id + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }
}
