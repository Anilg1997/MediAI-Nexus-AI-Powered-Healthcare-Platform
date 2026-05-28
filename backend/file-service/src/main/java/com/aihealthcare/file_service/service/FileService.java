package com.aihealthcare.file_service.service;

import com.aihealthcare.file_service.entity.MedicalFile;

import com.aihealthcare.file_service.kafka.FileKafkaProducer;

import com.aihealthcare.file_service.repository.MedicalFileRepository;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.io.IOException;

import java.time.LocalDate;

import java.util.List;

@Service
public class FileService {

    @Value("${file.upload-dir}")

    private String uploadDir;

    private final MedicalFileRepository
            repository;

    private final FileKafkaProducer
            kafkaProducer;

    public FileService(

            MedicalFileRepository repository,

            FileKafkaProducer kafkaProducer) {

        this.repository =
                repository;

        this.kafkaProducer =
                kafkaProducer;
    }

    public MedicalFile uploadFile(

            Long patientId,

            MultipartFile file)

            throws IOException {

        File dir =
                new File(uploadDir);

        if (!dir.exists()) {

            dir.mkdirs();
        }

        String filePath =
                uploadDir + "/"
                        + file.getOriginalFilename();

        file.transferTo(
                new File(filePath));

        MedicalFile medicalFile =
                new MedicalFile();

        medicalFile.setPatientId(
                patientId);

        medicalFile.setFileName(
                file.getOriginalFilename());

        medicalFile.setFileType(
                file.getContentType());

        medicalFile.setFilePath(
                filePath);

        medicalFile.setUploadedDate(
                LocalDate.now().toString());

        MedicalFile saved =
                repository.save(
                        medicalFile);

        kafkaProducer.sendFileEvent(

                "Medical File Uploaded For Patient ID: "

                        + patientId);

        return saved;
    }

    public List<MedicalFile> getAllFiles() {

        return repository.findAll();
    }
}