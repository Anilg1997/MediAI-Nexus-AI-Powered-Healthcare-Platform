package com.aihealthcare.file_service.controller;

import com.aihealthcare.file_service.entity.MedicalFile;

import com.aihealthcare.file_service.service.FileService;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;

@RestController

@RequestMapping("/api/files")

@CrossOrigin(origins =
        "http://localhost:4200")

public class FileController {

    private final FileService
            fileService;

    public FileController(
            FileService fileService) {

        this.fileService =
                fileService;
    }

    @PostMapping("/upload")

    public MedicalFile uploadFile(

            @RequestParam Long patientId,

            @RequestParam MultipartFile file)

            throws IOException {

        return fileService.uploadFile(
                patientId,
                file);
    }

    @GetMapping

    public List<MedicalFile> getAllFiles() {

        return fileService.getAllFiles();
    }
}