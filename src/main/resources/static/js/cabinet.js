$(document).ready(function () {
    $("button#updateBtnUser").click(function () {
        if (user.role === "USER" || user.role === "ADMIN") {
            let name = $("input#name").val();
            let surname = $("input#surname").val();
            let login = document.getElementById("login").placeholder;
            console.log(login);
            if (name === "" || surname === "") {
                alert("Please fill all fields!");
                return false;
            } else {
                let userUpdate = {
                    name: name,
                    surname: surname,
                    login: login,
                };
                $.ajax({
                    url: '/update-user',
                    method: 'POST',
                    dataType: 'json',
                    contentType: 'application/json; charset=UTF-8',
                    data: JSON.stringify(userUpdate),

                    success: function (data) {
                        if (data === 200) {
                            alert("Updated user.")
                            document.location.reload();
                            console.log(userUpdate);
                        } else {
                            alert("Can`t update.")
                            console.log(userUpdate);
                        }
                        console.log(data.status);
                    },
                    error: function (data) {
                        alert("error")
                        console.log(userUpdate);
                        console.log(data.status)
                    }
                })
            }
        }
    });
});


$(document).ready(function () {
    $("button#updateBtnDoc").click(function () {
        if (user.role === "DOCTOR") {
            let name = $("input#nameD").val();
            let surname = $("input#surnameD").val();
            let experience = $("input#experienceD").val();
            let category = $("input#categoryD").val();
            let login = document.getElementById("loginD").placeholder;
            console.log(login);
            if (name === "" || surname === "" || experience === "" || category === "") {
                alert("Please fill all fields!");
                return false;
            } else {
                let doctorUpdate = {
                    name: name,
                    surname: surname,
                    category: category,
                    experience: experience,
                    login: login,
                };
                $.ajax({
                    url: '/update-doctor',
                    method: 'POST',
                    dataType: 'json',
                    contentType: 'application/json; charset=UTF-8',
                    data: JSON.stringify(doctorUpdate),

                    success: function (data) {
                        if (data === 200) {
                            alert("Updated user.")
                            document.location.reload();
                            console.log(doctorUpdate);
                        } else {
                            alert("Can`t update.")
                            console.log(doctorUpdate);
                        }
                        console.log(data.status);
                    },
                    error: function (data) {
                        alert("error")
                        console.log(doctorUpdate);
                        console.log(data.status)
                    }
                })
            }
        }else alert(user.role)
    });
});