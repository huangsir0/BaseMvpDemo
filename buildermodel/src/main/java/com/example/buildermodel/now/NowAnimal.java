package com.example.buildermodel.now;

public class NowAnimal {
    //年龄
    private final int age;

    //名字
    private final String name;

    //物种
    private  String type;

    //生活区域
    private String lifeArea;

    @Override
    public String toString() {
        String msg= "NowAnimal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", lifeArea='" + lifeArea + '\'' +
                '}';
        System.out.println(msg);
        return msg;
    }

    /**
     * 构造
     * @param builder
     */
    public NowAnimal(AnimalBuilder builder){
        this.age= builder.age;
        this.lifeArea=builder.lifeArea;
        this.name=builder.name;
        this.type=builder.type;
    }


    public  static  class AnimalBuilder{

        //年龄
        private final int age;

        //名字
        private final String name;

        //物种
        private  String type;

        //生活区域
        private String lifeArea;



        public AnimalBuilder(int age,String name){
            this.age=age;
            this.name=name;
        }


        /**
         * 种类
         * @param type
         * @return
         */
        public  AnimalBuilder setType(String type){
            this.type=type;
            return  this;
        }

        /**
         * 生活区域
         * @param area
         * @return
         */
        public  AnimalBuilder setLifeArea(String area){
            this.lifeArea=area;
            return  this;
        }

        /**
         * 构建
         * @return
         */
        public NowAnimal build(){
            return  new NowAnimal(this);
        }



    }
}
