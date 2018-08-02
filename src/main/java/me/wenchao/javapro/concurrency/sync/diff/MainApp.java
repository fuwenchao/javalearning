package me.wenchao.javapro.concurrency.sync.diff;

import me.wenchao.tool.ThreadUtils;

/**
 * @Author wenchaofu
 * @DATE 16:15 2018/7/11
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) throws IllegalAccessException, InterruptedException, InstantiationException {
        ThreadUtils.RunTasks(TaskWithLock.class);
        ThreadUtils.RunTasks(TaskWithSync.class);


    }
}
