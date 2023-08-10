# A new list as a combination of two from user, taking even numbers from one list and odd from the other

# Given lists
listOne = list(input("Enter a sequence of comma separated values for the first list: ").split(", "))

listTwo = list(input("Enter a sequence of comma separated values for the second list: ").split(", "))

# Print the lists
print("First List ", listOne)
print("Second List ", listTwo)

# Declare a third list that will contain the result
listThree = []

# Iterate through first list to get odd elements
for num in listOne:
    if int(num) % 2 != 0:
        listThree.append(num)

# Iterate through first list to get even elements
for num in listTwo:
    if int(num) % 2 == 0:
        listThree.append(num)

# Print result
print("result List is:")
print(listThree)

print(listOne.pop(0))
print(listOne)