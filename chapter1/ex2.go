package main

func permutation(s, t string) bool {
	if len(s) != len(t) {
		return false
	}

	letters := [128]int{}
	for _, v := range s {
		letters[v]++
	}

	for _, v := range t {
		letters[v]--
		if letters[v] < 0 {
			return false
		}
	}

	return true
}
