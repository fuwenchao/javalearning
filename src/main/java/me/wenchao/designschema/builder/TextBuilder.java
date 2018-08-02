package me.wenchao.designschema.builder;

/**
 * @Author wenchaofu
 * @DATE 15:29 2018/6/12
 * @DESC
 */
public class TextBuilder implements Builder {
    @Override
    public void makeTitle(String titile) {
        System.out.println("text Title is " + titile);

    }

    @Override
    public void makeAuth(String author) {
        System.out.println("text Auth is " + author);

    }

    @Override
    public void makeContent(String content) {
        System.out.println("text content is " + content);

    }
}
