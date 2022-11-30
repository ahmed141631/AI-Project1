public class Time {

        private static long start, end;
        
        public static void startStopWatch() {
            start = System.currentTimeMillis();
        }
        
        public static void endStopWatch() {
            end = System.currentTimeMillis();
        }
        
        public static void totalMilliTime() {
            System.out.println("Running time of algorithm is " + (end - start) + " milliseconds");
        }
        
    }

