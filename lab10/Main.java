package lab10;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numProcesses = 1;
        int minInterval = 1;
        int maxInterval = 5;
        int queueSize = 5;
        int processingTime = 2;

        CpuQueue queue = new CpuQueue(queueSize);
        for (int i = 0; i < numProcesses; i++) {
            int interval = (int) (Math.random() * (maxInterval - minInterval + 1) + minInterval);
            CpuProcess process = new CpuProcess(interval);
            queue.insert(process);
        }

        Cpu cpu = new Cpu(processingTime);

        int maxBuffers = 0;
        int totalBuffers = 0;

        while (!queue.isEmpty()) {
            int buffers = 0;

            while (!queue.isEmpty() && buffers < queueSize) {
                CpuProcess process = queue.remove();
                cpu.process(process);
                buffers++;
            }

            totalBuffers += buffers;
            if (buffers > maxBuffers) {
                maxBuffers = buffers;
            }
        }

        System.out.println("Max buffers: " + maxBuffers);
        System.out.println("Average buffers: " + ((double) totalBuffers / numProcesses));
    }
}
