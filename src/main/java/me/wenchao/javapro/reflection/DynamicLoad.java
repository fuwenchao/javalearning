package me.wenchao.javapro.reflection;

/**
 * @Author wenchaofu
 * @DATE 17:09 2018/4/30
 * @DESC
 */
public class DynamicLoad {
    public static void main(String[] args) {
        String s = "334";
        ClassUtil.printObjectMessage(s);
        try{
            //动态加载类，在运行时刻加载类
            if(args.length>0) {
                Class c = Class.forName(args[0]);
                //通过类类型，创建该类对象,但是这里我又不知道传进来的是哪个对象，所有不能像下面这种方法用
                //Excel excel =(Excel)c.newInstance();
                //统一标准
                OfficeAble oa = (OfficeAble) c.newInstance();
                oa.dosomething();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
