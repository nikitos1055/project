let user = null;
$.get("getData", function (data) {
    if (data !== "") {
        user = data;
    }
}).done(function () {
    console.log(user);
    let content = user.name + " " + user.surname;
    $("p.name-surname").html(content);

    if (user.role === "USER" || user.role === "ADMIN") {
        document.getElementById("name").placeholder = user.name;
        document.getElementById("surname").placeholder = user.surname;
        document.getElementById("login").placeholder = user.login;
    }

    if (user.role === "DOCTOR") {
        document.getElementById("nameD").placeholder = user.name;
        document.getElementById("surnameD").placeholder = user.surname;
        document.getElementById("loginD").placeholder = user.login;
        document.getElementById("experienceD").placeholder = user.experience;
        document.getElementById("categoryD").placeholder = user.category;
    }
});


