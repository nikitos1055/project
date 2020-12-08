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
            "<p>text</p>" +
            "<p><a class='btn' href='Zapusatys.html'>More info</a></p>" +
            "</div>" +

            "</div>";
    });
    $("div#allCardsDoctors").html(cardsContent);
});


let doctorsByCategory = null;

$(document).ready(function () {
    $("div#send").click(function () {
        let category = document.querySelector("body > div > div.navbar > div.search > div > input[type=text]").value;
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
                        "<p><a class='btn' href='Zapusatys.html'>More info</a></p>" +
                        "</div>" +

                        "</div>";
                });
                $("div#allCardsDoctors").html(cardsContent);
            },
            error: function (data) {
                alert("error")
                console.log(data.status)
            }
        })
    });
});