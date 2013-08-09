package eugene.test;

public class LoopTest {

	public static void main(String[] args) {
		long nBefore = System.nanoTime();
		for(int i=0; i<276480000; i++) {
			System.out.println(i);
		}		
		long nProcessing = System.nanoTime() - nBefore;
		System.out.println("processing time: "+nProcessing*Math.pow(10, -9)+"sec");
	}

}
