$(document).ready(function () {
    $("form input#createProduct").click(function () {
        let name = $("form input#name").val();
        let description = $("form input#description").val();
        let price = $("form input#price").val();

        if (name === "" || description === "" || price === "") {
            alert("Please fill all fields...!!!")
        } else {
            let product = {
                name: name,
                description: description,
                price: price
            };
            $.post("product", product, function (data) {
                if (data === "Success") {
                    $("form")[0].reset();
                }
            });
        }
    });
});