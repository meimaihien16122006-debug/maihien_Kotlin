package com.example.qlsvkotlin

data class Student(
    val studentId: String,
    val fullName: String,
    val age: Int,
    val major: String,
    val gpa: Double
)
val students = mutableListOf(
    Student("SV0001", "Doan Thi Mai Hien", 20, "Cong nghe thong tin", 8.7),
    Student("SV0002", "Nguyen Thanh Lam", 21, "Co dien tu", 9.0),
    Student("SV0003", "Trinh Thi Thuy Yen", 20, "Ngon ngu Anh", 9.1),
    Student("SV0004", "Nguyen Thu Thao", 22, "Ngon ngu Anh", 9.3),
    Student("SV0005", "Pham Le Phuong Trinh", 23, "Ngon ngu Nhat", 3.6)
)
fun displayStudent(student: Student) {
    println(
        "ID: ${student.studentId} | " +
                "Name: ${student.fullName} | " +
                "Age: ${student.age} | " +
                "Major: ${student.major} | " +
                "GPA: ${student.gpa}"
    )
}
fun displayAllStudent(students: MutableList<Student>) {

    if (students.isEmpty()) {
        println("Danh sach sinh vien rong")
        return
    }
    println("===== DANH SACH SINH VIEN =====")

    for (student in students) {
        displayStudent(student)
    }
}
fun addStudent(students: MutableList<Student>) {

    print("Nhap Student ID: ")
    val id = readln()

    print("Nhap Full Name: ")
    val name = readln()

    print("Nhap Age: ")
    val age = readln().toInt()

    print("Nhap Major: ")
    val major = readln()

    // Validation GPA tu 0 den 10
    var gpa: Double

    do {
        print("Nhap GPA (0 - 10): ")
        gpa = readln().toDouble()

        if (gpa < 0 || gpa > 10) {
            println("GPA khong hop le! Vui long nhap lai.")
        }

    } while (gpa < 0 || gpa > 10)

    val student = Student(
        id,
        name,
        age,
        major,
        gpa
    )

    students.add(student)

    println("Them sinh vien thanh cong!")
}
fun searchById(students: MutableList<Student>) {

    print("Nhap Student ID can tim: ")
    val id = readln()

    val student = students.find {
        it.studentId.equals(id, ignoreCase = true)
    }

    if (student != null) {
        println("Tim thay sinh vien:")
        displayStudent(student)
    } else {
        println("Khong tim thay sinh vien co ma: $id")
    }
}

// ==================================================
// 4. TINH GPA TRUNG BINH
// ==================================================
fun calculateAverageGpa(students: MutableList<Student>) {

    if (students.isEmpty()) {
        println("Danh sach sinh vien rong")
        return
    }

    val average = students.map { it.gpa }.average()

    println("GPA trung binh cua tat ca sinh vien: %.2f".format(average))
}
fun findHighestGpa(students: MutableList<Student>) {

    if (students.isEmpty()) {
        println("Danh sach sinh vien rong")
        return
    }

    val student = students.maxByOrNull {
        it.gpa
    }

    println("===== SINH VIEN CO GPA CAO NHAT =====")

    if (student != null) {
        displayStudent(student)
    }
}
fun removeStudent(students: MutableList<Student>) {

    print("Nhap Student ID can xoa: ")
    val id = readln()

    val student = students.find {
        it.studentId.equals(id, ignoreCase = true)
    }

    if (student != null) {

        students.remove(student)

        println("Da xoa sinh vien:")
        displayStudent(student)

    } else {

        println("Khong tim thay sinh vien co ma: $id")
    }
}

// ==================================================
// 7. DEM SINH VIEN GPA >= 8.0
// ==================================================
fun countGpaAbove8(students: MutableList<Student>) {

    val count = students.count {
        it.gpa >= 8.0
    }

    println("So sinh vien co GPA >= 8.0: $count")
}
fun countGpaBelow5(students: MutableList<Student>) {

    val count = students.count {
        it.gpa < 5.0
    }

    println("So sinh vien co GPA < 5.0: $count")
}
fun averageGpaByMajor(students: MutableList<Student>) {

    print("Nhap nganh can tinh GPA: ")
    val major = readln()

    val list = students.filter {
        it.major.equals(major, ignoreCase = true)
    }

    if (list.isEmpty()) {

        println("Khong co sinh vien trong nganh: $major")

    } else {

        val average = list.map {
            it.gpa
        }.average()

        println(
            "GPA trung binh nganh $major: %.2f"
                .format(average)
        )
    }
}
fun findOldestStudent(students: MutableList<Student>) {

    if (students.isEmpty()) {
        println("Danh sach sinh vien rong")
        return
    }

    val student = students.maxByOrNull {
        it.age
    }

    println("===== SINH VIEN LON TUOI NHAT =====")

    if (student != null) {
        displayStudent(student)
    }
}
fun findGpaRange(students: MutableList<Student>) {

    val list = students.filter {
        it.gpa in 7.0..8.5
    }

    if (list.isEmpty()) {

        println("Khong co sinh vien co GPA tu 7.0 den 8.5")

    } else {

        println("===== SINH VIEN CO GPA 7.0 - 8.5 =====")

        for (student in list) {
            displayStudent(student)
        }
    }
}

