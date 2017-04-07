package es.apba.oper.practicas.ejercicio_spring_boot.service;

import es.apba.oper.practicas.ejercicio_spring_boot.domain.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShipRepository extends CrudRepository<Ship, Long> {
}
