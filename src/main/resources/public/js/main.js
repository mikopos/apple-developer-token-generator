(function ($) {

  "use strict";

  // Form
  let contactForm = function () {
    if ($('#contactForm').length > 0) {
      $("#contactForm").validate({
        rules: {
          teamId: "required",
          keyId: "required",
          secret: {
            required: true,
            minlength: 5
          }
        },
        messages: {
          teamId: "Please enter your team id",
          keyId: "Please enter a valid key id",
          secret: "Please enter your private key"
        },
        /* submit via ajax */

        submitHandler: function (form) {
          let $submit = $('.submitting'),
              waitText = 'Submitting...';

          $.ajax({
            type: "POST",
            url: "/generate",
            data: $(form).serialize(),

            beforeSend: function () {
              $submit.css('display', 'block').text(waitText);
            },
            success: function (msg) {
              if (msg !== null) {
                $('#form-message-warning').hide();
                setTimeout(function () {
                  $('#contactForm').fadeIn();
                }, 1000);
                setTimeout(function () {
                  $('#form-message-success').html(
                      "Your generated token is : <br> <br>" + msg);
                  $('#form-message-success').fadeIn();
                }, 1400);

                setTimeout(function () {
                  $submit.css('display', 'none').text(waitText);
                }, 1400);

              } else {
                $('#form-message-warning').html(msg);
                $('#form-message-warning').fadeIn();
                $submit.css('display', 'none');
              }
            },
            error: function () {
              $('#form-message-warning').html(
                  "Something went wrong. Please try again.");
              $('#form-message-warning').fadeIn();
              $submit.css('display', 'none');
            }
          });
        } // end submitHandler

      });
    }
  };
  contactForm();

})(jQuery);
