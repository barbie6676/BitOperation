//cc5.1
//set the bits between ith and jth bit in n to become m

// i is smaller (to right) i is larger (to left) 
// j-i+1 = total bits in m.


public int updateBits(int n, int m, int i, int j) {
		//n =512
		
		int max = ~0; // all 1
		int left = max - ((1<<j)-1); //all 1, from jth become all 0
		int right = (1<<i); //all 0, start from ith, become all 1,
		
		//set the part to be update to 0, everything else is 1
		int mask = left | right;
		
		// fill m in this part
		return (n&mask)|(m<<i);
		
	}
