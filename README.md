# Amazing Numbers - Gapful Numbers

## Description
Amazing Numbers is a program that analyzes the properties of natural numbers. In this version, the program introduces the concept of **Gapful numbers**. A number is considered **Gapful** if:

- It contains at least **three digits**.
- It is **divisible** by the concatenation of its first and last digit.

For example:

- **132** is Gapful because **132 % 12 == 0**.
- **7881** is Gapful because **7881 % 71 == 0**.
- **12** is **not** Gapful because it has only **two digits**.

Additionally, the program can now process **lists of numbers** when the user inputs two numbers. The first number is the starting point, and the second number represents how many consecutive numbers should be analyzed.

## Features & Objectives

The program follows these steps:

1. **Welcomes** users.
2. **Displays instructions** on how to use the program.
3. **Asks for user input**:
    - If the user enters `0`, the program terminates.
    - If the user provides an empty request, the program re-displays the instructions.
    - If the input is **one number**, the program prints its properties.
    - If the input is **two numbers**, the program prints a list of numbers along with their properties.
    - If the input is invalid (not a natural number), an error message is displayed.
4. **Repeats** the process until the user chooses to exit.

### **Supported Properties**

The program evaluates the following properties:

- **even**: The number is divisible by 2.
- **odd**: The number is not divisible by 2.
- **buzz**: The number is divisible by 7 or ends with 7.
- **duck**: The number contains at least one `0`.
- **palindromic**: The number is the same when read forward and backward.
- **gapful**: The number has at least three digits and is divisible by its first and last digit concatenated.

## Instructions

### Supported requests:

- Enter a **natural number** to know its properties.
- Enter **two natural numbers** to obtain the properties of a list:
    - The first parameter represents the **starting number**.
    - The second parameter represents how many **consecutive numbers** should be analyzed.
- Separate the parameters with **one space**.
- Enter **0 to exit** the program.

## Error Messages

If the user inputs invalid values, the program will respond with:

- `The first parameter should be a natural number or zero.`
- `The second parameter should be a natural number.`

## Example Usage

**Note:** The `>` symbol represents user input.