# Project notes

## Maven

Link to configure https://www.baeldung.com/maven-java-version

## Data types

Primitive data types:
- byte, short, int, long, float, double, boolean and char

Non-primitive data types 
  - String, Arrays and Classes

## Type Casting

Widening Casting (automatically) - converting a smaller type to a larger type size
- byte -> short -> char -> int -> long -> float -> double

Narrowing Casting (manually) - converting a larger type to a smaller size type
- double -> float -> long -> int -> char -> short -> byte

## Java Math

- `Math.max(x,y)` to find the highest value of x and y
- `Math.min(x,y)` to find the lowest value of x and y
- `Math.sqrt(x)` returns the square root (raiz quadrada) of x
- `Math.abs(x)` returns the absolute (positive) value of x
- `Math.random()` returns a random number between 0.0 (inclusive), and 1.0 (exclusive)

## Collections

ArrayList (List)
- Sizable array inside
- Accepts null and duplicated
- Better to search operations
- Insertion order

Vector (List)
- Same as ArrayList
- Synchronized
- Accepts null and duplicated
- Insertion order

LinkedList (List, Queue)
- Storage as nodes
- Each position has: previous, value and next
- Accepts null and duplicated
- Better to insert/delete operations
- Insertion order

HashSet (Set)
- Uses HashMap to store elements
- Accept one null and isn't accept duplicates
- No order

LinkedHashSet (Set)
- Uses LinkedHashMap to store elements
- Accept one null and isn't accept duplicates
- Insertion order

TreeSet (Set)
- Uses TreeMap to store elements
- Doesn't accept null and duplicates
- Comparator order or natural order

HashMap (Map)
- Uses array and linked list to store elements
- One null key
- No order

LinkedHashMap (Map)
- Same as HashMap but uses double linked list
- One null key
- Insertion order

TreeMap (Map)
- Uses RedBlack tree
- Doesn't allow null key
- Comparator order or natural order

## Java compile and run

```
$ javac File.java
$ java File
```
