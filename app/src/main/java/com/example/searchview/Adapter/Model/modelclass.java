package com.example.searchview.Adapter.Model;

import java.io.Serializable;

public class modelclass implements Serializable
{
    String name;

    public modelclass(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
