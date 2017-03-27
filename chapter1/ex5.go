package main

import (
	"fmt"
	"math"
)

func oneAway(first, second string) bool {
	if math.Abs(float64(len(first)-len(second))) > 1 {
		return false
	}

	largestString, smallestString := "", ""

	if len(first) > len(second) {
		largestString = first
		smallestString = second
	} else {
		largestString = second
		smallestString = first
	}

	stringMap := make(map[byte]int)
	for i := range largestString {
		stringMap[largestString[i]]++
		if i < len(smallestString) {
			stringMap[smallestString[i]]--
		}
	}

	count := 0
	for _, v := range stringMap {
		if v == 0 {
			count++
		}
	}
	return math.Abs(float64(len(largestString)-count)) <= 1
}

func main() {
	fmt.Println(oneAway("pale", "pale"))
}
