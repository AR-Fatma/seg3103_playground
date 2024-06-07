# Date Class Testing Lab
## This lab focuses on testing the Date class to achieve high code coverage using JUnit and JaCoCo.


# Step 1: Compile the Source and Test Classes
javac -d bin -cp lib/junit-platform-console-standalone-1.7.1.jar src/*.java test/*.java

# Step 2: Run JUnit Tests with JaCoCo Agent
java -javaagent:lib/jacocoagent.jar -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path bin --scan-class-path

# Step 3: Generate the JaCoCo Coverage Report
java -jar lib/jacococli.jar report jacoco.exec --classfiles bin --sourcefiles src --html report

![Coverage Screenshot](lab03/Screenshots/Coverage Screenshot.png)
