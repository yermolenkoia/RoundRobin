package sample;


import java.util.concurrent.Semaphore;

public class Main{


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        int quant = 2;
        int execution1 = 7;
        int execution2 = 12;
        int execution3 = 15;
        int execution4 = 8;
        int execution5 = 20;
        double avgTime;
        avgTime = (execution1 + execution2 + execution3 + execution4 + execution5)/5;
        System.out.println("Avg. time ~ " + avgTime);
        System.out.println("Process number||Start||Execution||End||Delay");
        new Thread(new Process(1, semaphore, execution1, quant)).start();
        new Thread(new Process(2, semaphore, execution2, quant)).start();
        new Thread(new Process(3, semaphore, execution3, quant)).start();
        new Thread(new Process(4, semaphore, execution4, quant)).start();
        new Thread(new Process(5, semaphore, execution5, quant)).start();
    }
}
