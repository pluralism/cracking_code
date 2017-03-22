package main

func IsUniqueChars(s string) bool {
	flags := make(map[rune]bool)
	for _, c := range s {
		if _, ok := flags[c]; ok {
			return false
		}
		flags[c] = true
	}
	return true
}
