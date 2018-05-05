package me.wenchao.designschema.proxy.cglibproxy;

/**
 * @Author wenchaofu
 * @DATE 10:18 2018/5/2
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Train t = (Train) cglibProxy.getProxy(Train.class);
        t.move();

        CglibProxy cglibProxy1 = new CglibProxy();
        SubTrain st = (SubTrain)cglibProxy1.getProxy(Train.class);
        st.stop();
    }
}
