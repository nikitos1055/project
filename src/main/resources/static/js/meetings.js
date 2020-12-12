$(document).ready(function () {
    $("button#create-meeting").click(function () {
        let time = $("input#time").val();
        if (time === "") {
            alert("Please fill all fields.");
            return false;
        } else {
            let meeting = {
                time: time,
                doctor: doctor,
                user: user,
            };
            $.ajax({
                url: '/create-meeting',
                method: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(meeting),

                success: function (data) {
                    if (data === 200) {
                        alert("CREATED")
                    } else if (data === 500) {
                        alert("Time is not available.")
                    }
                    console.log(data.status);
                },
                error: function (data) {
                    alert("error")
                    console.log(data.status)
                }
            });
        }
    });
});