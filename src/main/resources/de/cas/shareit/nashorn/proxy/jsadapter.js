var obj = new JSAdapter() {
    __get__: function(name) {
        print("Getter called for '" + name + "'"); return name;
    },
 
    __put__: function(name, value) {
        print("Setter called for '" + name + "' with " + value);
    },
 
    __call__: function(name, arg1, arg2) {
        print("Method '" + name + "' called with " + arg1 + ", " + arg2);
    },
 
    __new__: function(arg1, arg2) {
        print("Constructor called with " + arg1 + ", " + arg2);
    }
}

new obj("arg", 42);
obj.prop;
obj.prop = 23;
obj.method("arg", 42)
