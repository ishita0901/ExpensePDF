package com.expensesProject.expensesPDF;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class generatePDF {

        public static void main(String[] args) {
            Document document = new Document();

            try {
                PdfWriter.getInstance(document, new FileOutputStream("expense_report.pdf"));
                document.open();

                // Add the content to the PDF
                document.add(new Paragraph("Expense Report"));
                document.add(new Paragraph("Travel: $500.00"));
                document.add(new Paragraph("Food: $200.00"));
                document.add(new Paragraph("Claim Total: $700.00"));

                document.close();

                System.out.println("Expense report PDF generated successfully.");
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }
        }
    }
