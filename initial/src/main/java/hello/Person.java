package hello;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Getter;

// The application autowires an instance of PersonRepository that you just defined. Spring Data for Pivotal Gemfire will dynamically create a concrete class that implements this interface and plug in the needed query code to meet the interface's obligations. This Repository instance is then used by the run() method to demonstrate the functionality.
@Region(value = "People")
public class Person implements Serializable {

    @Id
    @Getter
    private final String name;

    @Getter
    private final int age;

    @PersistenceConstructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s is %d years old", getName(), getAge());
    }

}

