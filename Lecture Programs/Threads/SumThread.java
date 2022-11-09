package Threads;

class SumThread extends Thread {

    private int start;
    private int end;
    private long sum;

    public SumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        sum = 0;
        for (int i=start; i<=end; i++) {
            sum += i;
        }
    }

    public long getSum() {
        return sum;
    }
}
