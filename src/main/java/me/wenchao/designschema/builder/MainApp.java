package me.wenchao.designschema.builder;


/**
 * @Author wenchaofu
 * @DATE 15:30 2018/6/12
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            usage();
            System.exit(0);
        }
        try {
            Class<?> aClass = Class.forName(args[0]);
            Builder builder = (Builder) aClass.newInstance();
            Director director = new Director(builder);
            director.construct();
            System.out.println("**** over *****");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void usage() {
        System.out.println("Usage java MainApp TextBuilder/HtmlBuilder");
    }
}
