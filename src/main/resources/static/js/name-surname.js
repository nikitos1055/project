let user = null;
$.get("getData", function (data) {
    if (data !== "") {
        user = data;
    }
}).done(function () {
    console.log(user);
    let content = user.role + ": " + user.name + " " + user.surname;
    $("p.name-surname").html(content);

    let formData = new FormData;
    formData.set("idUser", user.id);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/user");
    xhr.send(formData);
    console.log("Data sent - " + formData);

    $("span#admin").click(function () {
        if (user.role === "ADMIN") {
            let finalUrl = '';
            let url = window.location.href.split("/");
            for (let i = 0; i < url.length - 1; i++) {
                finalUrl += url[i] + "/";
            }
            finalUrl += "adminPage.html";
            window.location.href = finalUrl;
        } else return false;
    });
    
});






