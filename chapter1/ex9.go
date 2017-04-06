package main

import (
	"fmt"
	"strings"
)

func IsRotation(s1, s2 string) bool {
	s2s2 := []string{s2, s2}

	return strings.Contains(strings.Join(s2s2, ""), s1)
}

func main() {
	fmt.Println(IsRotation("waterbottle", "erbottlewat"))
}
