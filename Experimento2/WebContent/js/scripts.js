///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//$(document).ready(function() {
//
//    $("#includeSidebar").load("sidebar.html"); 
//
//    if ($(".numPacientes").length > 0) 
//
//    $.ajax({
//        url: "http://mentaltest.herokuapp.com/servicios/pacientes/getAll"
//        }).then(function(data) {
//       $('.numPacientes').append(data.length);
//    });
//    
//    if ($(".numEpisodios").length > 0) 
//
//    $.ajax({
//        url: "http://mentaltest.herokuapp.com/servicios/episodios/getAll"
//        }).then(function(data) {
//       $('.numEpisodios').append(data.length);
//    });
//    
//});
//
//function loadPacientes() {
//    var cedula = getUrlParameter('cedula');
//    
//    if (cedula == null)
//    {
//        $.ajax({
//            url: "http://mentaltest.herokuapp.com/servicios/pacientes/getAll"
//            }).then(function(data) {
//           for (var i = 0; i < data.length; i++){
//               //var cantidadEps = getCantidadEpisodios(data[i].id);
//                $('.tablaPacientes').append('<tr id='+data[i].documento+'><td>'+data[i].documento+'</td><td>'+data[i].nombre+'</td><td>'+data[i].apellido+'</td><td>'+data[i].genero+'</td><td>'+data[i].direccion+'</td><td>'+data[i].telefonofijo+'</td><td>'+data[i].telefonocelular+'</td>');
//               getCantidadEpisodios(data[i].documento);    
//          }
//        });
//    } else {
//        $.ajax({
//            url: "http://mentaltest.herokuapp.com/servicios/pacientes/get?id="+cedula
//            }).then(function(data) {
//           
//           console.log(data);
//                      
//            var paciente =  data;
//            if (paciente == null){
//                $('.tablaPacientes').append('<div id="alertNotFound" class="alert success fade in" data-alert="alert">No se encontr&oacute; el paciente</div>');
//                
//            } else {
//                $('.tablaPacientes').append('<tr id='+paciente.documento+'><td>'+paciente.documento+'</td><td>'+paciente.nombre+'</td><td>'+paciente.apellido+'</td><td>'+paciente.genero+'</td><td>'+paciente.direccion+'</td><td>'+paciente.telefonofijo+'</td><td>'+paciente.telefonocelular+'</td>');
//               getCantidadEpisodios(paciente.documento);
//            }
//        });
//    }
//}
//
//
//function getCantidadEpisodios(documento){
//    $.ajax({
//        url: "http://mentaltest.herokuapp.com/servicios/episodios/paciente?id="+documento
//        }).then(function(data) {
//            console.log(data.length);
//           $('#'+documento).append('<td>'+data.length+'</td><td><button onClick="loadEpisodiosPaciente('+documento+')">Ver episodios</button></td></tr>');
//    });
//}
//
//function loadEpisodiosPaciente(id){
//    window.location = 'episodios.html?idPaciente='+id;
//}
//
//function searchPaciente() {
//    var cedula = document.getElementById("cedulaPaciente").value;
//    window.location = 'pacientes.html?cedula='+cedula;
//}
//
//function loadEpisodios() {
//    var idP = getUrlParameter('idPaciente');
//    
//    if (idP == null)
//    {
//        $.ajax({
//            url: "http://mentaltest.herokuapp.com/servicios/episodios/getAll"
//            }).then(function(data) {
//           for (var i = 0; i < data.length; i++){
//               //var cantidadEps = getCantidadEpisodios(data[i].id);
//                $('.tablaEpisodios').append('<tr id='+data[i].id+'><td>'+data[i].documentopaciente+'</td><td>'+addIfNotNull(data[i].fechaepisodio)+'</td><td>'+addIfNotNull(data[i].hora)+'</td><td>'+addIfNotNull(data[i].niveldolor)+'</td><td>'+addIfNotNull(data[i].localizacion)+'</td><td>'+addIfNotNull(data[i].patronsueno)+'</td><td><button type="button" data-toggle="modal" data-target="#modalEp'+data[i].id+'">Ver</button></td>'); 
//                $('.tablaEpisodios').append('<!-- Modal -->'+
//                 '<div class="modal fade" id="modalEp'+data[i].id+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'+
//                 '<div class="modal-dialog">'+
//                 '<div class="modal-content">'+
//                 '<div class="modal-header">'+
//                 '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
//                 '<h4 class="modal-title" id="myModalLabel">Alimentos, bebidas, medicamentos, etc</h4>'+
//                 '</div>'+
//                 '<div class="modal-body">'+
//        'Alimentos: '+ addIfNotEmpty(data[i].alimentos)+ '<br>'+
//        'Bebidas: '+ addIfNotEmpty(data[i].bebidas) + '<br>'+
//        'Medicamentos: '+ addIfNotEmpty(data[i].medicamentos) + '<br>'+
//        'Actividad F&iacute;sica: '+ addIfNotEmpty(data[i].actividadFisica) + '<br>'+
//      '</div>'+
//      '<div class="modal-footer">'+
//        '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'+
//      '</div>'+
//    '</div>'+
//  '</div>'+
//'</div>'); 
//        }
//       
//        });
//    } else {
//        $.ajax({
//            url: "http://mentaltest.herokuapp.com/servicios/episodios/paciente?id="+idP
//            }).then(function(data) {
//           for (var i = 0; i < data.length; i++){
//               //var cantidadEps = getCantidadEpisodios(data[i].id);
//               $('#epTitle').append(' - Paciente: '+ data[i].documentoPaciente);
//               $('.tablaEpisodios').append('<tr id='+data[i].id+'><td>'+data[i].documentoPaciente+'</td><td>'+addIfNotNull(data[i].fechaEpisodio)+'</td><td>'+addIfNotNull(data[i].hora)+'</td><td>'+addIfNotNull(data[i].nivelDolor)+'</td><td>'+addIfNotNull(data[i].localizacion)+'</td><td>'+addIfNotNull(data[i].patronSueno)+'</td><td><button type="button" data-toggle="modal" data-target="#modalEp'+data[i].id+'">Ver</button></td>'); 
//               $('.tablaEpisodios').append('<!-- Modal -->'+
//                 '<div class="modal fade" id="modalEp'+data[i].id+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'+
//                 '<div class="modal-dialog">'+
//                 '<div class="modal-content">'+
//                 '<div class="modal-header">'+
//                 '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
//                 '<h4 class="modal-title" id="myModalLabel">Alimentos, bebidas, medicamentos, etc</h4>'+
//                 '</div>'+
//                 '<div class="modal-body">'+
//        'Alimentos: '+ addIfNotEmpty(data[i].alimentos)+ '<br>'+
//        'Bebidas: '+ addIfNotEmpty(data[i].bebidas) + '<br>'+
//        'Medicamentos: '+ addIfNotEmpty(data[i].medicamentos) + '<br>'+
//        'Actividad F&iacute;sica: '+ addIfNotEmpty(data[i].actividadFisica) + '<br>'+
//      '</div>'+
//      '<div class="modal-footer">'+
//        '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'+
//      '</div>'+
//    '</div>'+
//  '</div>'+
//'</div>'); 
//        }
//       
//        });
//    }
//}
//
//function getUrlParameter(sParam)
//{
//    var sPageURL = window.location.search.substring(1);
//    var sURLVariables = sPageURL.split('&');
//    for (var i = 0; i < sURLVariables.length; i++) 
//    {
//        var sParameterName = sURLVariables[i].split('=');
//        if (sParameterName[0] == sParam) 
//        {
//            return sParameterName[1];
//        }
//    }
//}  
//
//
//
//function addIfNotNull(param){
//    if (param == null)
//        return "";
//    else
//        return param;
//}
//
//function addIfNotEmpty(array){
//    if (array.length > 0)
//        return array;
//    else
//        return "No existe información";
//}
//
//function test() {
//    console.log("plop");
//}
//

