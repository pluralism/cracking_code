package main

import "testing"

func TestIsRotation(t *testing.T) {
	cases := []struct{
		input1 string
		input2 string
		expected bool
	} {
		{"waterbottle", "erbottlewat", true},
		{"waterbottle", "aaaa", false},
	}


	for _, s := range cases {
		actual := IsRotation(s.input1, s.input2)
		if actual != s.expected {
			t.Fatalf("Error! Expected %t, got %t", s.expected, actual)
		}
	}
}
