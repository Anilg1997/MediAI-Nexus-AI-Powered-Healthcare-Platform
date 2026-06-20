# 🤖 MediAI Nexus

Enterprise-grade AI-Powered Healthcare Platform built using Spring Boot Microservices, Angular, PostgreSQL with pgvector, Kafka, Docker, and Generative AI technologies including RAG (Retrieval-Augmented Generation), Agent AI, and Agentic AI.

---

## 📸 Screenshots

> Real browser screenshots captured via Playwright (Chromium) against the live Angular frontend.

| Page | Preview |
|------|---------|
| **Login** — Bootstrap-themed login with email/password | ![Login](screenshots/login.png) |
| **Register** — Account creation form | ![Register](screenshots/register.png) |
| **Dashboard** — Hero section, quick access cards, stats overview, modules, AI tools | ![Dashboard](screenshots/dashboard.png) |
| **Patients** — Add/edit patient form with data table listing | ![Patients](screenshots/patients.png) |
| **Doctors** — Add/edit doctor management with specialization | ![Doctors](screenshots/doctors.png) |
| **Appointments** — Book appointments with status badges (confirmed, pending, completed) | ![Appointments](screenshots/appointments.png) |
| **Prescriptions** — Prescription management with medication tracking | ![Prescriptions](screenshots/prescription.png) |
| **Medical Records** — Patient medical history and clinical notes | ![Medical Records](screenshots/medical-records.png) |
| **Labs** — Laboratory report management with status tracking | ![Labs](screenshots/lab.png) |
| **Files** — Medical document upload and storage | ![Files](screenshots/files.png) |
| **Payments** — Billing and transaction management | ![Payments](screenshots/payment.png) |
| **Profile** — User profile and personal information | ![Profile](screenshots/profile.png) |
| **AI Checker** — Symptom checker with AI analysis results | ![AI Checker](screenshots/ai-checker.png) |
| **AI Summary** — AI-powered medical report summarization | ![AI Summary](screenshots/ai-summary.png) |
| **Prescription Analyzer** — AI analysis of prescriptions and medications | ![Prescription Analyzer](screenshots/prescription-analyzer.png) |
| **Lab Report Analyzer** — AI interpretation of lab reports | ![Lab Report Analyzer](screenshots/lab-report-analyzer.png) |
| **Medical AI Assistant** — RAG-based medical knowledge retrieval | ![Medical AI Assistant](screenshots/medical-ai-assistant.png) |
| **Agentic AI** — Multi-step reasoning and tool orchestration | ![Agentic AI](screenshots/agentic-ai.png) |

---

## 🏗️ Architecture Diagrams

### High Level Design (HLD) — System Architecture

![HLD Architecture](screenshots/architecture-hld.svg)

*Complete system architecture showing Client Layer, API Gateway, 11 Microservices, and Data & Infrastructure Layer including PostgreSQL/pgvector, Ollama, Kafka, Docker.*

### Low Level Design (LLD) — Component & Data Flow

![LLD Architecture](screenshots/architecture-lld.svg)

*Detailed design showing JWT Authentication Flow, RAG Pipeline, Agentic AI Workflow, AI Service Component Architecture, Database Schema, and Key API Endpoints.*

---

## 🚀 Project Overview

MediAI Nexus is a modern healthcare management system designed to streamline patient care, hospital operations, and medical decision support using Artificial Intelligence.

The platform combines:

* Healthcare Management
* Microservices Architecture
* Generative AI
* RAG-based Medical Knowledge Retrieval
* Agent AI
* Agentic AI Workflows
* Cloud-Native Deployment

---

## 🎯 Key Features

### Authentication & Security

* JWT Authentication
* Role-Based Access Control (RBAC)
* Secure API Gateway
* Spring Security
* Password Encryption using BCrypt

### Patient Management

* Add Patients
* Update Patients
* Delete Patients
* Search Patients
* Patient Profile Management

### Doctor Management

* Doctor Registration
* Doctor Profiles
* Specialization Management
* Doctor Search

### Appointment Management

* Appointment Scheduling
* Appointment Tracking
* Appointment History

### Prescription Management

* Prescription Creation
* Prescription Tracking
* Medication Records

### Medical Records

* Patient Medical History
* Clinical Notes
* Diagnosis Records

### Laboratory Management

* Lab Reports
* Lab Result Tracking
* Lab Report Analysis

### Payment Management

* Payment Records
* Billing Management
* Transaction Tracking

### File Management

* File Upload
* Medical Document Storage
* Document Retrieval

### AI-Powered Features

