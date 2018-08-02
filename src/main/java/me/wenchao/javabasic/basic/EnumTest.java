package me.wenchao.javabasic.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 17:36 2018/7/9
 * @DESC
 */
public class EnumTest {
    enum Season{
        SPRING("春"),
        SUMMER("夏"),
        AUTUMN("秋"),
        WINTER("冬");

        Season(String desc){
            this.desc = desc;
        }

        private String desc;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public static void main(String[] args) {
        List<String> seasons = new ArrayList<>();
        seasons.add("SPRING");
//        seasons.add("SUMM");

        for (String season : seasons) {
            Season season1 = Season.valueOf(season);
            if (season != null) {
                System.out.println(season1);
            } else {
                System.out.println("no " + season);
            }
        }

        for (Season season : Season.values()) {
            System.out.println(season.getDesc() + "  " + season.ordinal() + " " + season.name());
        }
    }
}
