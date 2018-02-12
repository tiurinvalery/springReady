$(document).ready(function () {
    $.ajax({
        url:"http://localhost:8080/panel/client"
    }).then(function (data) {
        $(".form-control-username").append(data.name);
        $(".form-control-password").append(data.password);
    });
});