package com.example.buildermodel.original;

public interface AnimalBuilder {

    void setAge();

    void setName();

    void setType();

    void setLifeArea();

    Animal build();
}
