import operator
ops = { "+": operator.add, "-": operator.sub, "*": operator.mul, "/": operator.div}
def countdown(numbers, target):
    possibleResults = {}
    res = "None"
    for number in numbers:
        if number == target:
            res = str(number)
    for key in ops.keys():
        if res == "None":
            res = apply_operator(key, numbers, target)
        else:
            break
    return res
def apply_operator(strOp, numbers, target):
    op = ops[strOp]
    for i, number in enumerate(numbers):
        for other in numbers[i+1:]:
            if op(other, number) == target:
                return str(other) + strOp + str(number)
    return "None"