var guest

function getReservations() {
    $.get("api/reservations", function (reservation) {
        displayReservation(reservation);
    });
}
$(document).ready(function () {

    $.get("api/reservations", function (reservation) {

        displayReservation(reservation);
    });

    $('#getMakeReservation').click(function () {
        createReservation();
        //alert(createReservations());
        $.get("api/reservations", function (reservation) {

            displayReservation(reservation);
        });


    });
});

function postReservation(reservation) {
    var jsonReservation = JSON.stringify(reservation);
    $.ajax({
        url: "api/reservations",
        type: "post",
        contentType: "application/json",
        data: jsonReservation,
        success: function () {
            alert('You made a reservation.');

            getReservations();
        },
        error: function () {

            alert('something went wrong.');
        }
    });
}
function createReservation() {
    var reservationBoatType = $('#boatType').val();
    var reservationCheckInDate = $('#checkInDate').val();
    var reservationCheckOutDate = $('#checkOutDate').val();
    var reservationStartDate = $('#startTime').val();
    var reservationDuration = $('#duration').val();
    var reservationName = $('#name').val();
    var reservationPhoneNumber = $('#phoneNumber').val();

    var reservation = {
        boatType: reservationBoatType,
        checkInDate: reservationCheckInDate,
        checkOutDate: reservationCheckOutDate,
        startTime: reservationStartDate,
        duration: reservationDuration,
        name: reservationName,
        phoneNumber: reservationPhoneNumber,

    };

    postReservation(reservation);
}
var reservationIdDelete
function displayReservation(reservation) {
    var reservationContainer = $('#reservationContainer');
    reservationContainer.empty();
    $.each(reservation, function (index, reservation) {
        $('#reservationContainer').append(' <tr><td> '
            + reservation.boatType + '  </td><td> '
            + reservation.checkInDate + '  </td><td> '
            + reservation.checkOutDate + '  </td><td> '
            + reservation.startTime + '  </td><td> '
            + reservation.duration + '  </td><td> '
            + reservation.name + '  </td><td> '
            + reservation.phoneNumber + '  </td><td><button class="remove-button" reservationId="'
            + reservation.id + '">Cancel</button></td><td>');
    });


    $("#reservationContainer .remove-button").click(function () {

        reservationIdDelete = $(this).attr('reservationId');
    });



    var reservationId

    function deleteReservation(reservationId) {
    var reservationId= reservationIdDeleteId;
        $.ajax({
            url: "api/reservations" + reservationId,
            type: "DELETE",
            success: function () {
                alert('The reservation has cancelled!');
                reservationContainer.ajax.reload();
            }
        });
    }

}