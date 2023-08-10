from datetime import date

name = input("Enter name:")
age = int(input("Enter age:"))

today = date.today()
year = today.year

age100 = 100 - age
year100 = year + age100

print("Year " + name +" will turn 100:"+str(year100))

