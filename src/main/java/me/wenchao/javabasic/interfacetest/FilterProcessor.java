package me.wenchao.javabasic.interfacetest;

/**
 * @Author wenchaofu
 * @DATE 15:58 2018/5/28
 * @DESC
 */
public class FilterProcessor {
    public static void main(String[] args) {
        Waveform waveform = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),waveform);
    }
}
