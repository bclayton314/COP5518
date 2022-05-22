public class SequenceGenerator1 {

    private static final Object lock = new Object();
    private static int Threads = 5;
    private static int Collatz_Range = 10;
    private static int counter = 1;

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                Collatz_Range = Integer.parseInt(args[1]);
                Threads = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Must declare a range of numbers and number of threads to use.");
                System.exit(1);
            }
        }
        // Creating threads

        for (int i = 1; i <= Threads; i++) {
            new Thread(new Collatz(i % Threads), "T" + i).start();
        }

    }

    static class Collatz implements Runnable {

        private int remainder;

        Collatz(int remainder) {
            this.remainder = remainder;
        }

        @Override
        public void run() {
            while (counter <= Collatz_Range) {
                synchronized (lock) {
                    while (counter % Threads != remainder) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (counter % Threads == remainder && 
                            counter <= Collatz_Range) 
                        {

                            
                            System.out.print(Thread.currentThread().getName() 
                            + "-" + counter + "\t");
                            //START SIMPLE FIRST, KEEP CALCULATIONS IN 1 THREAD FIRST AND THEN MOVE UP TO MORE COMPLEX COLLATZ
                            //GO BACK THROUGH VIDEOS?
                            /* if (counter != 1)
                            {
                                if (counter % 2 == 0)
                                {
                                    counter = counter + 2;
                                }
                                else
                                {
                                    counter = (counter*3) + 1;
                                }
                            } */
                            System.out.println(counter);
                        }
                    counter++;
                    lock.notifyAll();
                }

            }

        }

    }

}


