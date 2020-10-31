package cn.whu.test;

public class Bird implements Flyable {
    @Override
    public void fly() {
        long start = System.nanoTime();
        System.out.println("Bird is flying...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("[inner] Fly time = " + (end - start));
    }
}
