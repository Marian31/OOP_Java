public class Fibonacci
{
	public long getNumber(int position){
		if(position<1)
			return -1L;
		else if(position == 2 | position == 1)
			return 1L;
		else 
			return getNumber(position-1)+(getNumber(position-2));
		//PUT YOUR CODE HERE
		//PUT YOUR CODE HERE
	}
}
        