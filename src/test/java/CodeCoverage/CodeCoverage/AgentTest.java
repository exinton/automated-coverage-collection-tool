package CodeCoverage.CodeCoverage;

import org.junit.Test;

public class AgentTest {
	
	   @Test
	    public void testAgent() throws InterruptedException {
		     Sleeping sleeping = new Sleeping();
		        sleeping.randomSleep();
	        
	    }
}
