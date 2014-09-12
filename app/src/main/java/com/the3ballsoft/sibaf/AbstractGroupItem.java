package com.the3ballsoft.sibaf;

public class AbstractGroupItem {
    private String name;
    private String group;

    public AbstractGroupItem(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
