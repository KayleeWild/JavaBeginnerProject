# Overview

This is a simple, butterfly-themed, number guessing game. The game generates a random number (between a range that can be specified in the code with the variables UPPER and LOWER), and prompts the user to guess it. If the guess is wrong, the game will prompt you to guess higher or lower, depending on the guess. This process repeats until the guess is correct, in which case it tells you how your score compares with the current high score. It then gives an option to save your high score, along with a username. The game is included in a loop, which allows the user to determine if they want to play again and starts over the game.

My purpose for writing this software was to expirament with the Java programming language, as well as to increase my skills of self-guided learning. The program explores many aspects of Java, including string and int data types, if/else statements, while loops, imports, reading/writing to a file, and more.

{Provide a link to your YouTube demonstration. It should be a 4-5 minute demo of the software running and a walkthrough of the code. Focus should be on sharing what you learned about the language syntax.}

[Java Intro Program Video](https://youtu.be/tmWYH61B-G8)

# Development Environment
### Tools/IDEs used
* IntelliJ IDEA by JetBrains
* VS Code
### Programming Language(s)
* Java


# Useful Websites

- [Java in Visual Studio Code](https://code.visualstudio.com/docs/languages/java)
- [Java Beginner Video by Programming with Mosh](https://www.youtube.com/watch?v=eIrMbAQSU34)
- [W3Schools Java Tutorial](https://www.w3schools.com/java/)

# Future Work

- Fixing the high score notification to include multiple high scores that are equal.
- Create a GUI for a prettier interface.
- Add other games that utilize the same file handler class. This would allow for code reuse, but would require modifying the methods to take a file path as a parameter so the two wouldn't be written to the same file. 