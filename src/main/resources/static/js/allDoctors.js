let user = null;
$.get("getData", function (data) {
    if (data !== "") {
        user = data;
    }
}).done(function () {
    console.log(user);
    let content = user.name + " " + user.surname;
    $("p.name-surname").html(content);
});


let doctors = null;
$.get("doctors", function (data) {
    if (data !== "") {
        doctors = data;
        console.log(doctors);
    }
}).done(function () {
    let cardsContent = "";
    jQuery.each(doctors, function (i, doctor) {
        cardsContent +=
            "<div class='element-card'>" +

            "<div class= 'front-facing'>" +
            "<i class= 'fa fa-user-md' aria-hidden='true'></i>" +
            "<h1 class='abr'>Doctor:  " + doctor.name + "</h1>" +

            " <p class='title'>" + doctor.category + "</p>" +
            "</div>" +

            "<div class='back-facing'>" +
            "<p><a class='btn' onclick='theFunctionClick(" + doctor.id + ")'>More info</a></p>" +
            "</div>" +

            "</div>";

    });
    $("div#allCardsDoctors").html(cardsContent);
});


let doctorsByCategory = null;

$(document).ready(function () {
    $("button#send").click(function () {
        console.log("ENTER");
        let category = document.querySelector("body > div > div.navbar > div.searchSend > ul > li:nth-child(1) > input").value;
        if (category === ""){
            alert("No input.")
            return false;
        }
        $.ajax({
            url: '/doctors/by-category/' + category,
            method: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            success: function (data) {
                doctorsByCategory = data;
                console.log(doctorsByCategory);

                if (doctorsByCategory.length === 0) {
                    alert("No doctors found with category - " + category);
                    return false;
                }

                let cardsContent = "";
                jQuery.each(doctorsByCategory, function (i, doctor) {
                    cardsContent +=
                        "<div class='element-card'>" +

                        "<div class= 'front-facing'>" +
                        "<i class= 'fa fa-user-md' aria-hidden='true'></i>" +
                        "<h1 class='abr'>Doctor:  " + doctor.name + "</h1>" +
                        " <p class='title'>" + doctor.category + "</p>" +
                        "</div>" +

                        "<div class='back-facing'>" +
                        "<p>text</p>" +
                        "<p><a class='btn' onclick='theFunctionClick('" + doctor.id + ")>More info</a></p>" +
                        "</div>" +

                        "</div>";
                });

                $("div#allCardsDoctors").html(cardsContent);

            },
            error: function (data) {
            }
        })
    });
});


let id = null;
function theFunctionClick(otherId) {
    let formData = new FormData;
    formData.set("idDoctor", otherId);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/doctor");
    xhr.send(formData);
    xhr.onload = function () {
        let finalUrl = '';
        let url = window.location.href.split("/");
        for (let i = 0; i < url.length - 1; i++) {
            finalUrl += url[i] + "/";
        }
        finalUrl += "Zapusatys.html";
        window.location.href = finalUrl;
    }
}





