package me.wenchao.designschema.builder;

/**
 * @Author wenchaofu
 * @DATE 15:30 2018/6/12
 * @DESC
 */
public class Director  {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.makeTitle("Title");
        builder.makeAuth("wenchaofu");
        builder.makeContent("这是内容");
    }
}
