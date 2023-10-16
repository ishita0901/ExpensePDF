## Introduction

This project is a Spring Boot application that allows users to upload their expense PDFs and details (such as travel and food expenses) and claim those expenses for reimbursement from the company. The application also provides REST APIs for managing and retrieving expense data, with MySQL used as the database for storing this information.

The project follows a three-tier architecture, with components divided into Controller, Service, and Repository layers

## Technologies Used
- Spring Boot: To build the application and create REST APIs.
- MySQL: To store expense data in a relational database.
- Hibernate: For object-relational mapping and database interactions.
- Spring Security: To secure the application and authenticate users.
- PDF Processing Library (e.g., Apache PDFBox): For parsing and extracting data from uploaded PDF files.
- Maven: For project management and dependency resolution.
