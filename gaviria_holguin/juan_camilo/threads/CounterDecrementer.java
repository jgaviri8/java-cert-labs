package gaviria_holguin.juan_camilo.threads;

public class CounterDecrementer implements Runnable{

    private Counter counter;

    CounterDecrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        byte times = 0b101;
        while(times > 0) {
            System.out.format("Counter value before decrement: %d%n", counter.getCount());
            counter.decrement();
            System.out.format("Counter value after decrement: %d%n", counter.getCount());
            times--;
        }
    }
}
