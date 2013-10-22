// given an integer, reverse the bits and return the new int

public reverseBits(int i ) {
	int j = 0;
    while (i != 0) {
        j <<= 1;
        j |= (i & 1);
        i >>= 1;
    }  
    
    return j;

}
