package com.expensesProject.expensesPDF.test;

import org.apache.pdfbox.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.InputStream;

@WebMvcTest
@AutoConfigureMockMvc
public class pdfUploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @org.junit.Test
    @Test
    public void testUploadPDF() throws Exception {
        // Load the content of a test PDF file
        InputStream inputStream = getClass().getResourceAsStream("/expense_report.pdf");
        byte[] fileContent = IOUtils.toByteArray(inputStream);

        mockMvc.perform(MockMvcRequestBuilders
                        .multipart("/pdf-upload")
                        .file("file", fileContent))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
