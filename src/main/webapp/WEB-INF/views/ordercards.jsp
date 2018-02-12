<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<header>
    <title>Order card</title>


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
<p>Order id: <input class="text text-primary" id ="order_id" readonly value="${orderId}"></p>
<p>Client Name: <input class="text text-primary" id="clientname" readonly value="${clientName}"></p>
<p>Total price : <input class="text-primary" id="total_price" readonly value="${totalPrice}"></p>
<table id="goods" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Good name</th>
        <th>Good in order</th>
        <th>Good price</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>Good name</th>
        <th>Good price</th>
        <th>Good in order</th>
    </tr>
    </tfoot>
</table>
<script type="text/javascript">
    $(document).ready(function(){
        var selected = [];
        var url = "/api/good/"+"${orderId}"+"/products/";
        var table = $('#goods').DataTable({
            dom:"Bfrtip",
            processing: true,
            select: true,
            ajax: url,
            columns: [
                {"data":"name"},
                {"data":"number"},
                {"data":"price"}
            ],
            buttons: [
                {
                    extend: 'selectedSingle',
                    text: "Open good's details",
                    action: function(e,dt,button,config){
                        var selectedRows = table.rows('.selected').data().toArray();
                        selectedRows.forEach(showDetailPage);

                        function showDetailPage(row, index) {
                            var url = "/panel/good/details/" + row.name + "/";
                            $("<a>").attr("href", url).attr("target", "_blank")[0].click();
                        }
                    }

                }
            ],
            "rowCallback": function( row, data ) {
                if ( $.inArray(data.DT_RowId, selected) !== -1 ) {
                    $(row).addClass('selected');
                }
            },
        });
        $('#goods tbody').on('click', 'tr', function () {
            var id = this.id;
            var index = $.inArray(id, selected);

            if ( index === -1 ) {
                selected.push( id );
            } else {
                selected.splice( index, 1 );
            }

            $(this).toggleClass('selected');
        } );


    });
</script>
<p>Change Client name: <b> <input class="text text-primary" id="editor_clientname" value="${clientName}" type="text"></b></p>
<p>Change Total price:  <input class="text text-primary" id="editor_totalprice" value="${totalPrice}" type="text" ></p>
<p><button class="mySaveBtn" id="saveBtn"  value="Save"></button></p>
<script>
    $('#saveBtn').click(function () {
        var data = {};
        data["newClientName"] = $('#editor_clientname').val();
        data["newTotalPrice"] = $('#editor_totalprice').val();

            $.ajax({
                type: "PUT",
                contentType: "application/json",
                url : "/api/order/details/${orderId}",
                data: JSON.stringify(data),
                success: function(data) {
                    console.log("SUCCESS: ", data);
                }
            })


    })
</script>


</body>