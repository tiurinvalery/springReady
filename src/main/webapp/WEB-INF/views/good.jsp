<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<header>
    <title>Goods</title>
    <script src="${ContextPath}/resources/js/bootstrap.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ContextPath}/resources/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="${ContextPath}/resources/css/order.css">
</header>
<body>

<button id="getAllGoods" class="badge-primary" value="Get All Goods"></button>
<script type="text/javascript">
    $(document).ready(function(){
        $("#getAllGoods").click(myFunction())
    });
function myFunction() {
    $.ajax({
        url: '/api/good',
        datatype: 'json',
        contentType: 'application/json',
        type: "GET",
        data: {},
        success: function(data) {
            alert(data.name + " " + data.number + " " + data.price);
            var goodName = data.name;
            var goodNumber = data.number;
            var goodPrice = data.price;

            $("#name").text(goodName);
            $("#number").text(goodNumber);
            $("#price").text(goodPrice);
        }
    }
        )};
</script>
<table id="goods" class="display nowrap" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Goods id</th>
        <th>Name</th>
        <th>Number</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td></td>
        <td id="name"></td>
        <td id="number"></td>
        <td id="price"></td>
    </tr>
    </tbody>
</table>
<script type="text/javascript">
    $(document).ready(function() {
        $('#goods').DataTable( {
            "scrollY": 200,
            "scrollX": true
        } );
    } );
</script>
<p><button class="button badge-primary" id="btnCreator" value="Create fake good's" onclick="btnFunction"></button></p>

</body>