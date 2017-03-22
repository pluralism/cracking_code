package main

import "testing"

func TestReplaceString(t *testing.T) {
	cases := []struct {
		input    string
		expected string
	}{
		{"andre pinheiro", "andre%20pinheiro"},
		{"andrepinheiro", "andrepinheiro"},
		{"pl m", "pl%20m"},
	}

	for _, c := range cases {
		actual := ReplaceSpace(c.input)
		if actual != c.expected {
			t.Fatalf("Error! Expected %s, got %s on input %s", c.expected, actual, c.input)
		}
	}
}
