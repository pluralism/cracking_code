package main

import (
	"container/list"
	"fmt"
)

func deleteNode(n *list.Element) bool {
	if n == nil || n.Next() == nil {
		return false
	}

	next := n.Next()
	n.Value = next.Value
	n.Next() = next.Next()
	return true
}

func main() {
	l := list.New()
	l.PushBack(1)
	l.PushBack(2)
	l.PushBack(3)
	l.PushBack(4)
	l.PushBack(5)
	l.PushBack(6)

	deleteNode(l.Front())
	for e := l.Front(); e != nil; e = e.Next() {
		fmt.Println(e.Value)
	}
}
