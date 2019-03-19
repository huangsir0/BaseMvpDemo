package com.example.buildermodel;

import com.example.buildermodel.now.NowAnimal;
import com.example.buildermodel.original.Animal;
import com.example.buildermodel.original.BuilderDirector;
import com.example.buildermodel.original.DogAnimalBuilder;
import com.example.buildermodel.original.FishAnimalBuilder;

public class Main {


    public static void main(String[] args) {

        BuilderDirector director=new BuilderDirector();
        //小狗
        Animal dog =director.apply(new DogAnimalBuilder());
        dog.toString();
        //小鱼
        Animal fish=director.apply(new FishAnimalBuilder());
        fish.toString();

        System.out.println("======================================华丽的分割线======================================");

        new  NowAnimal.AnimalBuilder(17,"小王")
                      .setType("动物")
                      .setLifeArea("海里")
                      .build()
                      .toString();

        new  NowAnimal.AnimalBuilder(17,"小草")
                      .setType("植物")
                      .setLifeArea("森林")
                      .build()
                      .toString();
    }

}
