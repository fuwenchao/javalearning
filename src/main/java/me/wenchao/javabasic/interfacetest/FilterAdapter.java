package me.wenchao.javabasic.interfacetest;

/**
 * @Author wenchaofu
 * @DATE 15:55 2018/5/28
 * @DESC
 */
public class FilterAdapter implements  Processor {
    Filter filter;

    public FilterAdapter(Filter filter){
        this.filter = filter;
    }
    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object obj) {
        return filter.process((Waveform) obj);
    }
}
