package me.wenchao.javabasic.interfacetest;

/**
 * @Author wenchaofu
 * @DATE 15:49 2018/5/28
 * @DESC
 */
public class Waveform {
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return "waveform " + id;
    }

}

class Filter{
    public String name(){
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input ){
        return input;
    }

}

class LowPass extends Filter{
    double cutoff;
    public LowPass(double cutoff){
        this.cutoff = cutoff;
    }
    public Waveform process(Waveform input){
        return input;
    }
}

class HighPass extends Filter{
    double cutoff;
    public HighPass(double cutoff){
        this.cutoff = cutoff;
    }
    public Waveform process(Waveform input){
        return input;
    }
}