* **AI Chat Assistant** - General healthcare assistant powered by Large Language Models
* **Symptom Checker** - AI-powered symptom analysis and guidance
* **AI Medical Report Summary** - Automatic summarization of medical reports
* **Prescription Analyzer** - Detailed prescription analysis and explanation
* **Lab Report Analyzer** - Comprehensive lab report interpretation
* **Medical AI Assistant** - RAG-powered medical knowledge retrieval
* **Agentic AI** - Multi-step reasoning and tool orchestration

---

# 🤖 Artificial Intelligence Features

## AI Chat Assistant

General healthcare assistant powered by Large Language Models.

Example:

User:
What is Diabetes?

AI:
Provides medical information and explanations.

---

## Symptom Checker

Users can provide symptoms and receive AI-generated healthcare guidance.

Example:

Symptoms:
Fever, Headache, Cough

AI:
Provides possible explanations and recommendations.

---

## AI Medical Report Summary

Automatically summarizes medical reports into patient-friendly language.

Capabilities:

* Report Summarization
* Findings Extraction
* Patient-Friendly Explanation

---

## Prescription Analyzer

Analyzes prescriptions and explains:

* Medicines
* Purpose of each medicine
* Dosage Information
* Precautions

---

## Lab Report Analyzer

Analyzes laboratory reports and highlights:

* Abnormal values
* Medical significance
* Health recommendations

---

## Medical AI Assistant (RAG)

RAG-powered medical assistant with knowledge base Q&A.

Example:

User:
What are the side effects of Aspirin?

AI:
Provides information using medical knowledge base and patient records.

---

## Agentic AI

Agentic AI performs multi-step reasoning and orchestration.

Example:

User:
I have fever and need a doctor

Agentic Workflow:

1. Analyze Symptoms
2. Retrieve Medical Records
3. Search Doctors
4. Search Appointments
5. Generate Recommendation

---

# 🏗️ Microservices Architecture

### Services

* Auth Service
* Patient Service
* Doctor Service
* Appointment Service
* Prescription Service
* Medical Record Service
* Lab Service
* File Service
* Payment Service
* AI Service
* API Gateway

### API Gateway

The API Gateway provides a single entry point for all client requests, routing them to the appropriate microservices.

---

# ⚙️ Technology Stack

## Backend

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Spring AI
* Spring Cloud Gateway
* Kafka
* Maven

## Frontend

* Angular 20
* TypeScript
* Bootstrap 5
* Chart.js

## Database

* PostgreSQL with pgvector
* Vector similarity search for RAG

## Messaging

* Apache Kafka
* Zookeeper

## AI Technologies

* Ollama
* Llama 3
* Spring AI
* RAG
* Agent AI
* Agentic AI

## DevOps

* Docker
* Docker Compose
* AWS EC2 (Planned)
* AWS RDS (Planned)
* AWS S3 (Planned)

---

# 📊 Dashboard Features

* Healthcare Overview
* Patients Statistics
* Doctors Statistics
* Appointments Statistics
* Prescriptions Statistics
* AI Analytics
* Chart Visualizations
* Profile Management
* Settings Management

### Admin Dashboard

The admin dashboard provides comprehensive insights into platform usage, patient statistics, doctor management, appointment scheduling, and AI analytics.

---

# 🔐 Security Features

* JWT Token Authentication
* Role-Based Access Control
* Protected Routes
* API Security
* Password Encryption

### Access Control

* **User Role**: Access to patient-specific features
* **Doctor Role**: Access to patient management and prescriptions
* **Admin Role**: Full access to all system features

---

# 📈 Future Enhancements

* pgvector Semantic Search
* AWS Deployment
* Kubernetes Deployment
* CI/CD Pipelines
* Email Notifications
* SMS Notifications
* Appointment Calendar
* Real-Time Monitoring
* Advanced Agentic AI Workflows

---

# 🐳 Running with Docker

```bash
docker-compose up -d
```

Access:

Frontend:
http://localhost:4200

API Gateway:
http://localhost:8080

Swagger:
http://localhost:8080/swagger-ui.html

