let user = null;
$.get("user", function (data) {
    if (data !== "") {
        user = data;
    }
}).done(function () {
    let content = "";
    jQuery.each(user, function (i, user) {

    });
    $("div.inbox_chat").html(content);
});