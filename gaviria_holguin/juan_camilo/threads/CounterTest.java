package gaviria_holguin.juan_camilo.threads;

public class CounterTest {
    public static void main(String... args) throws InterruptedException{
        Counter counter = new Counter();
        CounterIncrementer incrementer = new CounterIncrementer(counter);
        CounterDecrementer decrementer = new CounterDecrementer(counter);
        Thread incrementerThread = new Thread(incrementer);
        Thread decrementerThread = new Thread(decrementer);
        incrementerThread.start();
        decrementerThread.start();
        Thread.sleep(5L);
    }
}
