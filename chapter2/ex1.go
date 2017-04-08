package main

import (
	"container/list"
	"fmt"
)

func main() {
	toDelete := []*list.Element{}
	visited := make(map[interface{}]bool)


	l := list.New()
	e4 := l.PushBack(4)
	e1 := l.PushFront(1)
	l.InsertBefore(3, e4)
	l.InsertAfter(2, e1)
	l.PushBack(4)
	l.PushBack(4)
	l.PushBack(4)
	l.PushBack(4)
	l.PushBack(4)
	l.InsertAfter(2, e1)
	l.InsertAfter(2, e1)
	l.PushBack(1)



	for e := l.Front(); e != nil; e = e.Next() {
		if _, ok := visited[e.Value]; ok {
			toDelete = append(toDelete, e)
		} else {
			visited[e.Value] = true
		}
	}

	for _, elem := range toDelete {
		l.Remove(elem)
	}

	for e := l.Front(); e != nil; e = e.Next() {
		fmt.Println(e.Value)
	}
}
