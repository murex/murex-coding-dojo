list = []
def score(result):
    global list
    result = result.replace('-', '0')
    list = result.replace('|','')
    return cal(0, 1, 1)
def cal(index, mul1, mul2):
    if (len(list) == index):
         return 0
    round = list[index]
    if (round == 'X'):
        return (10 * mul1) + cal(index+1, mul2 + 1, 2)
    elif (round == '/'):
        return (10- int(list[index-1]))* mul1 + cal(index+1, mul2+1, 1)
    else:
        return int(round) * mul1 + cal(index+1, mul2, 1)