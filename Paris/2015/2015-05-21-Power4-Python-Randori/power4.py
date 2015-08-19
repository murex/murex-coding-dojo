def isOver(grid):
    if checkGridByLine(grid):
        return True
    if checkGridByLine(zip(*grid)):
        return True
    otherGrid = getAllDiago(grid)
    return checkGridByLine(otherGrid)
#    return checkDiago(grid)
def checkLine(line):
    for i in range(len(line)) :
        subline = line[i:i+4]
        if (subline.count(1) == 4):
            return True
        if (subline.count(2) == 4):
            return True
    return False
def checkGridByLine(grid):
    for line in grid:
        if checkLine(line):
            return True
    return False
def checkDiago(grid):
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            diag = []
            for m in range(0, 4):
                diag.append(grid[i + m][ j + m])
            if checkLine(diag):
                return True
    return False
def getAllDiago(grid):
    nbDiago = len(grid) + len(grid[0]) - 1
    diago = [[] for i in range(nbDiago)]
    for lineIndex in range(len(grid)):
        line = grid[lineIndex]
        for diagoIndex in range(nbDiago):
            diago[diagoIndex] += diagoInLine(line, lineIndex, diagoIndex)
    return diago
def diagoInLine(line, lineIndex, diagoIndex):
    if diagoIndex - lineIndex < 0:
        return []
    if diagoIndex - lineIndex >= len(line):
        return []
    return [line[diagoIndex - lineIndex]]