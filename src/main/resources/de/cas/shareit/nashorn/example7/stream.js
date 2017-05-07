var Collectors = Java.type("java.util.stream.Collectors");

function includes(string, keyword) {
	return new RegExp(keyword, "i").test(string);
}

function filter(persons, keyword) {
	return persons
			.stream()
			.filter(function(person) {
				return includes(person.firstName, keyword)
					|| includes(person.lastName, keyword);
			})
			.collect(Collectors.toList());
}
