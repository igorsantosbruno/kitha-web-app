// Wait for the DOM to be ready
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  var $password = $('input[name="password"]')
  var $confirmPassword = $('input[name="confirmPassword"]')
  $("form[name='formUserRegistration']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      //firstname: "required",
      //lastname: "required",
      userName: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
      },
      password: {
              required: true,
              // Specify that email should be validated
              // by the built-in "email" rule
            },
      name: {
                    required: true,
                    // Specify that email should be validated
                    // by the built-in "email" rule
                  },
    },
    // Specify validation error messages
    messages: {
      userName: "please inform the *user*",
      password: "please inform the *password*",
      name: "please inform the *name*"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      if($confirmPassword.val() != $password.val()){

        alert("the passwords do not match");
      }else{

        form.submit();
      }
    }
  });
});
