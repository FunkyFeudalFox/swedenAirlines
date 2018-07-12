package com.capgemini.swedenairlines.model.persistence;

import com.capgemini.swedenairlines.model.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepo extends CrudRepository<Airplane, Long> {

}
