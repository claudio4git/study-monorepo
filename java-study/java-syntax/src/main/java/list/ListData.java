package list;

import java.util.*;

public class ListData {
    public static void main(String[] args) {
        // array list works with an array inside
        ArrayList<String> names = new ArrayList<>();
        names.add("Maria");
        names.add("Peter");

        System.out.println("Name: " + names.get(0));

        // linked list works with one item linking another
        LinkedList<String> linkedNames = new LinkedList<>();
        linkedNames.add("Jhon");
        linkedNames.addFirst("Maria");
        linkedNames.addLast("Peter");

        System.out.println("Name: " + linkedNames.get(0));

        // hash set works with unique values
        HashSet<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Maria");
        uniqueNames.add("Maria");

        for (String name : uniqueNames) {
            System.out.println("Name is: " + name); // do not have a get method
        }

        // hash map storage key and value
        HashMap<Integer, String> properties = new HashMap<>();
        properties.put(0, "user.name");

        System.out.println("Key is: " + properties.get(0));
    }
}
