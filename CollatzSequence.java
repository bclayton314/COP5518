//import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.Thread;


public class CollatzSequence {

    private static int NumOfThreads = 8;
    private static int Collatz_Range = 20;
    private static int counter = 1;


    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                Collatz_Range = Integer.parseInt(args[1]);
                NumOfThreads = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Must declare a range of numbers and number of threads to use.");
                System.exit(1);
            }
        }
        // Creating threads
        //OVERARCHING FOR LOOP FOR COLLATZ?
        //MULTIPLE THREADS ARE NOT BEING CREATED OR THEY'RE NOT BEING USED ONCE CREATED
        //Collatz collatz = new Collatz(Threads);
        Thread[] threads = new Thread[NumOfThreads];
        for (int i = 0; i <= threads.length; i++) {
            threads[i] = new CollatzSequence.Collatz();
            threads[i].start();

        }

        for (int i = 0; i <= threads.length; i++) {
                
            try {
                    threads[i].join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


    }
    
    static class Collatz extends Thread {
        //private int _x;
        private ReentrantLock _lock = new ReentrantLock();

        /* public Collatz(int x) {
            this._x = x;
        } */

        @Override
        public void run() {
           _lock.lock();
            try {
                for (int j = 2; j <= Collatz_Range; j++)
                {
                    do
                    {
                        if (Collatz_Range % 2 != 0)
                        {
                            Collatz_Range = (Collatz_Range * 3) + 1;
                        } 
                        else 
                        {
                            Collatz_Range = Collatz_Range / 2;
                        }
                        System.out.print(Thread.currentThread().getName() 
                        + "-" + counter + "\t");
                        counter++;
                        System.out.println(Collatz_Range);
                    }
                    while (Collatz_Range != 1);
                }

            } finally { _lock.unlock();}
        }
    }
}
