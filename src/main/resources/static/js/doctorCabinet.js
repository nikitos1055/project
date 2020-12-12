$.get("getData", function (data) {
    if (data !== "") {
        user = data;
    }
}).done(function () {
    console.log(user);
    if (user.role === "DOCTOR"){
        document.getElementById("doctor").style.display = "inline-block";
    }
    if (user.role === "USER" || user.role === "ADMIN"){
        document.getElementById("user").style.display = "inline-block";
    }
});


$(document).ready(function () {
    $("button#meeting-create").click(function () {
        let time = $("input#time").val();
        let cabinet = $("input#cabinet").val();
        let price = $("input#price").val();
        if (time === "" || cabinet === "" || price === "") {
            alert("Please fill all fields.");
            return false;
        }else {
            let meetingCreate = {
                time: time,
                cabinet: cabinet,
                price: price,
                doctor: user,
            };
            $.ajax({
                url: '/create-meeting',
                method: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(meetingCreate),

                success: function (data) {
                    if (data === 200) {
                        alert("Meeting was created.")
                        console.log(meetingCreate);
                    } else {
                        alert("User with this login already exists.")
                        console.log(meetingCreate);
                    }

                },
                error: function (data) {
                    alert("error")
                    console.log(meetingCreate);
                }
            });
        }
    });
});

$(document).ready(function () {
    $("button#meeting-create").click(function () {
        let time = $("input#time").val();
        let cabinet = $("input#cabinet").val();
        let price = $("input#price").val();
        if (time === "" || cabinet === "" || price === "") {
            alert("Please fill all fields.");
            return false;
        }else {
            let meetingCreate = {
                time: time,
                cabinet: cabinet,
                price: price,
                doctor: user,
            };
            $.ajax({
                url: '/create-meeting',
                method: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(meetingCreate),

                success: function (data) {
                    if (data === 200) {
                        alert("Meeting was created.")
                        console.log(meetingCreate);
                    } else {
                        alert("User with this login already exists.")
                        console.log(meetingCreate);
                    }

                },
                error: function (data) {
                    alert("error")
                    console.log(meetingCreate);
                }
            });
        }
    });
});