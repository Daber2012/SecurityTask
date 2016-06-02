/**
 * Created by mrmas on 01.06.2016.
 */
$(document).ready(function(){
    $(".message").click(function(){
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });

    var submit = $(".register-form button[type='submit']");
    submit.prop('disabled', true);
    submit.css( "background", "#B3B2A9" );

    $(".register-form input[name='password']").on('input', function(){

        console.log(this.value);

        $.ajax({
            type : "POST",
            url : "/validate",
            contentType: 'application/json',
            data: this.value,
            success : function(response) {
                console.log("SUCCESS: ", response);

                if (response == 0) {
                    $(".pass-info").html('<p style="color: red;">Short password</p>');
                    submit.css( "background", "#B3B2A9" );
                    submit.prop('disabled', true);
                } else if (response == 1) {
                    $(".pass-info").html('<p style="color: #ff4d00;">Weak password</p>');
                    submit.css( "background", "#B3B2A9" );
                    submit.prop('disabled', true);
                } else if (response == 2) {
                    $(".pass-info").html('<p style="color: #ff9c23;">Medium password</p>');
                    submit.css( "background", "#00008B" );
                    submit.prop('disabled', false);
                } else if (response == 3) {
                    $(".pass-info").html('<p style="color: green;">Good password</p>');
                    submit.css( "background", "#00008B" );
                    submit.prop('disabled', false);
                }
            },
            error : function(e) {
                console.log("ERROR: ", e);

            },
            done : function(e) {
                console.log("DONE");
            }
        });

    })
});

