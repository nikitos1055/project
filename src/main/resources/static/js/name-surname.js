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


