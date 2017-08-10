package gaviria_holguin.juan_camilo.threads;

public class CounterIncrementer implements Runnable {

    private Counter counter;

    CounterIncrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        byte times = 0b101;
        while(times > 0) {
            System.out.format("Counter value before increment: %d%n", counter.getCount());
            counter.increment();
            System.out.format("Counter value after increment: %d%n", counter.getCount());
            times--;
        }
    }
}
