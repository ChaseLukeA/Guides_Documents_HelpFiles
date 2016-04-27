#Maven

**The `mvn` build life cycle:**

- process-resources
- compile
- process-test-resources
- test-compile
- test
	- The test phase of this mvn can be ignored by using a flag -DskipTests=true
- package
- install
- deploy

