#Dictionary of fruits and their prices and to check if fruit asked by user is available in the list
fruit_shop = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}

check = input("Which fruit are you looking for? ").lower()

if(check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")