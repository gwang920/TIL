package ws;

public class Test01 {

	public static void main(String[] args) {
	      int i=0,j=0;
	      while(i<11) {
	    	  
	    	  i++;
	    	  while(j<i) {
	    		  System.out.print("*");
	    		  j++;
	    	  }
	    	  j=0;
		      System.out.println();
	      }
    }

}
