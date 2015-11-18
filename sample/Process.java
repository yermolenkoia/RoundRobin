package sample;

import java.util.concurrent.Semaphore;

/**
 * Created by igor on 14.10.15.
 */
public class Process implements Runnable {
    private int startTime = 0;
    private int executionTime = 0;
    private int endTime = 0;
    private int delayTime = 0;
    private int executionTimeLeft = 0;
    private int quant;
    private int number;
    private boolean flag = true;
    private Semaphore semaphore;
    public void run() {
        try{
            while (executionTimeLeft > 0) {
                semaphore.acquire();
                if (flag){
                    this.startTime = TIme.time;
                    flag = false;
                }
                if (executionTimeLeft > quant){
                    Thread.sleep(quant*100L);
                    TIme.time += quant;
                    executionTimeLeft -= quant;
                }else{
                    Thread.sleep(executionTimeLeft*100L);
                    TIme.time += executionTimeLeft;
                    executionTimeLeft = 0;
                    endTime = TIme.time;
                }
                semaphore.release();
                Thread.sleep(30L);
            }
        }catch (Exception e){
            e.printStackTrace(System.err);
        }
        delayTime = endTime - startTime - executionTime;
        System.out.println("        " + number + "         " + startTime + "       " + executionTime + "       " + endTime + "     " + delayTime);
    }

    Process(int number, Semaphore semaphore, int executionTime, int quant){
        this.quant = quant;
        this.semaphore = semaphore;
        this.executionTime = executionTime;
        this.executionTimeLeft = executionTime;
        this.number = number;
    }
}
