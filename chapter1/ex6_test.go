package main

import "testing"

func TestCompress(t *testing.T) {
	cases := []struct{
		input string
		expected string
	} {
		{"aabcccccaaa", "a2b1c5a3"},
		{"aaaa", "a4"},
	}

	for _, s := range cases {
		actual := compress(s.input)
		if actual != s.expected {
			t.Fatalf("Error! Expected %s, got %s on input %s!", s.expected, actual, s.input)
		}
	}
}
