package chapter1

import "testing"

func TestIsUniqueChars(t *testing.T) {
	cases := []struct {
		input    string
		expected bool
	}{
		{"test", false},
		{"golang", false},
		{"programming", false},
		{"c++", false},
		{"abcd", true},
	}

	for _, c := range cases {
		actual := IsUniqueChars(c.input)
		if actual != c.expected {
			t.Fatalf("Error! Expected %t, got %t on input %s", c.expected, actual, c.input)
		}
	}
}
