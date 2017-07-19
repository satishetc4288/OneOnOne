$( function() {
     $('.login-button').click(function(){
         //alert('1');
         $('.login-form').addClass("hide");
         $('.landing').removeClass("hide");
     });

     //
     var availableTags = [
         "ActionScript",
         "AppleScript",
         "Asp",
         "BASIC",
         "C",
         "C++",
         "Clojure",
         "COBOL",
         "ColdFusion",
         "Erlang",
         "Fortran",
         "Groovy",
         "Haskell",
         "Java",
         "JavaScript",
         "Lisp",
         "Perl",
         "PHP",
         "Python",
         "Ruby",
         "Scala",
         "Scheme"
     ];
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