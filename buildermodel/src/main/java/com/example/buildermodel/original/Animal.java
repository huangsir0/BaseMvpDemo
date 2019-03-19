package com.example.buildermodel.original;


/***
 * 动物类
 */
public class Animal {

    //年龄
    private  int age;

    //名字
    private  String name;

    //物种
    private  String type;

    //生活区域
    private String lifeArea;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLifeArea(String lifeArea) {
        this.lifeArea = lifeArea;
    }
    @Override
    public String toString() {
        String msg= "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", lifeArea='" + lifeArea + '\'' +
                '}';
        System.out.println(msg);
        return msg;
    }



}
