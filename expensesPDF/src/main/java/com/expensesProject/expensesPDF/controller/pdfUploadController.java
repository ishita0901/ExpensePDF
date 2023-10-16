package com.expensesProject.expensesPDF.controller;

import com.expensesProject.expensesPDF.model.Expense;
import com.expensesProject.expensesPDF.service.expenseService;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class pdfUploadController {

    @PostMapping("/pdf-upload")
    public ResponseEntity<String> uploadPDF(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("PDF file is empty.", HttpStatus.BAD_REQUEST);
        }
        // Implement PDF processing logic here
        // You can use a library like Apache PDFBox to extract data

        try {
            String extractedText = extractTextFromPDF(file);

            Expense Expense = parsePDFText(extractedText);

            // Save the parsed data to the database
            Expense = expenseService.createExpense(Expense);

            return new ResponseEntity<>("PDF data saved successfully.", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PDF processing error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Expense parsePDFText(String pdfText) {
        Expense expense = new Expense();
        String travelValue = "";
        String foodValue = "";
        String totalValue = "";

        // Parse text to find travel, food, and total expense values
        String[] lines = pdfText.split("\\r?\\n");

        for (String line : lines) {
            if (line.contains("Travel:")) {
                travelValue = line.replaceAll("[^0-9.]", "");
                expense.setTravel(Double.parseDouble(travelValue));
            } else if (line.contains("Food:")) {
                foodValue = line.replaceAll("[^0-9.]", "");
                expense.setFood(Double.parseDouble(foodValue));
            } else if (line.contains("Total:")) {
                totalValue = line.replaceAll("[^0-9.]", "");
                expense.setTotal(Double.parseDouble(totalValue));
            }
        }
        return expense;
    }

    private String extractTextFromPDF(MultipartFile file) throws IOException {
        try (PDDocument document = Loader.loadPDF((RandomAccessRead) file.getInputStream())) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
}

