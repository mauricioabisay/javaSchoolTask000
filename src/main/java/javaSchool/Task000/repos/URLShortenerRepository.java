package javaSchool.Task000.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javaSchool.Task000.entities.URLShortener;

@Repository
public interface URLShortenerRepository extends CrudRepository<URLShortener, String> {
}
