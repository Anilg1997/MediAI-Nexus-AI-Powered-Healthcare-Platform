package com.aihealthcare.ai_service.controller;

import com.aihealthcare.ai_service.service.PdfExtractionService;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/pdf")

public class PdfController {

    private final PdfExtractionService
            pdfService;

    public PdfController(
            PdfExtractionService pdfService) {

        this.pdfService =
                pdfService;
    }

    @GetMapping("/read")

    public String readPdf(

            @RequestParam
            String path)

            throws Exception {

        return pdfService.extractText(
                path);
    }
}