public class RunningTime {

	private long start, end;
	
	public void startStopWatch() {
		start = System.nanoTime();
	}
	
	public void endStopWatch() {
		end = System.nanoTime();
	}
	
	public String totalTime() {
		return "Running time of algorithm is " + (end - start) + " nanoseconds";
	}
	
	public String totalMilliTime() {
		return "Running time of algorithm is " + ((end - start)/1000000) + " milliseconds";
	}
	
}