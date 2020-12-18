package com.github.sioncheng.j11.proxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hello {
    public static void main(String[] args) {
        System.out.println("hello");

        List<Integer> ll = Collections.synchronizedList(new ArrayList<Integer>());
        ll.add(1);
        ll.add(2);

        ll.stream().forEach(System.out::println);
    }
}