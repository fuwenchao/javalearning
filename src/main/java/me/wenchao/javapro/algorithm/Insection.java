package me.wenchao.javapro.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @Author wenchaofu
 * @DATE 16:35 2018/7/5
 * @DESC
 */
@Data
@AllArgsConstructor
class Entry {
    private int minValue;
    private int maxValue;
}

public class Insection {

    public static void main(String[] args) {
        List<Entry> list1 = new ArrayList<>();
        List<Entry> list2 = new ArrayList<>();
        list1.add(new Entry(4, 8));
        list1.add(new Entry(9, 13));
        list2.add(new Entry(6, 12));

        List<Entry> list3 = getInsection(list1, list2);
        for (int i = 0; i < list3.size(); i++) {
            System.out.println("[" + list3.get(i).getMinValue() + "," + list3.get(i).getMaxValue() + "]");
        }

    }

    private static List<Entry> getInsection(List<Entry> list1, List<Entry> list2) {
        List<Entry> list = new ArrayList<>();
        for (int i = 0, size = list1.size(); i < size; i++) {
            for (int j = 0, size2 = list2.size(); j < size2; j++) {
                Entry reuslt = getInsection(list1.get(i), list2.get(j));
                if (reuslt != null)
                    list.add(reuslt);
            }
        }
        return list;

    }

    private static Entry getInsection(Entry s1, Entry s2) {
        if (s2.getMinValue() > s1.getMaxValue()) {
            return null;
        }
        if (s2.getMaxValue() < s1.getMinValue()) {
            return null;
        }
        return new Entry(max(s1.getMinValue(), s2.getMinValue()), min(s1.getMaxValue(), s2.getMaxValue()));
    }


}
