Flat-json-stylish:
		./build/install/app/bin/app Flatfile1.json Flatfile2.json
Flat-yaml-stylish:
		./build/install/app/bin/app Flatfile1.yml Flatfile2.yml
Flat-json-plain:
		./build/install/app/bin/app -f plain Flatfile1.json Flatfile2.json
Flat-yaml-plain:
		./build/install/app/bin/app -f plain Flatfile1.yml Flatfile2.yml
Structure-json-stylish:
		./build/install/app/bin/app DataStructure1.json DataStructure2.json
Structure-yaml-stylish:
		./build/install/app/bin/app DataStructure1.json DataStructure2.json
Structure-json-plain:
		./build/install/app/bin/app -f plain DataStructure1.json DataStructure2.json
Structure-yaml-plain:
		./build/install/app/bin/app -f plain DataStructure1.json DataStructure2.json
run-Flatjson-out:
		./build/install/app/bin/app -f json Flatfile1.json Flatfile2.json
run-Structurejson-out:
		./build/install/app/bin/app -f json DataStructure1.json DataStructure2.json
run-help:
		./build/install/app/bin/app -h
build:
		./gradlew clean build
test:
		./gradlew clean test
clean:
		gradle clean
dist:
		gradle installDist
.PHONY: build
