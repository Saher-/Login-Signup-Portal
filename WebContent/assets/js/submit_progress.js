/** 
 * This code is only used for animating the progress bar
 *     it can be safely removed
 *     as all styling is done in CSS
 */
var progressVal = $('progress').val(),
    progressStep = 25,
    progressDirection = 1,
    name, pin, pinC, email, phone, dob, 
    pref = [],
    lang = [];

// setInterval(function() {
//   console.log(progressDirection, progressVal);
  
//   if (progressDirection > 0 && progressVal < 100) {
//     progressVal += progressStep;
//     $('progress').val(progressVal);
//   } else if (progressDirection < 0 && progressVal > 0) {
//     progressVal -= progressStep;
//     $('progress').val(progressVal);
//   } else if (progressVal == 100) {
//     progressDirection = -1;
//   } else if (progressVal == 0) {
//     progressDirection = 1;
//   }
// }, 500)

function customSubmit(){
  if (progressVal == 75){
    var ret = getvals_1()
    if (ret == true) { next() }
  }
  else if (progressVal == 50){
    var ret = getvals_2()
    if (ret == true) { next() }
  }
  else if (progressVal == 25){
    var ret = getvals_3()
    if (ret == true) { next(); }
  }
}

function getvals_1(){
  name = document.getElementById("name").value;
  pin = document.getElementById("password").value;
  pinC = document.getElementById("passwordC").value;
  if (name == null || name == "") {
    alert("Name is REQUIRED");
    console.log("Name is REQUIRED");
    return false;
  }
  else if (pin == null || pin == "") {
    alert("Password is REQUIRED");
    console.log("Password is REQUIRED");
    return false;
  }
  else if (pinC == null || pinC == "") {
    alert("Password Confirmation is REQUIRED!");
    console.log("Password Confirmation is REQUIRED!");
    return false;
  }
  else if (pin != pinC) {
    alert("Password entries don't match!");
    console.log("Password entries don't match!");
    return false;
  }
  else {
    alert(name + "-----" + pin);
    console.log(name + "-----" + pin);
    return true;
  }
}

function getvals_2(){
  email = document.getElementById("email").value;
  phone = document.getElementById("phone").value;
  dob = document.getElementById("month").value;
  dob += "-" + document.getElementById("day").value;
  dob += "-" + document.getElementById("year").value;

  var atpos = email.indexOf("@");
  var dotpos = email.lastIndexOf(".");
  if (atpos < 1 || dotpos < atpos+2 || dotpos+2 >= email.length || email == null || email == "") {
    alert("Not a valid e-mail address!");
    console.log("Not a valid e-mail address!");
    return false;
  }
  else if (phone.length != 10 || isNaN(phone) || phone == null || phone == "") {
    alert("Not a valid phone number!");
    console.log("Not a valid phone number!");
    return false;
  }
  else {
    if (dob == "--") { 
      alert(email + "\n" + phone + "\n" + "00-00-0000");
      console.log(email + "\n" + phone + "\n" + "00-00-0000");
    }
    else { 
      alert(email + "\n" + phone + "\n" + dob);
      console.log(email + "\n" + phone + "\n" + dob);
      }
    return true;
  }
}

function getvals_3() {
  var inpfields = document.getElementById("preferences").getElementsByTagName('input');
  var nr_inpfields = inpfields.length;

  for(var i = 0; i < nr_inpfields; i++) {
    if(inpfields[i].type == 'checkbox' && inpfields[i].checked == true) {
      pref.push(inpfields[i].id);
    }
  }

  inpfields = null;
  nr_inpfields = null;
  
  inpfields = document.getElementById("language").getElementsByTagName('input');
  nr_inpfields = inpfields.length;  

  for(var i = 0; i < nr_inpfields; i++) {
    if(inpfields[i].type == 'checkbox' && inpfields[i].checked == true) {
      lang.push(inpfields[i].id);
    }
  }

  alert (pref + "---" + lang);
  console.log(pref + "---" + lang);
  return true;
}

function pass() {
  document.getElementById("f_name").value = name;
  document.getElementById("f_pin").value = pin;
  document.getElementById("f_email").value = email;
  document.getElementById("f_phone").value = phone;
  document.getElementById("f_dob").value = dob;
  document.getElementById("f_pref").value = pref;
  document.getElementById("f_lang").value = lang;
  console.log("Submitting Form...");
  document.final.submit();
}

function next(){
  console.log(progressDirection, progressVal);
  progressVal -= progressStep;
  $('progress').val(progressVal);

    if (progressVal == 50) {
    document.getElementById("signUp1").style.display="none"
    document.getElementById("signUp2").style.display=""
  }
    else if (progressVal == 25) {
    document.getElementById("signUp2").style.display="none"
    document.getElementById("signUp3").style.display=""
  }
  else if (progressVal == 0) {
    document.getElementById("signUp3").style.display="none"
    document.getElementById("signUp4").style.display=""
    document.getElementById("check").style.display=""
    alert("DONE!");
    console.log("DONE!");
    setTimeout(pass(), 10000);
  }
}

function prev(){
  console.log(progressDirection, progressVal);
  progressVal += progressStep;
  $('progress').val(progressVal);

  if (progressVal == 25) {
    document.getElementById("check").style.display="none"
    document.getElementById("signUp4").style.display="none"
    document.getElementById("signUp3").style.display=""
  }
  else if (progressVal == 50) {
    document.getElementById("signUp3").style.display="none"
    document.getElementById("signUp2").style.display=""
  }
  else if (progressVal == 75) {
    document.getElementById("signUp2").style.display="none"
    document.getElementById("signUp1").style.display=""
  }
}