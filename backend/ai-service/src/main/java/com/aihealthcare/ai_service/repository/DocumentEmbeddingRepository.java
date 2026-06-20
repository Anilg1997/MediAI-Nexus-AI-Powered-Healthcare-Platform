package com.aihealthcare.ai_service.repository;

import com.aihealthcare.ai_service.entity.DocumentEmbedding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DocumentEmbeddingRepository
        extends JpaRepository<DocumentEmbedding, Long> {

    List<DocumentEmbedding> findTop5ByOrderByIdDesc();

    @Query(value = """
        SELECT * FROM document_embeddings
        ORDER BY embedding <=> CAST(:query(ST(:embedding AS vector(768)))
        LIMIT :limit
        """, nativeQuery = true)
    List<DocumentEmbedding> findSimilarEmbeddings(@Param("embedding") float[] embedding, @Param("limit") int limit);
}