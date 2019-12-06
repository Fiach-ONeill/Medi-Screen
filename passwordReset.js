function resetPass(){
var email = document.getElementById('email').value;

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






