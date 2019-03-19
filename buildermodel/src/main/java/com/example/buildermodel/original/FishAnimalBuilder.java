package com.example.buildermodel.original;

/**
 * 小鱼构建者
 */
public class FishAnimalBuilder implements AnimalBuilder {

    private Animal fish=new Animal();

    @Override
    public void setAge() {
        fish.setAge(2);
    }

    @Override
    public void setName() {
        fish.setName("小鲤鱼");
    }

    @Override
    public void setType() {
        fish.setType("动物");
    }

    @Override
    public void setLifeArea() {
        fish.setLifeArea("水里");
    }

    @Override
    public Animal build() {
        return fish;
    }
}
