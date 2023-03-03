package com.epam.demo.repository;

import com.epam.demo.entity.Identity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRepository extends CrudRepository<Identity, Long> {

}
