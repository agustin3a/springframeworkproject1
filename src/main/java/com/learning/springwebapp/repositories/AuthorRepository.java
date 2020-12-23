package com.learning.springwebapp.repositories;

import com.learning.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {



}
