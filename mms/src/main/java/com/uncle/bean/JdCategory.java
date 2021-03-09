package com.uncle.bean;

import java.io.Serializable;

/**
* @Description: 描述产品类型的类
* @Author: 步尔斯特
* @Date: 2021/3/6
*/
public class JdCategory  implements Serializable {
    @Override
    public String toString() {
        return "JdCategory{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                ", turn=" + turn +
                ", description='" + description + '\'' +
                ", parent_id=" + parent_id +
                '}';
    }

    public JdCategory(int category_id, String name, int turn, String description, int parent_id) {
        this.category_id = category_id;
        this.name = name;
        this.turn = turn;
        this.description = description;
        this.parent_id = parent_id;
    }

    public JdCategory() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    private int category_id;
    private String name;
    private int turn;
    private String description;
    private int parent_id;
}
