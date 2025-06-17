# course-platform-api

### 🧩 **Challenge 3: Course Enrollment Platform**

**Repository name:** `course-platform-api`

#### 📌 Product Requirements:

Platform untuk registrasi kursus oleh mahasiswa dan pengelolaan oleh admin.

- Ada user dan admin
- Mahasiswa bisa melihat dan mendaftar ke kursus
- Admin bisa menambah dan menghapus kursus

#### 📡 Endpoints:

1. `POST /auth/register`
2. `POST /auth/login`
3. `GET /courses` – semua kursus
4. `POST /courses` – tambah kursus (admin only)
5. `DELETE /courses/{id}` – hapus kursus (admin only)
6. `POST /enrollments` – daftar kursus (student only)
7. `GET /enrollments/my` – lihat kursus yang diambil (JWT user)
8. `GET /courses/{id}` – detail kursus

#### 🧾 Entities:

- **User** (id, username, password, role: STUDENT/ADMIN)
- **Course** (id, title, description, createdBy)
- **Enrollment** (id, user_id, course_id, enrolled_date)

---

### ✅ Fitur Tambahan di Semua Soal:

- 🔐 JWT-based security
- ✅ Bean validation (misal `@NotBlank`, `@Size`, dll)
- 📦 DTO usage untuk request/response
- 📃 API tested via Postman (bonus)

Jika kamu ingin saya buatkan struktur folder, kode JWT-nya, atau request/response sample untuk salah satu dari challenge di atas, tinggal bilang ya!

