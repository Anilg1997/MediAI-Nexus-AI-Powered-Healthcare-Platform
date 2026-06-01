package com.aihealthcare.ai_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "document_data")
public class DocumentData {

    @Id
    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY)

    private Long id;

    @Column(
            columnDefinition = "TEXT")

    private String content;

    private String fileName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(
            String content) {

        this.content =
                content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(
            String fileName) {

        this.fileName =
                fileName;
    }
}