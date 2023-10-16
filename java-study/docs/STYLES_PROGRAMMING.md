# Styles of Programming

- Declarative
    - Functional Programming
    - `WHAT is it?`
- Imperative
    - Object-Oriented Programming
    - `HOW do I get it?`

| Imperative: How                                           | Declarative: What                                                                |
|-----------------------------------------------------------|----------------------------------------------------------------------------------|
| 1. Set x equal to zero                                    | X is the sum of all the numbers in the array, divided by the length of the array |
| 2. Add the first number in the array to x                 |                                                                                  |
| 3. Repeat step 2 for the rest of the numbers in the array |                                                                                  |
| 4. Divide x by the length of the array                    |                                                                                  |

## Object-Oriented Programming Concepts

- Object-Oriented based
- Polymorphism
- Encapsulation
- Heritage

## Functional Programming Propose

- Not opposite from OOP
- More organized then OOP
- Easy to find and fix bugs
- Bring the precision of math into programming

## Functional Programming Concepts

- Immutability
- Functional purity
- First-class functions

### Immutability

- Variables do not change his value
- Variable not reassign value (imperative/object-oriented programming)
- Variable is the value (declarative/functional programming)
- Data is combined during the code

```java
final int x = 5; // x is 5 not has 5
```

### Functional Purity

- Always return the same output given the same input
- Is not pure when an internal or external state change
- None of our functions should refer to any kind of state, they should all be pure

```java
public class Person {
    private int age;
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
```

The class `Person` is not pure because the `getAge` method can change when calling `setAge` method.

```java
person.getAge();    // return 50
person.setAge(10);
person.getAge();    // return 10
```

Example of pure method:

```java
int add(int x, int y) {
    return x + y;
}
```

No meter how many times you call this method the result going to be the same given the same input.

### First-class Functions

- Passing and returning functions
- `Function<T, R>` interface in Java for one parameter
- `BiFunction<T, U, R>` interface in Java for two parameters
- You can create your own interface
- Flexibilities and reuse of code
- Define functions as variables
- We can use the `closure` to have access on variables between functions
- When passing functions as argument and returning functions we called it `Higher-order` functions

Here are some first-class functions [examples](FIRST-CLASS-FUNCTIONS.md).
