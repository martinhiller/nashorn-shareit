// Call Java methods on it
print("List size: " + persons.size());
print("First item: " + persons.get(0));

// Iterate over collection (classic index style)
for (var i = 0; i < persons.size(); i++) {
	// Access items in JS Array style
	print(persons[i]);
}

// Non-standard: For each (similar to ES6 "for of")
for each (var person in persons) {
	print(person);
}

// Convert to native JS array
var personsArray = Java.from(persons);
print("Is native JS array: " + (personsArray instanceof Array));
print("Array length: " + personsArray.length);
