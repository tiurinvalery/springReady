<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<header>
    <title>Goods card</title>


    <!-- Bootstrap -->
    <script src="${ContextPath}/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ContextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ContextPath}/resources/css/btn_editorStyle.css">

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/select/1.2.5/js/dataTables.select.min.js"></script>

    <link rel="stylesheet" href="${ContextPath}/resources/css/buttons.dataTables.css">
    <script src="${ContextPath}/resources/js/dataTables.buttons.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
    <script src="${ContextPath}/resources/js/buttons.print.js"></script>

</header>
<body>
<p>Good's name: <input type="text" id="good_name" class="input information" value="${goodsName}"></p>
<p><button value="Change good's name" class="btn-editor" id="good_name_change_btn"></button></p>
<p>Good's price: <input type="text" id="good_price" class="input information" value="${goodsPrice}"></p>
<p><button value="Change good's" class="btn-editor" id="good_price_change_btn"></button></p>
<p>Good's number: <input type="text" id="good_number" class="input information" value="${goodsNumber}"></p>
<p><button value="Change good's" class="btn-editor" id="good_number_change_btn"></button></p>
</body>