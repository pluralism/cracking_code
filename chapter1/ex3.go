package main

func ReplaceSpace(s string) string {
	var spaceCount int
	stringRune := []rune(s)

	for _, c := range stringRune {
		if c == 0x20 {
			spaceCount++
		}
	}

	newRune := make([]rune, len(stringRune)-spaceCount+3*spaceCount)

	currentIndex := 0
	for i := 0; i < len(stringRune); i++ {
		if stringRune[i] != 0x20 {
			newRune[currentIndex] = stringRune[i]
			currentIndex++
		} else {
			newRune[currentIndex] = '%'
			newRune[currentIndex+1] = '2'
			newRune[currentIndex+2] = '0'
			currentIndex += 3
		}
	}
	return string(newRune)
}
