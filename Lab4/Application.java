public class Application{
	public static void main( String[] args ) {
        	String inline = args[0];
        	int len = inline.length();
        	String outline = "";

        	if( len > 0 &&  inline != null ){
            		for (int i = 0; i < len - 1; i++){
               			int times = 1;
                		outline += inline.charAt(i);
                    		while(inline.charAt(i)==inline.charAt(i+1)) {
                        		times++;
                        		if(i == len - 2){
                            			break;
                        		}
                        		i++;
                        		if(times == 9){
                           			break;
                        		}
                    		}
                		if(times !=1){
                    			outline += times;
                		}
                	}
            		if(inline.charAt(len-2) != inline.charAt(len-1)){
                		outline+=inline.charAt(len-1);
            		}
        	}
        	System.out.println(outline);
    	}
}