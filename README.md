# SWYNEX-Database-and-CRUD

**Internship Task 2 – Database and CRUD** (SWYNEX Technologies)

A simple Spring Boot REST API that connects to a **MySQL** database and can
**Create, Read, Update and Delete** (CRUD) student records.

---

## 1. What is this project? (in simple words)

Think of a notebook where you write student names.
- **Create** = write a new student in the notebook
- **Read** = look at the students already written
- **Update** = correct something you wrote
- **Delete** = remove a student

This project does the same thing, but the "notebook" is a **MySQL database** and
we talk to it using **web links (API)** from Postman.

## 2. Technologies used

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot 3.5.7 | Backend framework |
| Eclipse IDE | Writing Java code |
| Maven | Dependency management |
| MySQL | Database |
| Spring Data JPA | Database operations |
| Hibernate | ORM (converts Java objects to database rows) |
| Postman | API testing |
| Git & GitHub | Project submission |

## 3. Project structure

```
SWYNEX-Database-and-CRUD
├── pom.xml                      -> Maven file (list of libraries)
├── database.sql                 -> optional SQL script
├── postman/                     -> ready Postman collection
└── src/main
    ├── java/com/swynex/crud
    │   ├── SwynexCrudApplication.java   -> starts the app
    │   ├── model/Student.java           -> the data (table "students") + validation rules
    │   ├── repository/StudentRepository -> talks to database (no SQL needed)
    │   ├── service/StudentService       -> the logic (check email, find student...)
    │   ├── controller/StudentController -> the API links (URLs)
    │   └── exception/                   -> friendly error messages
    └── resources/application.properties -> database settings
```

**How a request flows:**
`Postman → Controller → Service → Repository → MySQL`

## 4. How to run (step by step)

### Step 1: Install
- Java 17, Eclipse IDE (Enterprise Java), MySQL Server, Postman

### Step 2: Open in Eclipse
`File → Import → Maven → Existing Maven Projects → select this folder → Finish`
(wait until Maven downloads everything)

### Step 3: Set your MySQL password
Open `src/main/resources/application.properties` and change:
```
spring.datasource.username=root
spring.datasource.password=your_mysql_password
```
The database `swynex_db` and the table `students` are created **automatically**.

### Step 4: Run
Right-click `SwynexCrudApplication.java` → `Run As → Java Application`.
When you see `Started SwynexCrudApplication`, the API is live at
`http://localhost:8080`.

## 5. API endpoints

| Action | Method | URL |
|---|---|---|
| Create student | POST | `/api/students` |
| Get all students | GET | `/api/students` |
| Get one student | GET | `/api/students/{id}` |
| Update student | PUT | `/api/students/{id}` |
| Delete student | DELETE | `/api/students/{id}` |

## 6. Sample requests (Postman)

Import `postman/SWYNEX-CRUD.postman_collection.json` into Postman for ready requests.
For POST/PUT: **Body → raw → JSON**.

### Create (POST) `http://localhost:8080/api/students`
```json
{
  "name": "Rahul Patil",
  "email": "rahul@example.com",
  "course": "Java Full Stack",
  "age": 21
}
```
Response (201 Created):
```json
{
  "id": 1,
  "name": "Rahul Patil",
  "email": "rahul@example.com",
  "course": "Java Full Stack",
  "age": 21
}
```

### Read all (GET) `http://localhost:8080/api/students`
### Read one (GET) `http://localhost:8080/api/students/1`

### Update (PUT) `http://localhost:8080/api/students/1`
```json
{
  "name": "Rahul Patil",
  "email": "rahul@example.com",
  "course": "Spring Boot",
  "age": 22
}
```

### Delete (DELETE) `http://localhost:8080/api/students/1`
```json
{ "message": "Student deleted successfully with id: 1" }
```

## 7. Validation (basic checks)

| Field | Rule |
|---|---|
| name | required, 2–50 characters |
| email | required, valid format, must be unique |
| course | required |
| age | required, between 15 and 100 |

Example of a wrong request (400 Bad Request):
```json
{
  "timestamp": "2026-11-02T11:30:00",
  "status": 400,
  "message": "Validation failed",
  "errors": {
    "name": "Name is required",
    "email": "Email format is not valid",
    "course": "Course is required",
    "age": "Age must be at least 15"
  }
}
```

| Situation | Status code |
|---|---|
| Student created | 201 |
| Success | 200 |
| Wrong input | 400 |
| Student id not found | 404 |
| Email already exists | 409 |

## 8. Upload to GitHub

```bash
cd SWYNEX-Database-and-CRUD
git init
git add .
git commit -m "Task 2: Database and CRUD with Spring Boot and MySQL"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/SWYNEX-Database-and-CRUD.git
git push -u origin main
```
(First create an empty public repository named `SWYNEX-Database-and-CRUD` on github.com.)

> Security tip: before pushing, change the password in `application.properties`
> back to `your_mysql_password` so your real password is not public.

## 9. LinkedIn post (copy–paste)

```
Completed Task 2 of my internship with @SWYNEX Technologies! 🚀

I built a Database and CRUD REST API using Java 17, Spring Boot 3.5.7,
MySQL, Spring Data JPA and Hibernate.

✅ Create, Read, Update, Delete student records
✅ Input validation and clean error messages
✅ Tested every endpoint in Postman

Key learning: how an API connects to a real database and how
Controller → Service → Repository work together.

GitHub: https://github.com/YOUR-USERNAME/SWYNEX-Database-and-CRUD

#SWYNEX #Internship #Java #SpringBoot #MySQL #CRUD #BackendDevelopment
```
Add a screenshot of Postman results or a short demo video to the post.

## 10. Common problems

| Problem | Fix |
|---|---|
| `Access denied for user 'root'` | Wrong MySQL password in `application.properties` |
| `Communications link failure` | MySQL server is not running – start it |
| `Port 8080 already in use` | Change `server.port=8081` |
| Red errors in Eclipse | Right-click project → Maven → Update Project |
