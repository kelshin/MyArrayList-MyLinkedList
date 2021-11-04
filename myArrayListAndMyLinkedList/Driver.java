package assignment.myArrayListAndMyLinkedList;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        // 1. creating an empty arraylist of strings
        MyArrayList<String> countries = new MyArrayList<>();
        countries.add("Canada");
        countries.add("Brazil");
        countries.add("Mexico");
        countries.add(0,"Japan");
        countries.remove("Canada");

        MyArrayList<String> countries2 = new MyArrayList<>();
        countries2.add("Philippines");
        countries2.add("Turkey");
        countries2.add("China");
        countries2.add("Philippines");
        countries2.add("Turkey");
        countries2.add("China");

        System.out.println("===toString===");
        System.out.println(Arrays.toString(countries.toArray()));
        System.out.println();
        System.out.println("===addAll with index===");
        countries.addAll(1,countries2);
        System.out.println(countries);
        System.out.println();
        System.out.println("===retainall===");
        System.out.println("===before===");
        System.out.println(countries);
        System.out.println(countries2);
        countries.retainAll(countries2);
        System.out.println("===after===");
        System.out.println(countries);
        System.out.println();
        System.out.println("===indexOf china===");
        System.out.println(countries2.indexOf("China"));
        System.out.println();
        System.out.println("===lastIndexOf china===");
        System.out.println(countries2.lastIndexOf("China"));


        MyLinkedList<String> numsOdd = new MyLinkedList<String>();
        numsOdd.addLast("1");
        numsOdd.addLast("3");
        numsOdd.addLast("5");
        numsOdd.addLast("7");
        numsOdd.addLast("9");

        MyLinkedList<String> numsEven = new MyLinkedList<String>();
        numsEven.addLast("2");
        numsEven.addLast("4");
        numsEven.addLast("6");
        numsEven.addLast("2");
        numsEven.addLast("4");
        numsEven.addLast("6");
        numsEven.addLast("4");
        numsEven.addLast("6");

        System.out.println();
        System.out.println("=== My Linked List ===");
        System.out.println();
        System.out.println("=== My remove last ===");
        System.out.println(numsOdd);
        System.out.println("Previous data removed: " + numsOdd.removeLast());
        System.out.println(numsOdd);

        System.out.println("=== Remove element ===");
        System.out.println(numsOdd);
        numsOdd.remove("5");
        System.out.println(numsOdd);

        System.out.println("=== Remove index ===");
        System.out.println(numsOdd);
        numsOdd.remove(2);
        System.out.println(numsOdd);

        System.out.println("=== Last index of ===");
        System.out.println(numsEven);
        System.out.println("Last occurrence is at index: " + numsEven.lastIndexOf("2"));


        System.out.println("=== reverse ===");
        MyLinkedList<String> nums = new MyLinkedList<String>();
        nums.addLast("1");
        nums.addLast("2");
        nums.addLast("3");
        nums.addLast("4");
        System.out.println(nums);
        nums.reverse();
        System.out.println(nums);
    }
}
