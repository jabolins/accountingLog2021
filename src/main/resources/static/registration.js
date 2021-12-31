document.getElementById('registrationForm').addEventListener("submit", checkForm);

function checkForm(event){ // event ir notikums kas tiek saņemts pēc addEventListener

    var element= document.getElementById('registrationForm');


    var date= element.date.value;
    var sum= element.sum.value;
    var transactionDocNr= element.transactionDocNr.value;
    var transactionPartner=element.transactionPartner.value;
    var transactionDescription=element.transactionDescription.value;
    var attitudeForBusiness=element.attitudeForBusiness.value;
    var bankCash= element.bankCash.value;

    var fail ="";

    if ( date==""
        || sum ==""
        || transactionDocNr==""
        || transactionPartner==""
        || transactionDescription==""
        || attitudeForBusiness ==""
        || bankCash==""){
        fail= "aipildiet visus laukus"
    }

    if (fail!="") {
        event.preventDefault(); //  šādi atslēdz standarta event rezultātu kas standartā ir lapas pārlādēšana.
// Mūsu gadījumā lapa nepārlādējas kamēr nav viss sarakstīts korekti
        document.getElementById('error').innerHTML= fail; // šādi nododam uz elementu error vērtību.
// Un no tā brīža tas var parādīties
        return false; // TODO tad lapa nepārlādēsies, bet varbūt šo var izņemt
    }
    else{
        alert("visi lauki aizpildīti korekti");
        return true}
}