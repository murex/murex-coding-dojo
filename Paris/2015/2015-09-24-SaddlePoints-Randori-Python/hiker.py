if not matrix:
            return []
        max_values = [max(row) for row in matrix]
        height = len(matrix)
        width = len(matrix[0])
        min_values = [min([ matrix[i][j] for j in range(height) ]) for i in range(width ) ]
        #Must flatten the list
        coords = [[[y, x] for x in range(width)] for y in range(height)]
        return [c for c in coords if (matrix[c[0], c[1]] == max_values[c[0]] and matrix[c[0], c[1]] == min_values[c[1]])]