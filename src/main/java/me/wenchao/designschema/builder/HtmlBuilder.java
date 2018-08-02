package me.wenchao.designschema.builder;

/**
 * @Author wenchaofu
 * @DATE 15:29 2018/6/12
 * @DESC
 */
public class HtmlBuilder implements Builder {
    @Override
    public void makeTitle(String titile) {
        System.out.println("html title is " + titile);

    }

    @Override
    public void makeAuth(String author) {
        System.out.println("html author is " + author );

    }

    @Override
    public void makeContent(String content) {
        System.out.println("html content is " + content);

    }
}
