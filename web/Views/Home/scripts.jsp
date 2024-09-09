
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script src="js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>

<script src="data_tables/datatables.min.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.0/dist/chart.min.js"></script>


<script>
    // Users Section Start----------------------------------------------------------
    $(document).on('click', '#modal-add-users', function () {
        var title = "Confirm Registration", buttonText = "Save", buttonClass = "btn btn-primary", url = "Users?page=Add";
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Users", formMethod = "POST", actionType = "Insert";
        changeForm(actionURL, formMethod, actionType);
    });

    $(document).on('click', '#modal-edit-users', function () {
        var title = "Confirm Modification", buttonText = "Update", buttonClass = "btn btn-warning", url = 'Users?page=Edit&userId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Users", formMethod = "POST", actionType = "Update";
        changeForm(actionURL, formMethod, actionType);
    });

    $(document).on('click', '#modal-delete-users', function () {
        var title = "Confirm Deletion", buttonText = "Delete", buttonClass = "btn btn-danger", url = 'Users?page=Delete&userId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Users", formMethod = "GET", actionType = "Delete";
        changeForm(actionURL, formMethod, actionType);
    });
    // Users Section End------------------------------------------------------------
//
//
//
    // Facility Section Start----------------------------------------------------------
    $(document).on('click', '#modal-add-facility', function () {
        var title = "Confirm Registration", buttonText = "Save", buttonClass = "btn btn-primary", url = "Facilities?page=Add";
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Facilities", formMethod = "POST", actionType = "Insert";
        changeForm(actionURL, formMethod, actionType);
    });

    $(document).on('click', '#modal-edit-facility', function () {
        var title = "Confirm Modification", buttonText = "Update", buttonClass = "btn btn-warning", url = 'Facilities?page=Edit&facilityId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Facilities", formMethod = "POST", actionType = "Update";
        changeForm(actionURL, formMethod, actionType);
    });

    $(document).on('click', '#modal-delete-facility', function () {
        var title = "Confirm Deletion", buttonText = "Delete", buttonClass = "btn btn-danger", url = 'Facilities?page=Delete&facilityId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Facilities", formMethod = "GET", actionType = "Delete";
        changeForm(actionURL, formMethod, actionType);
    });
    // Facility Section End------------------------------------------------------------
//
//
//
    // Services Section Start---------------------------------------------------
    $(document).on('click', '#modal-add-services', function () {
        var title = "Confirm Registration", buttonText = "Save", buttonClass = "btn btn-primary", url = "Services?page=Add";
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Services", formMethod = "POST", actionType = "Insert";
        changeForm(actionURL, formMethod, actionType);
    });

    $(document).on('click', '#modal-edit-services', function () {
        var title = "Confirm Modification", buttonText = "Update", buttonClass = "btn btn-warning", url = 'Services?page=Edit&serviceId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Services", formMethod = "POST", actionType = "Update";
        changeForm(actionURL, formMethod, actionType);
    });

    $(document).on('click', '#modal-delete-services', function () {
        var title = "Confirm Deletion", buttonText = "Delete", buttonClass = "btn btn-danger", url = 'Services?page=Delete&serviceId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Services", formMethod = "GET", actionType = "Delete";
        changeForm(actionURL, formMethod, actionType);
    });
    //Services Section End------------------------------------------------------
//
//
//
    // Offers Section Start-------------------------------------------------------
    $(document).on('click', '#modal-add-offers', function () {
        var title = "Confirm Registration", buttonText = "Save", buttonClass = "btn btn-primary", url = "Offers?page=Add";
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Offers", formMethod = "POST", actionType = "Insert";
        changeForm(actionURL, formMethod, actionType);
    });

    $(document).on('click', '#modal-edit-offers', function () {
        var title = "Confirm Modification", buttonText = "Update", buttonClass = "btn btn-warning", url = 'Offers?page=Edit&offerId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Offers", formMethod = "POST", actionType = "Update";
        changeForm(actionURL, formMethod, actionType);
    });

    $(document).on('click', '#modal-delete-offers', function () {
        var title = "Confirm Deletion", buttonText = "Delete", buttonClass = "btn btn-danger", url = 'Offers?page=Delete&offerId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Offers", formMethod = "GET", actionType = "Delete";
        changeForm(actionURL, formMethod, actionType);
    });
    // Offers Section End--------------------------------------------------------- 
