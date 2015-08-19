class IA:
    def __init__(self, symbol):
        self.symbol = symbol
    def play(self, Grid):
        for row in range(0,3):
            for col in range(0,3):
                if Grid[row][col] == ' ':
                    return [col, row]
        return [0,0]