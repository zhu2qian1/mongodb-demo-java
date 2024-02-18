package com.example.demo.person;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.demo.ApplicationPaths;

@RepositoryRestResource(collectionResourceRel = ApplicationPaths.People.rel,
        path = ApplicationPaths.People.path)
public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findByLastName(@Param("name") String name);
}