//
//
//
   // Reservation Section Start-------------------------------------------------------
    $(document).on('click', '#modal-add-reservations', function () {
        var title = "Confirm Registration", buttonText = "Save", buttonClass = "btn btn-primary", url = "Reservations?page=Add";
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Reservations", formMethod = "POST", actionType = "Insert";
        changeForm(actionURL, formMethod, actionType);
    });

    $(document).on('click', '#modal-edit-reservations', function () {
        var title = "Confirm Modification", buttonText = "Update", buttonClass = "btn btn-warning", url = 'Reservations?page=Edit&reservationId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Reservations", formMethod = "POST", actionType = "Update";
        changeForm(actionURL, formMethod, actionType);
    });

    $(document).on('click', '#modal-delete-reservations', function () {
        var title = "Confirm Deletion", buttonText = "Delete", buttonClass = "btn btn-danger", url = 'Reservations?page=Delete&reservationId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Reservations", formMethod = "GET", actionType = "Delete";
        changeForm(actionURL, formMethod, actionType);
    });
    
        $(document).on('click', '#modal-info-reservations', function () {
        var title = "Customer Information", buttonText = "Close", buttonClass = "hide-button", url = 'Reservations?page=Info&customerId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);
//
//        var actionURL = "", formMethod = "", actionType = "";
//        changeForm(actionURL, formMethod, actionType);
    });
    // Reservation Section End--------------------------------------------------------- 
    // 
    //  
    //   
    //    
    // Payments Section Start-------------------------------------------------------
    
    $(document).on('click', '#modal-edit-payments', function () {
        var title = "Confirm Modification", buttonText = "Update", buttonClass = "btn btn-warning", url = 'Payments?page=Edit&paymentId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "Payments", formMethod = "POST", actionType = "Update";
        changeForm(actionURL, formMethod, actionType);
    });
// Payments Section End---------------------------------------------------------


// Customer Section Start-----------------------------------------------------
    $(document).on('click', '#modal-add-myInquiries', function () {
        var title = "Write Inquiries", buttonText = "Send", buttonClass = "btn btn-primary", url = "MyInquiries?page=Add";
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "MyInquiries", formMethod = "POST", actionType = "Insert";
        changeForm(actionURL, formMethod, actionType);
    });
    
        $(document).on('click', '#modal-delete-myInquiries', function () {
        var title = "Deleting the record !", buttonText = "Delete", buttonClass = "btn btn-danger", url = 'MyInquiries?page=Delete&inquiryId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "MyInquiries", formMethod = "GET", actionType = "Delete";
        changeForm(actionURL, formMethod, actionType);
    });
    
    $(document).on('click', '#modal-add-my-reservations', function () {
        var title = "Confirm Reservation", buttonText = "Save", buttonClass = "btn btn-primary", url = "MyReservations?page=Add";
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "MyReservations", formMethod = "POST", actionType = "Insert";
        changeForm(actionURL, formMethod, actionType);
    });
    
        $(document).on('click', '#modal-delete-my-reservations', function () {
        var title = "Deleting the record !", buttonText = "Delete", buttonClass = "btn btn-danger", url = 'MyReservations?page=Delete&reservationId=' + $(this).data('test-id');
        openModal(title, buttonText, buttonClass, url);

        var actionURL = "MyReservations", formMethod = "GET", actionType = "Delete";
        changeForm(actionURL, formMethod, actionType);
    });
// Customer Section End-------------------------------------------------------

// Visitor Section Start--------------------------------------------------------
    $(document).on('click', '#modal-download-visitor', function () {
        var url = 'Visitor?page=Download&appointmentId=' + $(this).data('test-id');
        window.open(url);
    });
// Visitor Section End----------------------------------------------------------

// Sign Out Section-------------------------------------------------------------
    $(document).on('click', '.logout-btn', function () {
        $.get('Login?page=signout', function (response) {
            window.location.replace(response.redirectUrl);
        });
    });
// Sign Out Section-------------------------------------------------------------

