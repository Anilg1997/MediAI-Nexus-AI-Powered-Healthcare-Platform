package com.aihealthcare.ai_service.repository;

import com.aihealthcare.ai_service.entity.DocumentEmbedding;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentEmbeddingRepository
        extends JpaRepository<
        DocumentEmbedding,
        Long> {

    List<DocumentEmbedding>
    findTop5ByOrderByIdDesc();


}
