include(":billing")
rootProject.name = "My Application"
include(":app", "base")
project(":base").projectDir = File("base")