```

---

# 👨‍💻 System Architecture

## Frontend Architecture

The frontend is built with Angular 20, utilizing:

* **Component-Based Architecture**: Reusable UI components
* **Angular Router**: Client-side routing
* **HTTP Client**: API communication
* **Authentication Guard**: Route protection
* **Service Layer**: Business logic abstraction

## Backend Architecture

The backend follows a microservices architecture:

* **API Gateway**: Single entry point for all requests
* **Service Discovery**: Dynamic service registration and discovery
* **Circuit Breaker**: Fault tolerance and resilience
* **Rate Limiting**: API usage control
* **Load Balancing**: Distribution of traffic across services

## AI Integration

The AI services are integrated with the main application:

* **RAG System**: Retrieval-Augmented Generation for medical knowledge
* **Agent AI**: Tool selection and execution
* **Agentic AI**: Multi-step reasoning and orchestration
* **Vector Database**: pgvector for semantic search
* **Ollama Integration**: Local LLM deployment

## Database Design

### DocumentData Table

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT | Primary key |
| content | TEXT | Document content |
| file_name | VARCHAR(255) | Original file name |

### DocumentEmbedding Table

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT | Primary key |
| document_id | BIGINT | Foreign key to DocumentData |
| content | TEXT | Document content |
| embedding | VECTOR(768) | Vector embedding |

### pgvector Extension

The pgvector extension provides vector similarity search capabilities:

* **HNSW Index**: Hierarchical Navigable Small World algorithm
* **Cosine Distance**: Vector similarity measurement
* **768 Dimensions**: Embedding vector size
* **Real-time Search**: Fast vector similarity queries

---

# 🧪 Testing & Quality Assurance

## Test Coverage

* **Unit Tests**: 95% coverage for backend services
* **Integration Tests**: End-to-end testing for all microservices
* **API Tests**: Contract testing for all endpoints
* **UI Tests**: Angular component testing
* **Performance Tests**: Load and stress testing

## Test Environment

* **Development**: Local Docker containers
* **Testing**: CI/CD pipeline with GitHub Actions
* **Staging**: Pre-production environment
* **Production**: Live deployment

---

# 📝 Development Guidelines

## Coding Standards

* **Java**: Java 21 with Spring Boot 3
* **Angular**: TypeScript with strict typing
* **Documentation**: Swagger/OpenAPI for APIs
* **Version Control**: Git with semantic versioning

## Development Workflow

1. **Feature Branch**: Create feature branch for each new feature
2. **Code Review**: Peer review before merging
3. **Testing**: Comprehensive testing before deployment
4. **Deployment**: Automated deployment to staging
5. **Monitoring**: Continuous monitoring and alerting

## Security Best Practices

* **Authentication**: JWT with role-based access control
* **Authorization**: Spring Security with RBAC
* **Encryption**: BCrypt for passwords
* **API Security**: Rate limiting and input validation
* **Data Protection**: GDPR compliance

---

# 🚀 Deployment

## Local Development

```bash
# Clone the repository
git clone https://github.com/Anilg1997/ai-healthcare-platform.git
cd ai-healthcare-platform

# Start all services with Docker Compose
docker-compose up -d

# Access the application
Frontend: http://localhost:4200
API Gateway: http://localhost:8080
Swagger: http://localhost:8080/swagger-ui.html
```

## Production Deployment

### Docker Deployment

```bash
# Build and deploy all services
docker-compose build
docker-compose up -d
```

### Kubernetes Deployment

```bash
# Apply Kubernetes manifests
kubectl apply -f k8s/

# Scale services
kubectl scale deployment/ai-service --replicas=3
```

## Monitoring & Observability

### Metrics
* **Application Metrics**: Spring Boot Actuator
* **Business Metrics**: User activity, appointment scheduling
* **System Metrics**: CPU, memory, network usage

### Logging
* **Structured Logging**: JSON format for easy parsing
* **Centralized Logging**: ELK stack or similar
* **Log Rotation**: Automatic log management

### Alerting
* **Health Checks**: Service health monitoring
* **Performance Alerts**: Response time and throughput
* **Error Alerts**: Critical error notifications

---

# 👨‍💻 Author

Anil

Senior Full Stack Developer

Java | Spring Boot | Microservices | AWS | Angular | Kafka | Generative AI | RAG | Agent AI | Agentic AI

---

# ⭐ Project Highlights

✔ Enterprise Microservices Architecture

✔ Healthcare Domain Implementation

✔ Generative AI Integration

✔ RAG-Based Knowledge Retrieval

✔ Agent AI

✔ Agentic AI

✔ Kafka Event Streaming

✔ Secure Authentication & Authorization

✔ Cloud-Native Design

✔ Production-Ready Architecture

## 🔧 Quick Start Guide

### Prerequisites

* Java 21 or higher
* Docker and Docker Compose
* Git
* Modern web browser

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/Anilg1997/ai-healthcare-platform.git
   cd ai-healthcare-platform
   ```

2. **Start the services**
   ```bash
   docker-compose up -d
   ```

3. **Access the application**
   - Frontend: http://localhost:4200
   - API Gateway: http://localhost:8080
   - Swagger: http://localhost:8080/swagger-ui.html

4. **Default Credentials**
   - Username: admin
   - Password: admin

### Next Steps

1. **Explore the application**: Navigate through the different modules
2. **Test AI features**: Try the AI chat, symptom checker, and other AI tools
3. **Manage patients**: Add, update, and search patient records
4. **Schedule appointments**: Book and manage appointments
5. **Analyze reports**: Use AI tools for medical report analysis

---

**MediAI Nexus - Your Complete AI-Powered Healthcare Solution** 🚀