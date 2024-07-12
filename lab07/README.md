# SEG3103 Lab 07 - Static Analysis with SpotBugs

## Introduction
This lab focuses on using SpotBugs for static analysis of a Java project. The goal is to identify and fix issues in the code to improve its quality and reliability.

## Project Setup
1. Create a directory named `lab07`.
2. Extract the provided `Calculator.zip` into the `lab07` directory.

## Identified Issue

### Issue: Comparison of String parameter using `==` or `!=` in `CalCFrame.clickCheck(String)`
**Description:** The `==` operator checks for reference equality instead of value equality when comparing strings.

**Original Code:**
```java
public boolean clickCheck(String s) {
  if (s == "")
    doubleclick = true;
  else 
    doubleclick = false;
  
  return doubleclick;
}
```
**Updated Code:**
```java
Updated code
public boolean clickCheck(String s) {
  doubleclick = s.equals("");
  return doubleclick;
}
```
![Screenshot_1](lab07/Screenshot/Screenshot_1.png)
![Screenshot_2](lab07/Screenshot/Screenshot_2.png)
![Updated](lab07/Screenshot/Updated.png)

