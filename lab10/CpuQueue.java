package lab10;

import java.util.LinkedList;

public class CpuQueue {
    private final LinkedList<CpuProcess> queue;
    private final int maxSize;

    public CpuQueue(int maxSize) {
        this.queue = new LinkedList<CpuProcess>();
        this.maxSize = maxSize;
    }

    public void insert(CpuProcess process) {
        if (queue.size() < maxSize) {
            queue.add(process);
        }
    }

    public CpuProcess remove() {
        if (!queue.isEmpty()) {
            return queue.remove();
        }
        return null;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}