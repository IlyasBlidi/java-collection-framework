package com.kurapika;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WorkingWithMaps {
  public static void main(String[] args) {
    Map<Person, Car> map = new HashMap<>();
    map.put(
      new Person("Alex"),
      new Car("Dacia Sandero")
    );

    System.out.println(new Person("Alex").hashCode());
    System.out.println(new Person("Alex").hashCode());
    System.out.println(map.get(new Person("Alex")));
  }

  private static void maps() {
    Map<Integer, Person> map = new HashMap<>();
    map.put(1, new Person("Alex"));
    map.put(2, new Person("Alexandar"));
    map.put(3, new Person("Ali"));
    System.out.println(map.size());
    System.out.println(map.get(1));
    System.out.println(map.containsKey(4));
    System.out.println(map.keySet());
    System.out.println(map.entrySet());

    map.remove(3);

    map.entrySet().forEach(System.out::println);

    map.forEach((key, value) -> System.out.println(key + " - " + value));

    System.out.println(map.getOrDefault(3, new Person("default")));
    System.out.println(map.values());
  }

  static class Person {
    String name;

    @Override
    public String toString() {
      return "Person{" +
        "name='" + name + '\'' +
        '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Person person = (Person) o;
      return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(name);
    }

    public Person(String name) {
      this.name = name;
    }
  }

  record Car(String name) {
  }
}
