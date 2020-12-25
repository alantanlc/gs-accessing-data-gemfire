package hello;

import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

    // Because the query methods (e.g. findByName) are annotated with SDG's @Trace annotation, this turns on Pivotal GemFire's OQL query tracing (query-level logging), which shows you the generated OQL, execution time, whether any Pivotal GemFire Indexed were used by the query together the results, and the number of rows returned by the query.
    @Trace
    Person findByName(String name);

    @Trace
    Iterable<Person> findByAgeGreaterThan(int age);

    @Trace
    Iterable<Person> findByAgeLessThan(int age);

    @Trace
    Iterable<Person> findByAgeGreaterThanAndAgeLessThan(int greaterThanAge, int lessThanAge);

}

