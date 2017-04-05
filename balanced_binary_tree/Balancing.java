public class Balancing extends Thread {
    @Override public void run() {
        try {
            sleep(1500 + Thread.currentThread().getId() * 110);
        } catch(InterruptedException e) {}
        System.out.println("Hi from Thread " + Thread.currentThread().getId());
    }
}