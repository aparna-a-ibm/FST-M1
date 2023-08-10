#Program to check if first and last elements of a list are same

# Get list of numbers from user
numbers = list(input("Enter a sequence of comma separated values: ").split(", "))

print("Given list is ", numbers)

# Get first element in list
firstElement = numbers[0]
# Get last element in list
lastElement = numbers[-1]

# Check if first and last element are equal
if (firstElement == lastElement):
    print("The first and last elements are same")
else:
    print("The first and last elements are not same")