package com.github.hugobor.blabu_proju_spring.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends CrudRepository<Platform, Long> {
	public Optional<Platform> findBySimpleName(String simpleName);
}
