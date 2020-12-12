//doctor inf
let doctor = null;
$.get("/doctors/by-id", function (data) {
    doctor = data;
}).done(function () {
    document.getElementById("nameInfo").placeholder = doctor.name;
    document.getElementById("surnameInfo").placeholder = doctor.surname;
    document.getElementById("experienceInfo").placeholder = doctor.experience;
    document.getElementById("categoryInfo").placeholder = doctor.category;
    console.log(doctor)
});


