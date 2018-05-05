package me.wenchao.javapro.reflection;

/**
 * @Author wenchaofu
 * @DATE 17:02 2018/4/30
 * @DESC
 */
public class StaticLoad {
    public static void main(String[] args) {
        if("word".equals(args[0])){
            Word word = new Word();
            word.dosomething();
        }else if("excel".equals(args[0])){
            Excel excel = new Excel();
            excel.dosomething();
        }
    }
}
