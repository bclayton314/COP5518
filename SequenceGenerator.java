public class SequenceGenerator {

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
            /* thread.start();
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            } */
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
                    //if (counter % Threads == remainder && 
                            //counter <= Collatz_Range) 
                    for (int j = 1; j <= Collatz_Range; j++)
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
                            System.out.println(Collatz_Range);
                        }
                        while (Collatz_Range != 1);

                    }
                    counter++;
                    lock.notifyAll();
                }

            }

        }

    }

}
