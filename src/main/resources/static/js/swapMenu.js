let slider = document.getElementById('slider');
let active = document.getElementById('active');
let line1 = document.getElementById('line1');
let line2 = document.getElementById('line2');
let line3 = document.getElementById('line3');
let line4 = document.getElementById('line4');

line1.onclick = function () {
    slider.style.transform = ("translateX(0)");
    active.style.top = ("0px");
}
line2.onclick = function () {
    slider.style.transform = ("translateX(-25%)");
    active.style.top = ("80px");
}
line3.onclick = function () {
    slider.style.transform = ("translateX(-50%)");
    active.style.top = ("160px");
}
line4.onclick = function () {
    slider.style.transform = ("translateX(-75%)");
    active.style.top = ("240px");
}

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

$( document ).ready(function() {
    console.log( "ready!" );
});