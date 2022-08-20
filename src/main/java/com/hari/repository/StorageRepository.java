package com.hari.repository;

import com.hari.entity.ImageData;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StorageRepository extends CassandraRepository<ImageData, UUID> {

    @AllowFiltering
    Optional<ImageData> findByName(String name);
}
