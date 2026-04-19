# 🚀 ApiGuard — API Monitoring Platform

ApiGuard is a backend-focused monitoring system that continuously checks the **availability, performance, and reliability of APIs**.

It automatically monitors APIs at scheduled intervals, stores performance metrics, detects failures, and generates alerts to ensure system uptime.

---

# 🎯 Problem Statement

Modern applications depend on multiple internal and third-party APIs.  
If an API becomes slow or unavailable, it can break application functionality.

Manual monitoring is:

- Not scalable  
- Error-prone  
- Inefficient  

Hence, an automated API monitoring platform is required.

---

# ✅ Solution

ApiSentinel provides:

- Centralized API monitoring  
- Scheduled health checks  
- Response time tracking  
- Failure detection  
- Alert generation  
- Performance analytics  

---

# 🏗️ High Level Architecture

```
                +------------------+
                |     Frontend     |
                |     (React)      |
                +--------+---------+
                         |
                         | REST APIs
                         |
                +--------v---------+
                |   Spring Boot    |
                |     Backend      |
                +---+----+----+----+
                    |    |    |
                    |    |    |
        +-----------+    |    +-----------+
        |                |                |
+-------v------+   +-----v------+   +-----v------+
| Scheduler    |   | Alert Engine|   | Analytics  |
| Engine       |   |             |   | Service    |
+-------+------+   +------+------ +   +-----+------+
        |                 |                |
        |                 |                |
        |          +------v------+         |
        |          | Notification|         |
        |          | (Email etc) |         |
        |          +-------------+         |
        |                                   |
+-------v-----------------------------------v------+
|                PostgreSQL Database               |
+--------------------------------------------------+
```

---

# 🔄 Complete Working Flow

## User Flow

1. User registers API  
2. API configuration stored in database  
3. User views logs and analytics  
4. User configures alert thresholds  

## Monitoring Flow (Core System Flow)

```
Scheduler starts job
       ↓
Fetch all APIs from database
       ↓
Send HTTP request
       ↓
Measure response time
       ↓
Store metrics
       ↓
Evaluate alert rules
       ↓
Generate notification
```

---

# 🗄️ Database Design

## APIs Table

| Field | Type |
|------|------|
id | UUID |
name | varchar |
url | text |
method | varchar |
interval_seconds | int |
timeout | int |
created_at | timestamp |

## Metrics Table (High Volume Table)

| Field | Type |
|------|------|
id | UUID |
api_id | FK |
response_time | bigint |
status_code | int |
success | boolean |
checked_at | timestamp |

## Alerts Table

| Field | Type |
|------|------|
id | UUID |
api_id | FK |
message | text |
severity | varchar |
created_at | timestamp |
resolved | boolean |

---

# 📂 Backend Folder Structure

```
com.apisentinel
│
├── controller
├── service
├── repository
├── entity
├── scheduler
├── alert
├── analytics
├── dto
├── config
└── util
```

---

# ⚙️ Development Steps (Start → End)

## STEP 1 — Project Setup

- Create Spring Boot project
- Add dependencies:
  - Spring Web
  - Spring Data JPA
  - PostgreSQL Driver
  - Lombok
  - Validation
  - Scheduler

---

## STEP 2 — Configure PostgreSQL

Create database:

```
CREATE DATABASE apisentinel;
```

Update application.properties.

---

## STEP 3 — Create Entity Layer

- ApiEntity  
- MetricEntity  
- AlertEntity  

---

## STEP 4 — Create Repository Layer

- ApiRepository  
- MetricRepository  
- AlertRepository  

---

## STEP 5 — Build CRUD APIs

```
POST /apis
GET /apis
PUT /apis/{id}
DELETE /apis/{id}
```

---

## STEP 6 — Build Monitoring Scheduler (Core Feature)

Scheduler runs periodically:

```
@Scheduled(fixedDelay = 30000)
```

Logic:

```
Fetch APIs
Call API
Measure latency
Save metric
Check alert rules
```

---

# 🔁 Retry Algorithm (Exponential Backoff)

If API fails:

```
Retry 1 → wait 2 sec
Retry 2 → wait 4 sec
Retry 3 → wait 8 sec
```

---

# 🚨 Alert Detection Logic

Alert triggers when:

- API is DOWN  
- Response time exceeds threshold  
- Continuous failures detected  

---

# 📊 Analytics APIs

```
GET /analytics/uptime/{apiId}
GET /analytics/latency/{apiId}
GET /analytics/failures/{apiId}
```

These power frontend charts.

---

# ⚡ Performance Optimization

## Redis Cache

Used for:

- Caching API configurations  
- Reducing database load  

## Message Queue (Advanced)

Kafka / RabbitMQ:

```
Scheduler → Queue → Worker → Process → Save Metrics
```

Improves scalability.

---

# 🧪 Testing Strategy

- Test APIs using Postman  
- Simulate API failure  
- Simulate high latency  
- Test invalid URLs  
- Test timeout cases  

---

# 🎨 Frontend Integration (After Backend Ready)

Build screens:

- Dashboard  
- API Management  
- Logs  
- Alerts  
- Analytics  

Frontend consumes backend REST APIs.

---

# 🐳 Deployment Architecture

```
Docker Container → Spring Boot App
Docker Container → PostgreSQL
Docker Container → Redis
```

Deploy on:

- AWS
- Render
- Railway

---

# 🔮 Future Scope

- Distributed monitoring agents  
- Real-time WebSocket alerts  
- AI-based failure prediction  
- Multi-tenant SaaS platform  
- SLA reporting dashboards  

---

# ✅ Conclusion

ApiSentinel ensures **high API reliability** through automated monitoring, failure detection, and performance analytics.

This project demonstrates:

- Backend system design  
- Scheduler architecture  
- Retry algorithms  
- Alert engineering  
- Database optimization  
- Scalable monitoring system  

---

## 👨‍💻 Author

Ayush Waghale
Backend Developer — Spring Boot | MERN
