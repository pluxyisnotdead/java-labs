package lab10;

import java.util.Random;

public class CpuProcess {
    private final int interval;

    public CpuProcess(int interval) {
        this.interval = interval;
    }

    public void generate() throws InterruptedException {
        Random random = new Random();
        while (true) {
            System.out.println("Generating new process...");
            Thread.sleep(interval * 1000L);
        }
    }
}