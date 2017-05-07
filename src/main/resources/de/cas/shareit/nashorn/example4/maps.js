// Maps behave like JS objects
print(persons["Glaser"]);
print(persons.Glaser);

// Iterate over maps
for (var lastName in persons) {
	print(persons[lastName]);
}
