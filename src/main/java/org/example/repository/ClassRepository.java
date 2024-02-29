package org.example.repository;

import org.example.entities.Class;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassRepository extends MongoRepository <Class, String> {
}
