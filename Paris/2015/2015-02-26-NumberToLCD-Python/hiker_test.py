zero = ["._.","|.|","|_|"]
one= ["...","..|","..|"]
nine= ["._.","|_|","..|"]
 
numbers = [zero,one,0,0,0,0,0,0,0,nine]
 
def append_digit(listDigits, i):
    return " ".join([numbers[digit][i] for digit in listDigits])
 
def represent(d):
    listDigits = [int(c) for c in str(d)]
    return "\n".join(append_digit(listDigits, c) for c in [0,1,2])