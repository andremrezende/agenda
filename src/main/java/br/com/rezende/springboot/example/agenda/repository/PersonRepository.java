package br.com.rezende.springboot.example.agenda.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rezende.springboot.example.agenda.model.PersonForm;

/**
 * 
 * @author Andre Rezende
 *
 */
public interface PersonRepository extends CrudRepository<PersonForm, Long> {

}
