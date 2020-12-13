let allUsers = null;
$.get("all-users", function (data) {
    if (data !== "") {
        allUsers = data;
        console.log(allUsers);
    }
}).done(function () {
    let cardsContent = "";
    jQuery.each(allUsers, function (i, user) {
        cardsContent +=
            "<tr>" +
            "<td>" + user.id + "</td>" +
            " <td>" + user.name + " " + user.surname + "</td>" +
            "  <td>" + user.login + "</td>" +
            " <td>" + user.password + "</td>" +
            "<td>" + user.role + "</td>" +
            " <td>" + user.status + "</td>" +
            " <td><button onclick='theBanClick("+user.id+")'>Ban</button></td>" +
            " <td><button onclick='theUnBanClick("+user.id+")'>Unban</button></td>" +
            "</tr>";

    });
    $("tbody#body-users").html(cardsContent);

    $("#save-btn").click(function() {
        var blob = new Blob([JSON.stringify(allUsers)], {type: "text/plain;charset=utf-8"});
        saveAs(blob, "users.txt");
    });
});



function theBanClick(otherId) {
    $.ajax({
        url: '/ban-user/' + otherId,
        method: 'POST',
        success: function (data) {
            alert("Status : banned");
            document.location.reload();
        },
        error: function (data) {
            alert("error")
            console.log(data.status)
        }
    });
}

function theUnBanClick(otherId) {
    $.ajax({
        url: '/unban-user/' + otherId,
        method: 'POST',
        success: function (data) {
            alert("Status : active.");
            document.location.reload();
        },
        error: function (data) {
            alert("error")
            console.log(data.status)
        }
    });
}




