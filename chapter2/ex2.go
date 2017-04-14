package main

import (
	"container/list"
	"fmt"
)


func kthToLast(l *list.List, k int) interface{} {
	p1 := l.Front()
	p2 := l.Front()

	for i := 0; i < k; i++ {
		if p1 == nil {
			return nil
		}
		p1 = p1.Next()
	}

	for p1 != nil {
		p1 = p1.Next()
		p2 = p2.Next()
	}

	return p2.Value
}


func main() {
	l := list.New()
	l.PushBack(1)
	l.PushBack(2)
	l.PushBack(3)
	l.PushBack(4)
	l.PushBack(5)
	l.PushBack(6)

	fmt.Println(kthToLast(l, 1))
}
