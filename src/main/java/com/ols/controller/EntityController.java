package com.ols.controller;

import com.ols.data.entities.EntityImpl;
import com.ols.data.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/entity")
public class EntityController {

  @Autowired
  private EntityRepository entityRepository;

  @RequestMapping(path = "", method = RequestMethod.POST)
  @ResponseBody public EntityImpl newEntity(@Valid @RequestBody EntityImpl entity) {

    entityRepository.save(entity);

    return entity;
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  @ResponseBody public EntityImpl getEntity(@PathVariable long id) {

    return entityRepository.findById(id).get(); // TODO: 2019-03-25 Handle no such element exception

  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
  @ResponseBody public EntityImpl updateEntity(@PathVariable long id,
                                           @Valid @RequestBody EntityImpl entity) {

    entity.setId(id);
    entityRepository.save(entity);

    return entity;
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
  @ResponseBody public String removeEntity(@PathVariable long id) {

    entityRepository.deleteById(id);

    return "success";
  }

  @RequestMapping(path = "", method = RequestMethod.GET)
  @ResponseBody public Iterable<EntityImpl> listEntities() {
    return entityRepository.findAll();
  }


}
