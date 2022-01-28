package com.ss.jpasimpleproject.jpa;

import com.ss.jpasimpleproject.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    //connect to DB
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class,id);
    };
    //using JPQL
    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    };

    //create a person
    public Person insert(Person person) {
        return entityManager.merge(person);
    };

    //update a person
    public Person update(Person person) {
        return entityManager.merge(person);
    };

    //delete a person
    public void deleteById(int id) {
        //JPA has to know the deleted object before delete it
        Person person = findById(id);
        entityManager.remove(person);
    };

}
