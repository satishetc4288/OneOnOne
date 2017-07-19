$( function() {
     $('.login-button').click(function(){
         //alert('1');
         $('.login-form').addClass("hide");
         $('.landing').removeClass("hide");
     });

     //
     $( "#tags, #tags2" ).autocomplete({
         source: availableTags
     });

     //
     $( "#datepicker" ).datepicker();

     //
     $('#basicExample, #basicExample2').timepicker();
     //
     $('.feedback-link').click(function(){
         $('#myModal').modal('show');
     });

 } );