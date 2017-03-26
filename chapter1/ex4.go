package main

func IsPermutationPalindrome(s string) bool {
	// Allocates and initializes a hash map data structure and returns a type T
	freqTable := make(map[int]int)

	for i := 'a'; i <= 'z'; i++ {
		freqTable[int(i)] = 0
	}

	for _, c := range s {
		freqTable[int(c)]++
	}

	foundOdd := false
	for _, c := range s {
		if freqTable[int(c)]%2 == 1 {
			if foundOdd {
				return false
			}
			foundOdd = true
		}
	}

	return true
}
