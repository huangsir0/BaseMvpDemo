package com.example.buildermodel.original;

/**
 * 小狗的构建模式
 */
public class DogAnimalBuilder implements AnimalBuilder {

    private Animal animal=new Animal();

    @Override
    public void setAge() {
        animal.setAge(6);
    }

    @Override
    public void setName() {
        animal.setName("花花");
    }

    @Override
    public void setType() {
        animal.setType("动物");
    }

    @Override
    public void setLifeArea() {
        animal.setLifeArea("陆地");
    }

    @Override
    public Animal build() {
        return animal;
    }
}