/* 
 *			For Heroku deployment 
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {

    $("#includeSidebar").load("sidebar.html"); 

    if ($(".numPacientes").length > 0) 

    $.ajax({
        url: "https://mentaltest.herokuapp.com/servicios/pacientes/getAll"
        }).then(function(data) {
       $('.numPacientes').append(data.length);
    });
    
    if ($(".numEpisodios").length > 0) 

    $.ajax({
        url: "https://mentaltest.herokuapp.com/servicios/episodios/getAll"
        }).then(function(data) {
       $('.numEpisodios').append(data.length);
    });
    
});

function loadPacientes() {
    var cedula = getUrlParameter('cedula');
    
    if (cedula == null)
    {
        $.ajax({
            url: "https://mentaltest.herokuapp.com/servicios/pacientes/getAll"
            }).then(function(data) {
           for (var i = 0; i < data.length; i++){
               //var cantidadEps = getCantidadEpisodios(data[i].id);
                $('.tablaPacientes').append('<tr id='+data[i].documento+'><td>'+data[i].documento+'</td><td>'+data[i].nombre+'</td><td>'+data[i].apellido+'</td><td>'+data[i].genero+'</td><td>'+data[i].direccion+'</td><td>'+data[i].telefonofijo+'</td><td>'+data[i].telefonocelular+'</td>');
               getCantidadEpisodios(data[i].documento);    
          }
        });
    } else {
        $.ajax({
            url: "https://mentaltest.herokuapp.com/servicios/pacientes/get?id="+cedula
            }).then(function(data) {
           
           console.log(data);
                      
            var paciente =  data;
            if (paciente == null){
                $('.tablaPacientes').append('<div id="alertNotFound" class="alert success fade in" data-alert="alert">No se encontr&oacute; el paciente</div>');
                
            } else {
                $('.tablaPacientes').append('<tr id='+paciente.documento+'><td>'+paciente.documento+'</td><td>'+paciente.nombre+'</td><td>'+paciente.apellido+'</td><td>'+paciente.genero+'</td><td>'+paciente.direccion+'</td><td>'+paciente.telefonofijo+'</td><td>'+paciente.telefonocelular+'</td>');
               getCantidadEpisodios(paciente.documento);
            }
        });
    }
}


function getCantidadEpisodios(documento){
    $.ajax({
        url: "https://mentaltest.herokuapp.com/servicios/episodios/paciente?id="+documento
        }).then(function(data) {
            console.log(data.length);
           $('#'+documento).append('<td>'+data.length+'</td><td><button onClick="loadEpisodiosPaciente('+documento+')">Ver episodios</button></td></tr>');
    });
}

function loadEpisodiosPaciente(id){
    window.location = 'episodios.html?idPaciente='+id;
}

function searchPaciente() {
    var cedula = document.getElementById("cedulaPaciente").value;
    window.location = 'pacientes.html?cedula='+cedula;
}

function loadEpisodios() {
    var idP = getUrlParameter('idPaciente');
    
    if (idP == null)
    {
        $.ajax({
            url: "https://mentaltest.herokuapp.com/servicios/episodios/getAll"
            }).then(function(data) {
           for (var i = 0; i < data.length; i++){
               //var cantidadEps = getCantidadEpisodios(data[i].id);
                $('.tablaEpisodios').append('<tr id='+data[i].id+'><td>'+data[i].documentopaciente+'</td><td>'+addIfNotNull(data[i].fechaepisodio)+'</td><td>'+addIfNotNull(data[i].hora)+'</td><td>'+addIfNotNull(data[i].niveldolor)+'</td><td>'+addIfNotNull(data[i].localizacion)+'</td><td>'+addIfNotNull(data[i].patronsueno)+'</td><td><button type="button" data-toggle="modal" data-target="#modalEp'+data[i].id+'">Ver</button></td>'); 
                $('.tablaEpisodios').append('<!-- Modal -->'+
                 '<div class="modal fade" id="modalEp'+data[i].id+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'+
                 '<div class="modal-dialog">'+
                 '<div class="modal-content">'+
                 '<div class="modal-header">'+
                 '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
                 '<h4 class="modal-title" id="myModalLabel">Alimentos, bebidas, medicamentos, etc</h4>'+
                 '</div>'+
                 '<div class="modal-body">'+
        'Alimentos: '+ addIfNotEmpty(data[i].alimentos)+ '<br>'+
        'Bebidas: '+ addIfNotEmpty(data[i].bebidas) + '<br>'+
        'Medicamentos: '+ addIfNotEmpty(data[i].medicamentos) + '<br>'+
        'Actividad F&iacute;sica: '+ addIfNotEmpty(data[i].actividadFisica) + '<br>'+
      '</div>'+
      '<div class="modal-footer">'+
        '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'+
      '</div>'+
    '</div>'+
  '</div>'+
'</div>'); 
        }
       
        });
    } else {
        $.ajax({
            url: "https://mentaltest.herokuapp.com/servicios/episodios/paciente?id="+idP
            }).then(function(data) {
           for (var i = 0; i < data.length; i++){
               //var cantidadEps = getCantidadEpisodios(data[i].id);
               $('#epTitle').append(' - Paciente: '+ data[i].documentoPaciente);
               $('.tablaEpisodios').append('<tr id='+data[i].id+'><td>'+data[i].documentoPaciente+'</td><td>'+addIfNotNull(data[i].fechaEpisodio)+'</td><td>'+addIfNotNull(data[i].hora)+'</td><td>'+addIfNotNull(data[i].nivelDolor)+'</td><td>'+addIfNotNull(data[i].localizacion)+'</td><td>'+addIfNotNull(data[i].patronSueno)+'</td><td><button type="button" data-toggle="modal" data-target="#modalEp'+data[i].id+'">Ver</button></td>'); 
               $('.tablaEpisodios').append('<!-- Modal -->'+
                 '<div class="modal fade" id="modalEp'+data[i].id+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'+
                 '<div class="modal-dialog">'+
                 '<div class="modal-content">'+
                 '<div class="modal-header">'+
                 '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
                 '<h4 class="modal-title" id="myModalLabel">Alimentos, bebidas, medicamentos, etc</h4>'+
                 '</div>'+
                 '<div class="modal-body">'+
        'Alimentos: '+ addIfNotEmpty(data[i].alimentos)+ '<br>'+
        'Bebidas: '+ addIfNotEmpty(data[i].bebidas) + '<br>'+
        'Medicamentos: '+ addIfNotEmpty(data[i].medicamentos) + '<br>'+
        'Actividad F&iacute;sica: '+ addIfNotEmpty(data[i].actividadFisica) + '<br>'+
      '</div>'+
      '<div class="modal-footer">'+
        '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'+
      '</div>'+
    '</div>'+
  '</div>'+
'</div>'); 
        }
       
        });
    }
}

function getUrlParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}  



function addIfNotNull(param){
    if (param == null)
        return "";
    else
        return param;
}

function addIfNotEmpty(array){
    if (array.length > 0)
        return array;
    else
        return "No existe información";
}

function test() {
    console.log("plop");
}


