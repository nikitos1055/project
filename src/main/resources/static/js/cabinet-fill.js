let user = null;
$.get("getData", function (data) {
    if (data !== "") {
        user = data;
    }
}).done(function () {
    console.log(user);
    let content = user.role + ": " + user.name + " " + user.surname;
    $("p.name-surname").html(content);

    if (user.role === "USER" || user.role === "ADMIN") {
        document.getElementById("name").placeholder = user.name;
        document.getElementById("surname").placeholder = user.surname;
        document.getElementById("login").placeholder = user.login;

        let meetings = null;
        console.log(user);
        $.get("/user/meetings/" + user.id, function (data) {
            meetings = data;
        }).done(function () {
            let cardsContent = "";
            jQuery.each(meetings, function (i, meeting) {
                cardsContent +=
                    "<div class='card'>" +
                    "<ul>" +
                    " <li>Time : <span>" + meeting.time + "</span></li>" +
                    " <li>Doctor : <span>" + meeting.doctor.name + "</span></li>" +
                    " <li>Doctor category : <span>" + meeting.doctor.category + "</span></li>" +
                    " <button class='red' onclick='theFunctionClick(" + meeting.id + ")'> Delete </button>" +
                    " </ul>" +
                    " </div>";
            });
            $("div#meetings").html(cardsContent);
        });
    }

    if (user.role === "DOCTOR") {
        document.getElementById("nameD").placeholder = user.name;
        document.getElementById("surnameD").placeholder = user.surname;
        document.getElementById("loginD").placeholder = user.login;
        document.getElementById("experienceD").placeholder = user.experience;
        document.getElementById("categoryD").placeholder = user.category;

        let meetings = null;
        console.log(user);
        $.get("/doctor/meetings/" + user.id, function (data) {
            meetings = data;
        }).done(function () {
            let cardsContent = "";
            jQuery.each(meetings, function (i, meeting) {
                cardsContent +=
                    "<div class='card'>" +
                    "<ul>" +
                    " <li>Time : <span>" + meeting.time + "</span></li>" +
                    " <li>User Name : <span>" + meeting.user.name + "</span></li>" +
                    " <li>User Surname : <span>" + meeting.user.surname + "</span></li>" +
                    " <button class='red' onclick='theFunctionClick(" + meeting.id + ")'> Delete </button>" +
                " </ul>" +
                " </div>";
            });
            $("div#meetings").html(cardsContent);
        });
    }
});


let id = null;
function theFunctionClick(otherId) {
        $.ajax({
            url: '/delete-meeting/' + otherId,
            method: 'DELETE',
            success: function (data) {
                alert("Deleted");
                document.location.reload();
            },
            error: function (data) {
                alert("error")
                console.log(data.status)
            }
        });
}

