
public class NumberMult {
	
	public static int multiply(int x, int y) {
		
		/* Mult/addition is commutative so switch signs on x, y
		   and keep adding -x so y can still hit base case in
		   recursive call. */
		if(y < 0 && x > 0) {
			y = -y;
			x = -x;
		}
		/* Mult. of two negative values is same as mult. two positives. */
		if(y < 0) {
			y = -y;
			if(x < 0) x = -x;
		} 
		if(y == 0) return 0;
		return x + multiply(x, y - 1);
	}
}

/*
private int[][] numVector = new int[][] {{10, 2}, {-51, -4}, {3, 9}, {-21, 5}, {1024, 7}, {273, -6}, {0, 4}};
@Test
	public void test02() {
		assertEquals(NumberMult.multiply(numVector[1][0], numVector[1][1]), resVector[1]);
	}

@Test
	public void test06() {
		assertEquals(NumberMult.multiply(numVector[5][0], numVector[5][1]), resVector[5]);
	}
	*/
	
	 public static int mystery(int k) {​
	     if (k > 0) {​
		     return k + mystery(k + 1);​
		} else {​
		    return 0;​
	}
    
    public static void main(String[] args) {
        
       mystery(args[0];​
}