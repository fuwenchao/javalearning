package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 15:27 2018/9/2
 * @DESC
 */
public enum Sum {

    PLUS {
        @Override
        double apply(double  x, double y) {
            return 0;
        }
    },
    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return 0;
        }
    },
    TIMES {
        @Override
        double apply(double x, double y) {
            return 0;
        }
    },
    DIV {
        @Override
        double apply(double x, double y) {
            return 0;
        }
    };

    private String desc;



    Sum(String s) {
        this.desc = s;
    }

    Sum() {

    }

    abstract double apply(double x, double y);

}
