package es.apba.oper.practicas.ejercicio_spring_boot.service;

import es.apba.oper.practicas.ejercicio_spring_boot.domain.ShipType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShipTypeRepository extends CrudRepository<ShipType, String> {
}
