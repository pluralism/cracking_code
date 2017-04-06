package main

import (
	"bytes"
	"fmt"
)

func compress(s string) string  {
	var buffer bytes.Buffer
	arr := []rune(s)
	counter, currentChar := 0, arr[0]

	for i, c := range arr {
		if c != currentChar || i + 1 == len(arr) {
			if i + 1 == len(arr) {
				counter++
			}
			buffer.WriteString(fmt.Sprintf("%c%d", currentChar, counter))
			counter = 0
			currentChar = c
		}
		counter++
	}
	return buffer.String()
}