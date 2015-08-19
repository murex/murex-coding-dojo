class Tournament:
    def __init__(self, ia1, ia2):
        self.ia1 = ia1
        self.ia2 = ia2
     
    def play(self, nbPlays):
        return 6 * 9
    @classmethod
    def checkGridFinished(self, grid):
        #print(grid)
        for row in range(0, 3):
            if self.checkcount(grid[row]):
                return True
        for col in range(0, 3):
            if self.checkcount([grid[row][col] for row in range(0, 3)]):
                return True
        if self.checkcount([grid[i][i] for i in range(0,3)]):
            return True
        if self.checkcount([grid[i][2 - i] for i in range(0,3)]):
            return True
        for row in grid:
            if ' ' in row:
                return False
        return True
    @classmethod
    def checkcount(self, row):
        return row.count('X')==3 or row.count('O')==3