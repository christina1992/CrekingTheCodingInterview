package Chapter15.ThreadsAndLocks;

/**
 * Created by hnastevska on 7/17/2017.
 */
public class FizzBuzzThread extends Thread {
    protected static int current = 1;
    private static Object lock = new Object();
    private int max;
    private boolean div3, div5;
    private String toPrint;

    public FizzBuzzThread(boolean div3,boolean div5, int max, String toPrint){
        this.div3=div3;
        this.div5=div5;
        this.max=max;
        this.toPrint=toPrint;
    }
    public void print(){
        System.out.println(toPrint);
    }

    public void  run(){
        while (true){
            synchronized (lock){
                if (current > max){
                    return;
                }
                if ((current % 3 == 0) == div3 && (current % 5 == 0) == div5){
                    print();
                    current++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = {
                new FizzBuzzThread(true,true,15,"FizzBuzz"),
                new FizzBuzzThread(true,false,15,"Fizz"),
                new FizzBuzzThread(false,true,15,"Buzz"),
                new NumberThread(false,false,15)};
        for (Thread thread : threads){
            thread.start();
        }
    }
}
