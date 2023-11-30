function submitForm(){
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var Mensage = document.getElementById('Mensage').value;
    var option = document.getElementById('Motivos').value;

    
    if(name==''||email==''||Mensage==''||option == ''){
        alert('Preencha os locais em branco')
    }else{
        alert(name + ' ' + email + ' ' + Mensage + ' ' + option + ' ~~~~Informacoes Enviadas')
    }

}