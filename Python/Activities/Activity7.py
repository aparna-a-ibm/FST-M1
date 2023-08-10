numbers = list(input("Enter a sequence of comma separated values: ").split(", "))
sum = 0

for number in numbers:
    sum += int(number)

print("The sum of the given numbers is ")
print(sum)