auth.onAuthStateChanged(function(user) {
  if (user) {

    firebase.database().ref('Medics/' + user.uid).once('value').then(function(snapshot){

      var code = snapshot.val().code;

      var codeTest = snapshot.child("code").val();
      var email = snapshot.child("email").val();
      var firstName = snapshot.child("firstName").val();
      var lastName = snapshot.child("lastName").val();

      $("#code").append("  " + codeTest);
      $("#email").append("  " + email);
      $("#fName").append("  " + firstName);
      $("#lName").append("  " + lastName);

      var ref = firebase.database().ref().child("Patients").orderByChild("medicCode").equalTo(code);

      ref.on('value', snap=>{

      snap.forEach(userSnapshot=>{

        var key = userSnapshot.key;

        var patientRef = firebase.database().ref().child("Patients").child(key);

        patientRef.on("value", snap => {

              var firstName = snap.child("firstName").val();
              var lastName = snap.child("lastName").val();
              var email = snap.child("email").val();
              var dob = snap.child("dateOfBirth").val();
              var gender = snap.child("gender").val();
              var age = snap.child("age").val();

              $("#table_body").append("<tr><td>" + firstName + "</td><td>" + lastName + "</td><td>" + email + "</td><td>" + dob + "</td><td>" + gender + "</td><td>" + age + "</td></tr>");

        });
        //window.alert(key);
      });

      });

    });

  } else {
    // No user is signed in.
  }
});



const logout = document.querySelector('#logoutButton');


// logout

logout.addEventListener('click', e=> {

e.preventDefault();
auth.signOut().then(() =>{

console.log('user signed out');
window.location = 'index.html'

});

});

// register users
function register(){
  var firstName = document.getElementById('firstName').value;
  var lastName = document.getElementById('lastName').value;
  var email = document.getElementById('email').value;
  var password = document.getElementById('password').value;
  var code = document.getElementById('code').value;
  var repeatPassword = document.getElementById('repeatPassword').value;
  var firebaseRef = firebase.database().ref();
  var user = firebase.auth().currentUser;
  firebase.auth().createUserWithEmailAndPassword(email, password).then(function(user){



    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var code = document.getElementById('code').value;
    var repeatPassword = document.getElementById('repeatPassword').value;
    var firebaseRef = firebase.database().ref();
    var user = firebase.auth().currentUser;
    firebaseRef.child("Medics").child(user.uid).set({

      firstName:firstName,
      lastName:lastName,
      email:email,
      code:code

    });



// Retrieving medic code to identify doctor patients


    window.alert("Account successfully created");
    window.location = 'index.html'

  }).catch(function(error) {
  // Handle Errors here.
  var errorCode = error.code;
  var errorMessage = error.message;
  window.alert("Invalid Details, please try again");
  // ...
});





}


function login(){

var userEmail = document.getElementById('theEmail').value;
var userPass = document.getElementById('thePassword').value;


auth.signInWithEmailAndPassword(userEmail, userPass).then(function(user){





window.location = 'medic.html'


}).catch(function(error) {
  // Handle Errors here.
  var errorCode = error.code;
  var errorMessage = error.message;


  window.alert("Error " + errorMessage);
  // ...
});


}

function resetPass(){
var email = document.getElementById('theEmail').value;

firebase.auth().sendPasswordResetEmail(email).then(function(){

window.alert("Password Reset Email Sent");

}).catch(function (error){

var errorCode = error.code;
var errorMessage = error.message;
if(errorCode == 'auth/invalid-email'){

window.alert(errorMessage);


}else if (errorCode == 'auth/user-not-found'){



window.alert(errorMessage);

}

});


}

function search(){

  var searchItem = document.getElementById('searchName').value;
  window.alert(searchItem);


window.location = 'patient.html'


}
