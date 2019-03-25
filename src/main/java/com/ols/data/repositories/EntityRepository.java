package com.ols.data.repositories;

import com.ols.data.entities.EntityImpl;
import org.springframework.data.repository.CrudRepository;

public interface EntityRepository extends CrudRepository<EntityImpl, Long> { }
