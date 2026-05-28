package com.aihealthcare.file_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_files")
public class MedicalFile {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)

    private Long id;

    private Long patientId;

    private String fileName;

    private String fileType;

    private String filePath;

    private String uploadedDate;

    public MedicalFile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(
            Long patientId) {

        this.patientId =
                patientId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(
            String fileName) {

        this.fileName =
                fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(
            String fileType) {

        this.fileType =
                fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(
            String filePath) {

        this.filePath =
                filePath;
    }

    public String getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(
            String uploadedDate) {

        this.uploadedDate =
                uploadedDate;
    }
}