const API_URL = "http://localhost:8080/student";

// Load students when page opens
window.onload = function () {
    getAllStudents();
};

// Save Student
function saveStudent() {

    const name = document.getElementById("name").value;
    const city = document.getElementById("city").value;

    fetch(`${API_URL}/saveStudent`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: name,
            city: city
        })
    })
    .then(response => response.json())
    .then(data => {
        alert("Student Saved Successfully");
        clearFields();
        getAllStudents();
    });
}

// Get All Students
function getAllStudents() {

    fetch(`${API_URL}/getAllStudents`)
    .then(response => response.json())
    .then(data => {

        const tableBody = document.getElementById("studentTableBody");

        tableBody.innerHTML = "";

        data.forEach(student => {

            tableBody.innerHTML += `
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.city}</td>

                    <td>
                        <button class="edit-btn"
                            onclick="editStudent(${student.id}, '${student.name}', '${student.city}')">
                            Edit
                        </button>

                        <button class="delete-btn"
                            onclick="deleteStudent(${student.id})">
                            Delete
                        </button>
                    </td>
                </tr>
            `;
        });

    });
}

// Find Student By ID
function findStudent() {

    const id = document.getElementById("searchId").value;

    fetch(`${API_URL}/findStudentById/${id}`)
    .then(response => response.json())
    .then(student => {

        document.getElementById("studentTableBody").innerHTML = `
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.city}</td>

                <td>
                    <button class="edit-btn"
                        onclick="editStudent(${student.id}, '${student.name}', '${student.city}')">
                        Edit
                    </button>

                    <button class="delete-btn"
                        onclick="deleteStudent(${student.id})">
                        Delete
                    </button>
                </td>
            </tr>
        `;
    });
}

// Delete Student
function deleteStudent(id) {

    fetch(`${API_URL}/deleteStudent/${id}`, {
        method: "DELETE"
    })
    .then(response => response.text())
    .then(data => {
        alert(data);
        getAllStudents();
    });
}

// Edit Student
function editStudent(id, name, city) {

    document.getElementById("studentId").value = id;
    document.getElementById("name").value = name;
    document.getElementById("city").value = city;
}

// Update Student
function updateStudent() {

    const id = document.getElementById("studentId").value;

    const name = document.getElementById("name").value;
    const city = document.getElementById("city").value;

    fetch(`${API_URL}/updateStudent/${id}`, {

        method: "PUT",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            name: name,
            city: city
        })
    })
    .then(response => response.json())
    .then(data => {

        alert("Student Updated Successfully");

        clearFields();

        getAllStudents();
    });
}

// Clear Fields
function clearFields() {

    document.getElementById("studentId").value = "";
    document.getElementById("name").value = "";
    document.getElementById("city").value = "";
}