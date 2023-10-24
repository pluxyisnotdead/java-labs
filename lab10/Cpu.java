package lab10;

public class Cpu {
    private final int processingTime;

    public Cpu(int processingTime) {
        this.processingTime = processingTime;
    }

    public void process(CpuProcess process) throws InterruptedException {
        System.out.println("Processing process...");
        Thread.sleep(processingTime * 1000L);
        System.out.println("Process complete!\n");
    }
}