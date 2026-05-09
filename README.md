# 🔐 Spring Security Demo Application

A production-style Spring Boot application demonstrating modern Spring Security concepts including authentication, authorization, CSRF protection, REST APIs, secure endpoints, and layered architecture.

---

# 🚀 Tech Stack

- Java 21+
- Spring Boot 3 / 4
- Spring Security 6 / 7
- Spring Web
- Maven
- RESTful APIs
- Lombok
- Jackson
- Postman

---

# 📌 Features

✅ Spring Security Integration  
✅ Authentication & Authorization  
✅ CSRF Protection  
✅ REST APIs  
✅ Secure Endpoints  
✅ Layered Architecture  
✅ Clean Code Structure  
✅ Production-Level Folder Organization  
✅ API Testing Ready  
✅ JSON Request/Response Handling

---

# 📂 Project Structure

```bash
spring-security-demo/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── itstech/
│   │   │           └── dharm/
│   │   │               └── springsecuritydemo/
│   │   │
│   │   │                   ├── SpringSecurityDemoApplication.java
│   │   │                   │
│   │   │                   ├── config/
│   │   │                   │   ├── SecurityConfig.java
│   │   │                   │   └── CorsConfig.java
│   │   │                   │
│   │   │                   ├── controller/
│   │   │                   │   ├── HomeController.java
│   │   │                   │   ├── AuthController.java
│   │   │                   │   └── StudentController.java
│   │   │                   │
│   │   │                   ├── service/
│   │   │                   │   ├── StudentService.java
│   │   │                   │   └── AuthService.java
│   │   │                   │
│   │   │                   ├── repository/
│   │   │                   │   └── StudentRepository.java
│   │   │                   │
│   │   │                   ├── model/
│   │   │                   │   ├── Student.java
│   │   │                   │   ├── User.java
│   │   │                   │   └── Role.java
│   │   │                   │
│   │   │                   ├── dto/
│   │   │                   │   ├── LoginRequest.java
│   │   │                   │   └── AuthResponse.java
│   │   │                   │
│   │   │                   ├── exception/
│   │   │                   │   ├── GlobalExceptionHandler.java
│   │   │                   │   └── ResourceNotFoundException.java
│   │   │                   │
│   │   │                   ├── security/
│   │   │                   │   ├── JwtFilter.java
│   │   │                   │   ├── JwtService.java
│   │   │                   │   └── CustomUserDetailsService.java
│   │   │                   │
│   │   │                   └── util/
│   │   │                       └── AppConstants.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── itstech/
│                   └── dharm/
│                       └── springsecuritydemo/
│                           └── SpringSecurityDemoApplicationTests.java
│
├── .gitignore
├── .gitattributes
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

# ⚙️ Installation & Setup

## 1️⃣ Clone Repository

```bash
git clone https://github.com/dharmendra9847/spring-security.git
cd spring-security
```

---

## 2️⃣ Open Project

Open project in:

- IntelliJ IDEA
- VS Code
- Spring Tool Suite

---

## 3️⃣ Run Application

```bash
./mvnw spring-boot:run
```

OR

```bash
mvn spring-boot:run
```

---

# 🌐 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/students` | Fetch all students |
| POST | `/student` | Add new student |
| GET | `/csrf-token` | Generate CSRF token |

---

# 🔐 CSRF Example

## Get Token

```http
GET /csrf-token
```

---

## Add Header

```http
X-CSRF-TOKEN: your_token
```

---

# 📦 Sample Request

```json
{
  "id": 106,
  "name": "Karan Mehta",
  "tech": "Spring AI"
}
```

---

# 🛡️ Security Concepts Covered

- Authentication
- Authorization
- CSRF Protection
- Session Management
- Stateless APIs
- JWT Authentication
- Role-Based Access Control
- Password Encoding
- Secure REST APIs

---

# 🧪 Testing APIs

Recommended Tools:

- Postman
- Thunder Client
- Insomnia

---

# 📖 Future Enhancements

✅ JWT Authentication  
✅ OAuth2 Login  
✅ Refresh Tokens  
✅ MySQL/PostgreSQL Integration  
✅ Docker Support  
✅ Kubernetes Deployment  
✅ Microservices Security  
✅ Spring Cloud Gateway  
✅ Redis Session Management

---

# 👨‍💻 Author

Dharmendra Kumar

---

# ⭐ Project Goal

This project is designed to demonstrate enterprise-level Spring Security implementation using modern backend development practices.

It is ideal for:
- Learning Spring Security
- Backend Development
- Production Architecture
- Interview Preparation
- Real-World REST API Security
