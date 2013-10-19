// number in binary presentation, 
// given a number, print next larger and next smaller number with the same number of 1s


// the bit at index is 1 return true; is 0 return false
// index has to be less or equal to the total bits of n
// example get(100,2) = true, get(100,1) = false;
public boolean getBit(int n, int index) {
    return ((n & (1<<index) > 0));
}


public int setBit(int n, int index, boolean b){
    if (b){
        return n | (1<<index);
    } else {
      int mask = ~(1<<index);
        return n & mask;
    }
}

public int getNextLarger(int n) {
	if (n <= 0) return -1;
	
	int index = 0;
	int countOnes = 0;// count the continous number of 1 from the right side.
	
	//find the fist 1
	while (!getBit(n,index))
		index++;
	
	//turn on the next 0
	while(getBit(n,index)) {
		index++;
		countOnes++;
	}
	n = setBit(n, index, true);
	
	//turn off the 1 just right to the 0 just turned on;
	n = setBit(n, --index, false);
	countOnes --;
	
	//rearrange the rest of the 1 to place them as right as possible
	for (int i = index -1; i>= countOnes;i--) {
		n = setBit(n,i,false);
	}
	for (int i = countOnes -1 ;i >=0; i--) {
		n = setBit(n,i,true);
	}
	
	return n;
}

public int getNextSmaller(int n) {
	if (n <= 0) return -1;
	
	int index = 0;
	int countZeros = 0;// count the continous number of 1 from the right side.
	
	//find the fist 0
	while (getBit(n,index))
		index++;
	
	//turn off the next 1
	while(!getBit(n,index)) {
		index++;
		countZeros++;
	}
	n = setBit(n, index, false);
	
	//turn on the 0 just right to the 1 just turned off;
	n = setBit(n, --index, true);
	countZeros --;
	
	//rearrange the rest of the 1 to place them as left as possible
	for (int i = index -1; i>= countZeros;i--) {
		n = setBit(n,i,true);
	}
	for (int i = countZeros -1 ;i >=0; i--) {
		n = setBit(n,i,false);
	}
	
	return n;
}
