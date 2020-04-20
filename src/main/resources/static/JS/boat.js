var boatId
var boatTable


function getBoats() {
    $("#tableShowBoat").dataTable().fnDestroy();
    $('#tableInputBoat').hide();
    $('#formEditBoat').hide();
    $('#tableShowBoat').show();
    boatTable = $('#tableShowBoat').DataTable({
        ajax: {
            url: "api/boats",
            dataSrc: function (json) {
                var return_data = new Array();
                for (var i = 0; i < json.length; i++) {
                    return_data.push({
                        'id': json[i].id,
                        'boatPrice': json[i].boatPrice,
                        'boatNumber': json[i].boatNumber,
                        'boatType': json[i].boatType,
                        'boatNumberOfSeat': json[i].boatNumberOfSeat,
                        'boatActualPrice': json[i].boatActualPrice,
                        'deleteBtn': "<button class='btn btn-danger deleteButton' boatId=' " + json[i].id + " ' >Delete</button>",
                        'editBtn': "<button class='btn btn-primary editBtn' boatId=' " + json[i].id + " '> Edit </button>",

                    });
                }
                return return_data;
            }
        },
        "columns": [

            { "data": "boatType" },
            { "data": "boatPrice" },
            { "data": "boatNumber" },
            { "data": "boatNumberOfSeat" },
            { "data": "boatActualPrice" },
            { "data": "deleteBtn" },
            { "data": "editBtn" }
        ],
        dom: 'Bfrtip',
        buttons: [
            {
                text: 'Create a boat',

                action: function (e, dt, node, config) {
                    var content = $('#formEditBoat').html();
                    $('#exampleModal .modal-body').html(content);
                    $('#exampleModal .modal-title').text("Boat Registration Form");
                    $('#exampleModal').modal('show');
                    $('#okDelModalBtn').hide();
                    $('#saveEdtModalBtn').hide();
                    $('#saveCrtModalBtn').show();
                }
            }
        ]
    });
    $("#saveCrtModalBtn").click(function () {
        postBoat();
        $('#exampleModal').modal('hide');
    });

    $("#tableShowBoat tbody").off().on('click', 'button.deleteButton', function () {
        $('#exampleModal').modal('show');
        $('#exampleModal .modal-body').text("Are you sure to delete mention boat?");
        $('#exampleModal .modal-title').text("Delete Confirmation!");
        $('#okDelModalBtn').show();
        $('#saveEdtModalBtn').hide();
        $('#saveCrtModalBtn').hide();
        boatId = $(this).attr('boatId');
    });

    $("#okDelModalBtn").click(function () {
        console.log(boatId);
        deleteBoat(boatId);
        $('#exampleModal').modal('hide');
    });
    $('#tableShowBoat').off().on('click', 'button.editBtn', function () {
        console.log(boatTable.row($(this).parents('tr')));
        var data1 = boatTable.row($(this).parents('tr')).data();


        $('#exampleModal').modal('show');
        var content = $('#formEditBoat').html();
        $('#exampleModal .modal-body').html(content);
        $('#exampleModal .modal-title').text("boat Notification Form");
        $('#okDelModalBtn').hide();
        $('#saveEdtModalBtn').show();
        $('#saveCrtModalBtn').hide();


        document.getElementById("boatNumberEdit").value = data1.boatNumber;
        document.getElementById("boatPriceEdit").value = data1.boatPrice;
        document.getElementById("boatTypeEdit").value = data1.boatType;
        document.getElementById("boatNumberOfSeatEdit").value = data1.boatNumberOfSeat;
        document.getElementById("boatActualPriceEdit").value = data1.boatActualPrice;


        boatEditId = data1.id;
    });
    $('#saveEdtModalBtn').click(function () {
        updateBoat(boatEditId);
        $('#exampleModal').modal('hide');
    });
}

//                      POST------------------------
function postBoat() {
    var boat = {
        boatNumber: $("#boatNumberEdit").val(),
        boatPrice: Number($("#boatPriceEdit").val()),
        boatType: $("#boatTypeEdit").val(),
        boatNumberOfSeat: $("#boatNumberOfSeatEdit").val(),
        boatActualPrice: $("#boatActualPriceEdit").val(),


    };

    var jsonObject = JSON.stringify(boat);

    $.ajax({
        url: "api/boats",
        type: "POST",
        contentType: "application/json",
        data: jsonObject,
        success: function (message) {
            //           alert('The Boat is created!');
            alert(message);
            $("#boatNumber").val('');
            $("#boatPrice").val('');
            $("#boatType").val('');
            $("#boatNumberOfSeat").val('');
            $("#boatActualPrice").val('');
 //           $('#formEditRooms').hide();

            boatTable.ajax.reload();
        },
        error: function () {
            alert('Please Try Again');
        }
    });
}


function deleteBoat(boatId) {
    $.ajax({
        url: "api/boats/" + boatId,
        type: "DELETE",
        success: function () {
            alert('The boat has deleted!');
            boatTable.ajax.reload();
        }
    });
}
function updateBoat(boatId) {
    var boat = {
        boatNumber: ($("#boatNumberEdit").val()),
        boatPrice: Number($("#boatPriceEdit").val()),
        boatType: $("#boatTypeEdit").val(),
        boatNumberOfSeat: $("#boatNumberOfSeatEdit").val(),
        boatActualPrice: $("#boatActualPriceEdit").val(),



    };
    var jsonObject = JSON.stringify(boat);

    $.ajax({
        url: "api/boats/" + boatId,
        type: "PUT",
        contentType: "application/json",
        data: jsonObject,
        success: function () {
            alert('The boat has just been updated!');
            boatTable.ajax.reload();
        },
        error: function () {
            alert('Please Try Again');
        }
    });
}
$(document).ready(function () {
    getBoats();
});














