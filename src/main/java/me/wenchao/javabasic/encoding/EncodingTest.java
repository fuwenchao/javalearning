package me.wenchao.javabasic.encoding;

import com.google.common.base.Charsets;
import org.omg.IOP.Encoding;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Author wenchaofu
 * @DATE 18:06 2018/6/29
 * @DESC
 */
public class EncodingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "付文超";
        byte[] b = str.getBytes("UTF-8");
        int[] arr = {5,1, 2, 3, 3};
//        List list = Arrays.asList(arr);
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        List list1 = new ArrayList(list);

        LinkedList<Integer> link = new LinkedList<>();
        link.add(1);
        link.add(2);
        link.subList(0, link.size());
        List list2 = list.subList(0, list.size());
        list2.add(7);
        System.out.println("list equals list1 " + list.equals(list1));
        System.out.println("list equals list2 " + list.equals(list2));

        for (int i = 0; i < list.size(); i++) {
            System.out.println("list[" + i + "]" + list.get(i));
        }


        int[] clone = arr.clone();
        Arrays.sort(clone);
        System.out.println("clone arr is " + Arrays.toString(clone));
        System.out.println("arr is " + Arrays.toString(arr));
        System.out.println(arr[arr.length-1]);
        b.clone();
        System.out.println(new String(b));

    }
}
