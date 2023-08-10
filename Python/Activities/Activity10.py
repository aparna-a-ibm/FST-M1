#Get a tuple, iterate through that and get numbers divisible by 5

newTuple = tuple(input("Enter a sequence of comma separated values for the tuple: ").split(", "))
print("Given tuple is ", newTuple)

# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in newTuple:
    if (int(num) % 5 == 0):
        print(num)
