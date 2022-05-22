import java.util.Scanner;

class QuickStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try 
        {
        System.out.print("Please enter a number for the Collatz sequence: ");
        int num = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Please enter the number of threads to use: ");
        int threads = Integer.parseInt(scanner.nextLine().trim());

            for (int x=0; x < threads; x++)
            {
                Collatz collatz = new Collatz(num);
                collatz.start();
            //may be unnnecessary
            //System.out.println("Started Thread:" + num);
            }
        }    
        finally 
        {
            scanner.close();
        }
        //call threads here
        
    }

    public static class Collatz extends Thread {
        private int num;

        public Collatz(int n) {
            num = n;
        }

        public void run() {
            do
            {
                if (num%2 != 0)
                {
                    num = (num*3) + 1;
                } 
                else 
                {
                    num = num / 2;
                }
                System.out.println(num);
            }
            while (num != 1);
        }

    }
}