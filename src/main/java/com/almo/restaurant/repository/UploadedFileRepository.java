package com.almo.restaurant.repository;

import com.almo.restaurant.entity.UploadedFile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {

}
