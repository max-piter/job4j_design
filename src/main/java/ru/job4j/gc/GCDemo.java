package ru.job4j.gc;

public class GCDemo {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIROMENT = Runtime.getRuntime();

    public static void info() {
        final long freememory = ENVIROMENT.freeMemory();
        final long totalmemory = ENVIROMENT.totalMemory();
        final long maxmemory = ENVIROMENT.maxMemory();
        long  usedMemory = ENVIROMENT.totalMemory() - ENVIROMENT.freeMemory();
        long totalFreeMem = ENVIROMENT.maxMemory() - usedMemory;

        System.out.println("=====ENVIRIMENT STATE=====");
        System.out.printf("free: %d,%n", freememory / MB);
        System.out.printf("total: %d%n", totalmemory / MB);
        System.out.printf("max: %d%n", maxmemory / MB);
        System.out.printf("used: %d%n", usedMemory / MB);
        System.out.printf("totalFree: %d%n", totalFreeMem / MB);

    }


    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.management.compiler"));


        info();
        for (int i = 0; i < 15000; i++) {
            System.out.println(new User(i, "U" + i));
        }

        /**
         * -Xmx6m -Xms2m
         *  создаём по очереди 10,  1000, 2000, 4000, 10000  объектов User
         *  и высчитываем используемую память usedMemory
         *
         */
        info();

        /**
         *  пытаемся вызвать GC и проверяем состояние памяти после его работы
         *
         */
        System.gc();
        info();
    }

}
