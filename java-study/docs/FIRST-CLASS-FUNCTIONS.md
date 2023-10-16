# First-Class Functions Examples

## Example 1: Using `Function` Interface

```java
public class Example {
    protected static class MyMath {
        public static Integer triple(Integer x) {
            return x * 3;
        }
    }
    
    public static void main(String[] args) {
        Function<Integer, Integer> myTriple = MyMath::triple;
        Integer result = myTriple.apply(5);
        
        System.out.println(result); // print 15
    }
}
```

## Example 2: Using `Lambda Expression` On Functions

```java
public class Example {
    public static void main(String[] args) {
        Function<Integer, Integer> absoluteValue =
                (x) -> x < 0 ? -x : x;
        
        System.out.println(absoluteValue.apply(-100)); // print 100
        System.out.println(absoluteValue.apply(98)); // print 98
    }
}
```

## Example 3: Using `BiFunciton` Function

```java
public class Example {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = 
                (x, y) -> x + y;
      
        System.out.println(add.apply(3, 2)); // print 5
    }
}
```

## Example 4: Using `Custom` Functions

First you need to create your own interface.

```java
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
```

```java
public interface NoArgFunction<R> {
    R apply();
}
```

Now using these interfaces.

```java
public class Example {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> addThree = 
                (x, y, z) -> x + y + z;
        NoArgFunction<String> sayHello = () -> "Hello!";
      
        System.out.println(addThree.apply(3, 2, 5)); // print 10
        System.out.println(sayHello.apply()); // print Hello!
    }
}
```

## Example 5: Using Functions As `Data`

```java
public class Example {
    protected static class Person {
        private String name;
        private Integer age;
        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
    
    protected static class DataLoader {
        public final NoArgFunction<Person> loadPerson;
        
        public DataLoader(Boolean isDevelopment) {
            this.loadPerson = isDevelopment
                    ? this::loadPersonFake
                    : this::loadPersonReal;
        }
        
        private Person loadPersonReal() {
            System.out.println("Loading person...");
            return new Person("Real Person", 30);
        }

        private Person loadPersonFake() {
          System.out.println("Loading fake person...");
          return new Person("Fake Person", 30);
        }
    }
    
    public static void main(String[] args) {
        final Boolean IS_DEVELOPMENT = true;
        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);
        System.out.println(dataLoader.loadPerson.apply());        
    }
}
```

## Example 6: `Passing` Functions As Arguments

- Pass data to the function do something (add/subtract functions)
- Pass the function and do something with the data (combine2And3 function)

```java
public class Example {
    protected static class MyMath {
        public static Integer add(Integer x, Integer y) {
            return x + y;
        }

        public static Integer subtract(Integer x, Integer y) {
            return x - y;
        }

        public static Integer combine2And3(BiFunction<Integer, Integer, Integer> combineFunc) {
            return combineFunc.apply(2, 3);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(MyMath.combine2And3(MyMath::add)); // print 5
        System.out.println(MyMath.combine2And3(MyMath::subtract)); // print -1
        System.out.println(MyMath.combine2And3((x, y) -> 2 * x + 2 * y)); // print 10
    }
}
```

## Example 7: `Returning` Functions

- Functions returning data (black box returning data)
- Functions returning functions (black box returning black box)

Simple:

```java
public class Example {
    public static void main(String[] args) {
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> () -> "Hello functional!";
        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());
    }
}
```

Real-world use:

```java
public class Example {
    protected static class MyMath {
        public static Integer timesTwo(Integer x) {
            return x * 2;
        }

        public static Integer timesThree(Integer x) {
            return x * 3;
        }
        
        public static Function<Integer, Integer> createMultiplier(Integer y) {
            return (Integer x) -> x * y;
        }
    }
    
    public static void main(String[] args) {
        Function<Imnteger, Integer> timesTwo = MyMath.createMultiplier(2);
        Function<Imnteger, Integer> timesThree = MyMath.createMultiplier(3);
        Function<Imnteger, Integer> timesFour = MyMath.createMultiplier(4);
        
        System.out.println(timesTwo.apply(2)); // print 4
        System.out.println(timesTwo.apply(2)); // print 6
        System.out.println(timesTwo.apply(2)); // print 12
    }
}
```

The external function has access to variables from the internal function returned, and it is called `closure`.

- `name` is defined on internal function
- `name` can be used on the external function

```java
public class Example {
    public static void main(String[] args) {
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> () -> {
            String name = "Claudio";
            return () -> "Hello" + name;
        };
        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());
    }
}
```

## Example 8: Using `Higher-order` Functions

When passing functions as argument, and returning functions we call it high-order functions.

Doing two responsibility:

- Dividing numbers
- Doing the zero verification

```java
public class Example {
    public static void main(String[] args) {
        BiFunction<Float, Float, Float> divide = (x, y) -> {
            if (y == 0f) {
                System.out.println("Error: second arg is zero");
                return 0f;
            }
            return x / y;
        };
        
        System.out.println(divide.apply(10f, 0f)); // print message of error
    }
}
```

One simple responsibility per function.

```java
public class Example {
    public static void main(String[] args) {
        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;
        
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> secondArgIsNotZeroCheck =
                (func) -> () -> {
                    if (y == 0f) {
                        System.out.println("Error: second arg is zero");
                    }
                    return func.apply(x, y);
                };

        BiFunction<Float, Float, Float> divideSafe = secondArgIsNotZeroCheck.apply(divide);
        
        System.out.println(divideSafe.apply(10f, 0f)); // print message of error
        System.out.println(divideSafe.apply(10f, 2f)); // print 5
    }
}
```
