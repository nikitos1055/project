let doctors = null;

$.get("doctors", function (data) {
    if (data !== "") {
        doctors = data;
    }
}).done(function () {
    let cardsContent = "";
    jQuery.each(doctors, function (i, doctor) {
        cardsContent += "<div class='element-card'>" +
            "  <div class='card-body'>" +

            "<div class= 'front-facing'>" +
            "<i class= 'fa fa-user-md' aria-hidden='true'></i>" +
            "<h1 class='abr'>Doctor: Alan</h1>" +
            " <p class='title'>Surgery</p>" +
            "</div>" +

            "<div class= 'back-facing'>"+
                "<p>text</p>"+
                "<p><a class='btn' href='Zapusatys.html'>More info</a></p>" +
            "</div>"+
        "</div>";
    });
    $("div.container").html(cardsContent);
});