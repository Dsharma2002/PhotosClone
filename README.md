
A simple Spring Boot application that allows users to **upload**, **store**, **list**, **download**, and **delete photos** via a RESTful API. This project demonstrates key concepts such as file handling, Spring Data JPA, H2 database usage, and clean controller-service-repository architecture — ideal for learning backend development with Spring Boot.

- ✅ Upload photo files (`MultipartFile`) via REST or HTML form
- ✅ Store metadata (filename, type) and file content in an H2 database
- ✅ Retrieve and download files by ID
- ✅ View all uploaded files
- ✅ Delete files
- ✅ Graceful error handling (404, 500)
- ✅ Auto-generated schema using JPA entities
- ✅ Embedded H2 console for dev inspection

## 🧪 Technologies Used

| Tech           | Purpose                              |
|----------------|---------------------------------------|
| Spring Boot    | Rapid backend development             |
| Spring Web     | REST controller and form handling     |
| Spring Data JPA| ORM-based persistence of Photo entity |
| H2             | Lightweight, in-memory/file database  |
| Maven          | Build and dependency management       |
| HTML           | File upload UI interface              |

## 🚀 Getting Started

### 🔨 Prerequisites
- Java 17+ or Java 21/Java 24 (your current version is fine)
- Maven 3.9+
- Git

### 🛠️ Run the project

Clone the repository:
```bash
git clone https://github.com/Dsharma2002/PhotosClone.git
cd PhotosClone
mvn spring-boot:run

