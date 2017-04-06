package main


func rotateMatrix(a [][]int) [][]int {
	tam, max_index, layer := len(a[0]), len(a[0]) - 1, 0
	for tam >= 2 {
		counter := 0
		for i := layer; i < max_index; i++ {
			temp := a[layer][i]
			a[layer][i] = a[max_index - counter][layer]
			a[max_index - counter][layer] = a[max_index][max_index - counter]
			a[max_index][max_index - counter] = a[i][max_index]
			a[i][max_index] = temp
			counter++
		}
		layer, max_index, tam = layer + 1, max_index - 1, tam - 2
	}
	return a
}