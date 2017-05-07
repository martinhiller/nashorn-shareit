#!/usr/bin/jjs -scripting

var Paths = Java.type("java.nio.file.Paths");
var Files = Java.type("java.nio.file.Files");
var SimpleFileVisitor = Java.type("java.nio.file.SimpleFileVisitor");
var FileVisitResult = Java.type("java.nio.file.FileVisitResult");

var workingDir = Paths.get(".").toAbsolutePath().normalize();

function createBackupDirectory() {
	var now = new Date();
	var backupDirName = ".backup-${now.getFullYear()}-${now.getMonth() + 1}-${now.getDate()}-${now.getHours()}-${now.getMinutes()}-${now.getSeconds()}-${now.getMilliseconds()}";
	var backupPath = workingDir.resolve(backupDirName);
	Files.createDirectory(backupPath);
	print("Created backup directory: " + backupPath.getFileName());
	return backupPath;
}

var backupDir = createBackupDirectory();

function copyToBackupDir(path) {
	var backupPath = backupDir.resolve(workingDir.relativize(path));
	print("Copy '${workingDir.relativize(path)}' to '${workingDir.relativize(backupPath)}'");
	Files.copy(path, backupPath);
}

var backupFileVisitor = new (Java.extend(SimpleFileVisitor))({
	preVisitDirectory: function(dir) {
		if (dir == workingDir) {
			return FileVisitResult.CONTINUE;
		}
		if (dir.getFileName().toString().startsWith(".backup")) {
			return FileVisitResult.SKIP_SUBTREE;
		}
		copyToBackupDir(dir);
		return FileVisitResult.CONTINUE;
	},
	visitFile: function(file) {
		copyToBackupDir(file);
		return FileVisitResult.CONTINUE;
	}
});

Files.walkFileTree(workingDir, backupFileVisitor);
