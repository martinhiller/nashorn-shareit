print("*** Access attributes in property style ***");

print(person.firstName);
print(person.lastName);
print(person.age);

print("*** Modify and print age ***");

person.age = 99;
print(person.age);

print("*** Call arbitrary Java methods ***");

print(person.getFirstName());
person.setLastName("Glade");
print(person.toString());