package java0;

import java.util.HashSet;

/**
 * @author YANG
 * @create 2021-04-08 10:33
 */
public class E {
    public static void main(String[] args) {
HashSet set = new HashSet();
Person p1 = new Person(1001, "AA");
Person p2 = new Person(1002, "BB");
set.add(p1);
set.add(p2);
System.out.println(set);
p1.name = "CC";
System.out.println(set);
set.remove(p1);
System.out.println(set);
set.add(new Person(1001, "CC"));
System.out.println(set);
set.add(new Person(1001, "AA"));
System.out.println(set);
    }
}

class Person {
    int id;
    String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
