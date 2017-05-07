var Runnable = Java.type("java.lang.Runnable");

function greetLater(person) {
	return new Runnable({
		run: function() {
			print("Hello, " + person.firstName + "!");
		}
	});
}

// Alternatively, as Runnable is a functional interface
function greetLater(person) {
	return function() {
		print("Hello, " + person.firstName + "!");
	};
}
