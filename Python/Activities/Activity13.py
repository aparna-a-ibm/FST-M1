def getSum(numbers):
    sum = 0
    for number in numbers:
        sum += number
    return sum


numList = [30, 20, 50, 90]

result = getSum(numList)

print("The sum of all the elements is: " + str(result))
