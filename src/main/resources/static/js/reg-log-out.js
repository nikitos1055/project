$('.message a').click(function () {
    $('form').animate({
        height: "toggle",
        opacity: "toggle"
    }, "slow");
});

//register for user

$(document).ready(function () {
    $("div#register").click(function () {
        let firstName = $("form.register-form input.firstName").val();
        let lastName = $("form.register-form input.lastName").val();
        let login = $("form.register-form input.login").val();
        let password = $("form.register-form input.password").val();
        let confirmPassword = $("form.register-form input.confirmPassword").val();
        if (firstName === "" || lastName === "" || login === "" || password === "" || confirmPassword === "") {
            alert("Please fill all fields.");
            return false;
        } else if (password.length < 5) {
            alert("Password must contains more than 5 characters.");
            return false;
        } else if (!(password.match(confirmPassword))) {
            alert("Your passwords don`t match! Try again!");
            return false;
        } else {
            let userRegistration = {
                firstName: firstName,
                lastName: lastName,
                login: login,
                password: password
            };
            $.ajax({
                url: '/register-user',
                method: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(userRegistration),

                success: function (data) {
                    if (data === 200) {
                        let finalUrl = '';
                        let url = window.location.href.split("/");
                        for (let i = 0; i < url.length - 1; i++) {
                            finalUrl += url[i] + "/";
                        }
                        finalUrl += "mainPage.html";
                        window.location.href = finalUrl;
                    } else {
                        alert("User with this login already exists.")
                    }
                    console.log(data.status);
                },
                error: function (data) {
                    alert("error")
                    console.log(data.status)
                }
            });
        }
    });
});


//login user
$(document).ready(function () {
    $("div#login").click(function () {
        let login = $("form.login input.login").val();
        let password = $("form.login input.password").val();

        if (login === "" || password === "") {
            alert("Please fill all fields!!!");
        } else {
            let user = {
                login: login,
                password: password
            };
            $.ajax({
                url: '/login',
                method: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(user),

                success: function (data) {
                    if (data === 200) {
                        let finalUrl = '';
                        let url = window.location.href.split("/");
                        for (let i = 0; i < url.length - 1; i++) {
                            finalUrl += url[i] + "/";
                        }
                        finalUrl += "mainPage.html";
                        window.location.href = finalUrl;
                    } else if (data === 409) {
                        alert("Password invalid.")
                    } else {
                        alert("User do not exists.")
                    }
                    console.log(data.status);
                },
                error: function (data) {
                    alert("error")
                    console.log(data.status)
                }
            });
        }
    });
});


//                                FOR DOCTOR
//register for doctor
$(document).ready(function () {
    $("div#register-doc").click(function () {
        let firstName = $("form.register-form-doctor input.firstName").val();
        let lastName = $("form.register-form-doctor input.lastName").val();
        let category = $("form.register-form-doctor input.category").val();
        let experience = $("form.register-form-doctor input.experience").val();
        let login = $("form.register-form-doctor input.login").val();
        let password = $("form.register-form-doctor input.password").val();
        let confirmPassword = $("form.register-form-doctor input.confirmPassword").val();

        if (firstName === "" || lastName === "" || login === "" || category === "" || experience === "" || password === "" || confirmPassword === "") {
            alert("Please fill all fields!");
        } else if (password.length < 5) {
            alert("Password must contains more than 5 characters");
        } else if (!(password.match(confirmPassword))) {
            alert("Your passwords do not match! Try again!");

        } else {
            let doctorRegistration = {
                firstName: firstName,
                lastName: lastName,
                category: category,
                experience: experience,
                login: login,
                password: password
            };
            $.ajax({
                url: '/register-doctor',
                method: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(doctorRegistration),

                success: function (data) {
                    if (data === 200) {
                        let finalUrl = '';
                        let url = window.location.href.split("/");
                        for (let i = 0; i < url.length - 1; i++) {
                            finalUrl += url[i] + "/";
                        }
                        finalUrl += "mainPage.html";
                        window.location.href = finalUrl;
                    } else {
                        alert("Doctor with this login already exists.")
                    }
                    console.log(data.status);
                },
                error: function (data) {
                    alert("error")
                    console.log(data.status)
                }
            })
        }
    });
});


//logout for all
$(document).ready(function () {
    $("a.logout").click(function () {
        $.get("logout", function (data) {
            let finalUrl = "";
            let url = window.location.href.split("/");
            for (let i = 0; i < url.length - 1; i++) {
                finalUrl += url[i] + "/";
            }
            finalUrl += "index.html";
            window.location.href = finalUrl;
        });
    });
});

