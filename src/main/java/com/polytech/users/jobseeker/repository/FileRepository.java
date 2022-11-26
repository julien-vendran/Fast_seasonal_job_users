package com.polytech.users.jobseeker.repository;

import com.polytech.users.jobseeker.entity.FilesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends CrudRepository<FilesEntity, Long> {
}
