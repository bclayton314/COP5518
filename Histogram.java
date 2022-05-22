/* package foo;
import java.util.Vector;

public class ThreadTest {
private Vector<String> threadNames = new Vector<String>();
public static void main(String[] args) {
    ThreadTest test = new ThreadTest();
    test.threadTest(Integer.parseInt(args[0]));
    System.out.println(test.threadNames);
}
private void threadTest(int numOfThreads) {
    Thread[] threads = new Thread[numOfThreads];
    for (int i = 0; i < threads.length; i++) {
        threads[i] = new foo.ThreadTest.MyThread();
        threads[i].start();
    }
    for (int i = 0; i < threads.length; i++) {
        try {
        threads[i].join();
        } catch (InterruptedException ignore) {}
    }
}
class MyThread extends Thread {
 public void run() {
     for (int i = 0; i < 1000000; i++) {
         i = i + 0;
     }
     threadNames.add(getName());
 }
}
} */





/* for (int j = 2; j <= Collatz_Range; j++)
{
    do
    {
        if (j % 2 != 0)
        {
            j = (j * 3) + 1;
        } 
        else 
        {
            j = j / 2;
        }
        System.out.print(Thread.currentThread().getName() 
        + "-" + counter + "\t");
        counter++;
        System.out.println(j);
    }
    while (Collatz_Range != 1);
} */


/* public class test {
    
} */


import javax.swing.*;

public class Histogram
     {
     public static void main( String args[] )
         {
         int n[] = { 19, 3, 15, 7, 11, 9, 13, 5, 17, 1 };
         String output = "";
        
         output += "Element\tValue\tHistogram";
        
         for ( int i = 0; i < n.length; i++ )
             {
             output += "\n" + i + "\t" + n[ i ] + "\t";
            
             for ( int j = 1; j <= n[ i ]; j++ ) // print a bar
             output += "*";
         }
        
         JTextArea outputArea = new JTextArea( 11, 30 );
         outputArea.setText( output );
        
         JOptionPane.showMessageDialog( null, outputArea,"Histogram Printing Program",JOptionPane.INFORMATION_MESSAGE );
        
         System.exit( 0 );
     }
}


/**
 * This program uses multi-threading to produce a list of Collatz sequences. The first argument defines
 * the range of numbers for which a Collatz sequence must be computed. The second argument is the number
 * of threads that the program will create to compute the Collatz sequences in parallel.
 * 
 * @author Clayton Baker
 * @date 7/18/2021
 * @info Course COP5518
 */

/* import java.util.concurrent.locks.ReentrantLock;
import java.lang.Thread;
import java.time.Instant;

public class CollatzSequence2 {
    public static int Collatz_Range;
    public static int NumOfThreads;
    public static int COUNTER = 2;
    public static int[] HISTOGRAM = new int[1000];

    public static void main(String[] args) {
        
        //variables for calculating start time
        long startTimeMilli = Instant.now().toEpochMilli();
        long startTimeNano = System.nanoTime();

        //used to accept arguments from the command line
        if (args.length > 0) {
            try {
                Collatz_Range = Integer.parseInt(args[0]);
                NumOfThreads = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Must declare a range of numbers and number of threads to use.");
                System.exit(1);
            }
        }
        
        //Instance of class and calling function
        CollatzSequence2 collatzSequence2 = new CollatzSequence2();
        collatzSequence2.threadTest(NumOfThreads);
        
        //Variables for calculating end time
        long endTimeMilli = Instant.now().toEpochMilli();
        long endTimeNano = System.nanoTime();

        //Calculations to get elapsed time and proper format of time
        long timeElapsedMilli = endTimeMilli - startTimeMilli;  //milliseconds
        long timeElapsedNano = endTimeNano - startTimeNano;
        String timeElapsedSecond = String.format("%.9f", (double)timeElapsedNano / 1000000000);

        //Begin directing output of CSV data to an excel file with stderr
        System.err.println("Ticks, Frequency");
        for(int i = 0; i < HISTOGRAM.length; i++)
        {

            System.err.println(i + ", " + HISTOGRAM[i]);
        
        }
        System.err.println("Elapsed time in milliseconds: " + timeElapsedMilli);

        //Output of final results to terminal using stdout
        System.out.println(Collatz_Range + ", " + NumOfThreads + ", " + timeElapsedSecond + " sec");
    }
    
    /**
     * Creates, starts, and joins multiple threads
     *
     * @param NumOfThreads # of threads to be created
     *
     * @return no values are returned from this function
     */
    
    /* private void threadTest(int NumOfThreads) 
    {
        //Creating threads
        Thread threads = new Thread();
        for (int i = 0; i <= NumOfThreads - 1; i++) 
        {
            threads = new CollatzSequence2.Collatz();
            threads.start();
        }

        for (int i = 0; i <= NumOfThreads - 1; i++) 
        {  
            try {
                    threads.join();
                } 
            catch (Exception e) 
                {
                    e.printStackTrace();
                }
        }
    }

    //Collatz class that utilizes Thread to calculate the Collatz Sequence
    class Collatz extends Thread {
        private ReentrantLock _lock = new ReentrantLock();
        private int collatzTicks = 0;

        @Override
        public void run() 
        {
            int numberToCompute;
            do{
                
                while (true)
                {
                    /* 
                    *First MUTEX lock to keep shared variable COUNTER locked while 
                    *individual threads access/modify the variable 
                    */
                   /* try 
                    {
                        _lock.lock();
                        numberToCompute = COUNTER;
                        COUNTER++;

                        if (numberToCompute > 1 && numberToCompute <= Collatz_Range)
                        {
                            break;
                        }
                    }
                    finally { _lock.unlock();}
                }

                //Calculations for the Collatz Sequence
                do {    
                    if (numberToCompute % 2 != 0)
                    {
                        numberToCompute = (numberToCompute * 3) + 1;
                    }
                    else
                    {
                        numberToCompute = numberToCompute / 2;
                    }
                    collatzTicks++;
                    
                } while (numberToCompute != 1);

                int result = collatzTicks;
                collatzTicks = 0;
                
                /* 
                *Second MUTEX lock to keep shared variable HISTOGRAM locked while 
                *individual threads access/modify the variable 
                */
                /*try {
                    _lock.lock();
                    HISTOGRAM[result - 1] += 1;
                }
                finally { _lock.unlock();}

            } while (COUNTER <= Collatz_Range);

        }
    }
} */