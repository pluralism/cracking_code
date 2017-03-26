package main

func isPermPalindrome(phrase string) bool {
	return createBitVector(phrase) == 0 || checkExactlyOneBitSe(createBitVector(phrase))
}

func createBitVector(phrase string) uint {
	var bitVector uint

	for _, c := range phrase {
		bitVector = toggle(bitVector, uint(c))
	}

	return bitVector
}

func toggle(bitVector, index uint) uint {
	if index < 0 {
		return bitVector
	}

	var mask uint = 1 << index
	if (bitVector & mask) == 0 {
		// Turn to 1
		bitVector |= mask
	} else {
		// Turn to 0
		bitVector &= ^mask
	}

	return bitVector
}

func checkExactlyOneBitSe(bitVector uint) bool {
	return (bitVector & (bitVector - 1)) == 0
}
