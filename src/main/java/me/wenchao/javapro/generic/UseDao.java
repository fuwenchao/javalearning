package me.wenchao.javapro.generic;

/**
 * @Author wenchaofu
 * @DATE 18:14 2018/5/9
 * @DESC
 */
public class UseDao extends Dao<Integer> {
/*    public UseDao(){
        super();
    }*/

    public static void main(String[] args) {
        UseDao ud = new UseDao();
        System.out.println(ud.clazz);
    }
}
