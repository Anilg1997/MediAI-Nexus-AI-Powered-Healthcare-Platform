package com.aihealthcare.ai_service.repository;

import com.aihealthcare.ai_service.entity.DocumentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentData, Long> {
}