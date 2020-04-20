function getGuests() {
    $.get("api/guests", function (guests) {
        displayGuests(guests);
    });
}

$(document).ready(function () {


  $.get("api/guests", function (guests) {

        displayGuests(guests);
    });

    $('#savePop').click(function () {
        createGuest();
        //alert(createGuest());
        $.get("api/guests", function (guests) {

            displayGuests(guests);
        });
    });

});
function postGuest(guest) {
    var jsonGuest = JSON.stringify(guest);
    $.ajax({
        url: "api/guests",
        type: "post",
        contentType: "application/json",
        data: jsonGuest,
        success: function () {
            alert('You Registered a new guest.');

            getGuests();
        },
        error: function () {

            alert('something went wrong.');
        }
    });
}

function createGuest() {
    var guestName = $('#createGuestNameInput').val();
    var guestIdType = $('#createGuestIdTypeInput').val();
    var guestIdNumber = $('#createGuestIdNumberInput').val();
    var guestPhoneNumber = $('#createGuestPhoneNumberInput').val();



    var guest = {
        name: guestName,
        idType: guestIdType,
        idNumber: guestIdNumber,
        phoneNumber: guestPhoneNumber,

    };

    postGuest(guest);
}
var guestIdDelete
var guestIdEdit
function displayGuests(guests) {
    var guestContainer = $('#guestContainer');
    guestContainer.empty();
    $.each(guests, function (index, guest) {
        $('#guestContainer').append(' <tr><td> '
            + guest.name + '  </td><td> '
            + guest.idType + '  </td><td> '
            + guest.idNumber + '  </td><td> '
            + guest.phoneNumber + '  </td><td><button class="remove-button" guestId="'
            + guest.id + '">delete</button></td><td><button class="edit-button" guestId="' + guest.id + '">edit</button></td></tr>');
    });




   $('#guestContainer .edit-button').click(function () {
        var guestData =


            guestIdEdit = $(this).attr('guestId');


        $.get('/api/guests/' + guestIdEdit, function (guest) {

            var guestName = $('#createGuestNameInput').val();
            var guestIdType = $('#createGuestIdTypeInput').val();
            var guestIdNumber = $('#createGuestIdNumberInput').val();
            var guestPhoneNumber = $('#createGuestPhoneNumberInput').val();

        });
    });

    $('#guestContainer .remove-button').click(function () {

            guestIdDelete = $(this).attr('guestId');

        });

    var guestId

    function deleteGuest(guestId) {
        $.ajax({
            url: "api/guests/" + guestId,
            type: "DELETE",
            success: function () {
                alert('The boat has deleted!');
                guestContainer.ajax.reload();
            }
        });
    }

    }
