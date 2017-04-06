package main

import "fmt"

type Pair struct {
	x, y int
}

func pairFunc() {
	a := [][]int{
		{1, 2, 3, 4},
		{0, 4, 5, 6},
		{7, 8, 9, 4},
	}
	vals := []Pair{}
	for i := 0; i < len(a); i++ {
		for j := 0; j < len(a[i]); j++ {
			if a[i][j] == 0 {
				vals = append(vals, Pair{x: i, y: j})
			}
		}
	}
	for _, v := range vals {
		row := v.x
		for i := 0; i < len(a[row]); i++ {
			a[row][i] = 0
		}
		col := v.y
		for i := 0; i < len(a); i++ {
			a[i][col] = 0
		}
	}
	fmt.Println(a)
}
