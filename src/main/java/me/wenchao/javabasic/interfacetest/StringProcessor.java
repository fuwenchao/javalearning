package me.wenchao.javabasic.interfacetest;

import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 15:31 2018/5/28
 * @DESC
 */
public abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public abstract String process(Object obj);
    public static final String s = "This is Wenchao Fu";

    public static void main(String[] args) {
        Apply.process(new Upcase(),s);
        Apply.process(new Lowcase(),s);
        Apply.process(new Splitter(),s);

    }
}
class Upcase extends StringProcessor{

    @Override
    public String process(Object obj) {
        return ((String)obj).toLowerCase();
    }
}
class Lowcase extends StringProcessor{

    @Override
    public String process(Object obj) {
        return ((String)obj).toLowerCase();
    }
}
class Splitter extends StringProcessor{

    @Override
    public String process(Object obj) {
        return Arrays.toString(((String)obj).split(" "));
    }
}