package com.example.buildermodel.original;

public class BuilderDirector {

    public  BuilderDirector(){}


    /**
     *
     * @param builder
     * @return
     */
    public Animal apply(AnimalBuilder builder){
        builder.setAge();
        builder.setLifeArea();
        builder.setName();
        builder.setType();
        return builder.build();
    }
}