// Functions Start--------------------------------------------------------------
    function openModal(title, buttonText, newButtonClass, pageURL) {
        var currentButtonClass = $('#modal-button').attr('class');
        $('#modal-body').empty();
        $('#modal-title-label').text(title);
        $('#modal-button').text(buttonText).removeClass(currentButtonClass).addClass(newButtonClass);
        $('#modal-body').load(pageURL);
    }
    function changeForm(actionURL, formMethod, actionType) {
        $('#modal-form').attr('action', actionURL).attr('method', formMethod);
        $('#modal-hidden').attr('value', actionType);
    }
// Functions End----------------------------------------------------------------


// List Populatin Section
    $(document).on('change', '#technician_id', function () {
        var selectedTechnicianId = $(this).val();
        $.ajax({
            type: "GET",
            url: "Appointments",
            data: {"page": "TestsList", "technicianId": selectedTechnicianId},
            dataType: "json",
            success: function (data) {
                $('#test_id').empty();
                $.each(data, function (key, value) {
                    $('#test_id').append('<option value="' + value.test_id + '">' + value.test_name + '</option>');
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Error: " + errorThrown);
            }
        });
    });
// List Populatin Section 

// ----------------------------------------------------------------------------------------------------------------------
    $(document).ready(function () {

        new DataTable('#abc_table');
        clockUpdate();
        setInterval(clockUpdate, 1000);
        if ($(window).width() > 768) {
            $('.side-nav').css('left', '0px');
        }

        $(window).resize(function () {
            if ($(window).width() > 768) {
                $('.side-nav').css('left', '0px');
            } else {
                $('.side-nav').css('left', '-250px');
            }
        });

        $('.toggle-btn').click(function () {
            $('.side-nav').css('left', function (index, value) {
                return value === '0px' ? '-250px' : '0px';
            });
        });

        $('.side-nav a').click(function (event) {
            event.preventDefault();
            $('.side-nav a').removeClass('active');
            $(this).addClass('active');

            var url = $(this).attr('href');
            $.ajax({
                url: url,
                type: 'GET',
                success: function (response) {
                    $('#content').html(response);
                    $('#abc_table').DataTable();
                }
            });
        });

        // Send a GET request
        $('#modal-form').submit(function (event) {
            event.preventDefault();
            var form = $(this);
            var url = form.attr('action');
            $.get(url, form.serialize(), function (response) {
                if (response != null) {
                    //refreshing the page
                    $.get(url, form.serialize(), function (response) {
                        $('#content').html(response);
                        $('#abc_table').DataTable();
                    });
                }
            });
        });

        // Send a POST request
        $('#modal-form').submit(function (event) {
            event.preventDefault();
            var form = $(this);
            var url = form.attr('action');
            $.post(url, form.serialize(), function (response) {
                if (response !== null) {
                    //refreshing the page
                    $.get(url, form.serialize(), function (response) {
                        $('#content').html(response);
                        $('#abc_table').DataTable();
                    });
                }
            });
        });

        $('#default').trigger('click');

    });


    function clockUpdate() {
        var date = new Date();

        function addZero(x) {
            return (x < 10) ? '0' + x : x;
        }

        function twelveHour(x) {
            return (x > 12) ? x - 12 : (x == 0) ? 12 : x;
        }

        var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        var day = days[date.getDay()];
        var month = date.toLocaleString('default', {month: 'long'});
        var year = date.getFullYear();

        var h = addZero(twelveHour(date.getHours()));
        var m = addZero(date.getMinutes());
        var s = addZero(date.getSeconds());

        $('#clock').html(day + ', ' + month + ' ' + date.getDate() + ', ' + year + ' ' + h + ':' + m + ':' + s);
    }

    (function () {
        'use strict';

        var forms = document.querySelectorAll('.needs-validation');

        Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault();
                            event.stopPropagation();
                        }

                        form.classList.add('was-validated');
                    }, false);
                });
    })();


    $(document).on('input', '#phone_number', function () {
        var phoneNumber = $(this).val().replace(/\D/g, ''); // Remove non-digit characters
        phoneNumber = phoneNumber.slice(0, 9); // Limit total length to 9 digits

        // Add +94 prefix if the number is valid
        if (phoneNumber.length === 9) {
            phoneNumber = '+94' + phoneNumber;
        }

        $(this).val(phoneNumber); // Update input value
    });
</script>