// ==================================================
// 12. TIM TAT CA SINH VIEN THEO NGANH
// ==================================================
fun findByMajor(students: MutableList<Student>) {

    print("Nhap nganh can tim: ")
    val major = readln()

    val list = students.filter {
        it.major.equals(major, ignoreCase = true)
    }

    if (list.isEmpty()) {

        println("Khong tim thay sinh vien")

    } else {

        println("===== SINH VIEN THUOC NGANH $major =====")

        for (student in list) {
            displayStudent(student)
        }
    }
}

fun searchByName(students: MutableList<Student>) {

    print("Nhap mot phan ten can tim: ")
    val name = readln()

    val list = students.filter {
        it.fullName.contains(
            name,
            ignoreCase = true
        )
    }

    if (list.isEmpty()) {

        println("Khong tim thay sinh vien")

    } else {

        println("===== KET QUA TIM KIEM =====")

        for (student in list) {
            displayStudent(student)
        }
    }
}

fun sortByGpaDescending(students: MutableList<Student>) {

    students.sortByDescending {
        it.gpa
    }

    println("===== SAP XEP GPA GIAM DAN =====")

    for (student in students) {
        displayStudent(student)
    }
}
fun top3Students(students: MutableList<Student>) {

    val top3 = students
        .sortedByDescending {
            it.gpa
        }
        .take(3)

    println("===== TOP 3 GPA CAO NHAT =====")

    for (student in top3) {
        displayStudent(student)
    }
}

fun sortByAge(students: MutableList<Student>) {

    students.sortBy {
        it.age
    }

    println("===== SAP XEP THEO TUOI =====")

    for (student in students) {
        displayStudent(student)
    }
}
fun sortByName(students: MutableList<Student>) {

    students.sortBy {
        it.fullName.lowercase()
    }

    println("===== SAP XEP TEN A -> Z =====")

    for (student in students) {
        displayStudent(student)
    }
}
fun statisticsPassFail(students: MutableList<Student>) {

    val pass = students.count {
        it.gpa >= 4.0
    }

    val fail = students.count {
        it.gpa < 4.0
    }

    println("===== THONG KE PASS / FAIL =====")
    println("Pass (GPA >= 4.0): $pass sinh vien")
    println("Fail (GPA < 4.0): $fail sinh vien")
}
fun showMenu() {

    println()
    println("========== STUDENT MANAGEMENT ==========")
    println("1. Add student")
    println("2. Display all students")
    println("3. Search student by ID")
    println("4. Calculate average GPA")
    println("5. Find student with highest GPA")
    println("6. Remove student")
    println("7. Count students GPA >= 8.0")
    println("8. Count students GPA < 5.0")
    println("9. Average GPA by major")
    println("10. Find oldest student")
    println("11. Find GPA from 7.0 to 8.5")
    println("12. Find students by major")
    println("13. Search by partial name")
    println("14. Sort GPA descending")
    println("15. Display top 3 GPA")
    println("16. Sort by age")
    println("17. Sort name A -> Z")
    println("18. Statistics Pass / Fail")
    println("0. Exit")
    println("========================================")
    print("Choose: ")
}
fun main() {

    do {

        showMenu()

        val choice = readln().toInt()

        when (choice) {

            1 -> addStudent(students)

            2 -> displayAllStudent(students)

            3 -> searchById(students)

            4 -> calculateAverageGpa(students)

            5 -> findHighestGpa(students)

            6 -> removeStudent(students)

            7 -> countGpaAbove8(students)

            8 -> countGpaBelow5(students)

            9 -> averageGpaByMajor(students)

            10 -> findOldestStudent(students)

            11 -> findGpaRange(students)

            12 -> findByMajor(students)

            13 -> searchByName(students)

            14 -> sortByGpaDescending(students)

            15 -> top3Students(students)

            16 -> sortByAge(students)

            17 -> sortByName(students)

            18 -> statisticsPassFail(students)

            0 -> println("Thoat chuong trinh!")

            else -> println("Lua chon khong hop le!")

        }

    } while (choice != 0)
}