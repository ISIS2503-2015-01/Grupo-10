/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {

    if ($(".numPacientes").length > 0) 

    $.ajax({
        url: "http://localhost:8080/pscm.servicios/webresources/Pacientes/getAll"
        }).then(function(data) {
       $('.numPacientes').append(data.length);
    });
    
    if ($(".numEpisodios").length > 0) 

    $.ajax({
        url: "http://localhost:8080/pscm.servicios/webresources/Episodios/getAll"
        }).then(function(data) {
       $('.numEpisodios').append(data.length);
    });
    
});

function loadPacientes() {
    $.ajax({
        url: "http://localhost:8080/pscm.servicios/webresources/Pacientes/getAll"
        }).then(function(data) {
       for (var i = 0; i < data.length; i++){
           //var cantidadEps = getCantidadEpisodios(data[i].id);
            $('.tablaPacientes').append('<tr id='+data[i].id+'><td>'+data[i].nombre+'</td><td>'+data[i].apellido+'</td><td>'+data[i].genero+'</td><td>'+data[i].direccion+'</td><td>'+data[i].telefonoFijo+'</td><td>'+data[i].telefonoCelular+'</td>');
            getCantidadEpisodios(data[i].id);    
       }
       
    });
}


function getCantidadEpisodios(id){
    $.ajax({
        url: "http://localhost:8080/pscm.servicios/webresources/Episodios/paciente?id="+id
        }).then(function(data) {
            console.log(data.length);
           $('#'+id).append('<td>'+data.length+'</td><td><button onClick="loadEpisodiosPaciente('+id+')">Ver episodios</button></td></tr>');
    });
}

function loadEpisodiosPaciente(id){
    window.location = 'episodios.html?idPaciente='+id;
}

function loadEpisodios() {
    var idP = getUrlParameter('idPaciente');
    
    if (idP == null)
    {
        $.ajax({
            url: "http://localhost:8080/pscm.servicios/webresources/Episodios/getAll"
            }).then(function(data) {
           for (var i = 0; i < data.length; i++){
               //var cantidadEps = getCantidadEpisodios(data[i].id);
                $('.tablaEpisodios').append('<tr id='+data[i].id+'><td>'+data[i].idPaciente+'</td><td>'+addIfNotNull(data[i].fechaEpisodio)+'</td><td>'+addIfNotNull(data[i].hora)+'</td><td>'+addIfNotNull(data[i].nivelDolor)+'</td><td>'+addIfNotNull(data[i].localizacion)+'</td><td>'+addIfNotNull(data[i].patronSueno)+'</td><td><button type="button" data-toggle="modal" data-target="#modalEp'+data[i].id+'">Ver</button></td>'); 
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
            url: "http://localhost:8080/pscm.servicios/webresources/Episodios/paciente?id="+idP
            }).then(function(data) {
           for (var i = 0; i < data.length; i++){
               //var cantidadEps = getCantidadEpisodios(data[i].id);
               $('#epTitle').append(' - Paciente: '+ data[i].idPaciente);
               $('.tablaEpisodios').append('<tr id='+data[i].id+'><td>'+data[i].idPaciente+'</td><td>'+addIfNotNull(data[i].fechaEpisodio)+'</td><td>'+addIfNotNull(data[i].hora)+'</td><td>'+addIfNotNull(data[i].nivelDolor)+'</td><td>'+addIfNotNull(data[i].localizacion)+'</td><td>'+addIfNotNull(data[i].patronSueno)+'</td><td><button type="button" data-toggle="modal" data-target="#modalEp'+data[i].id+'">Ver</button></td>'); 
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

function addIfNotEmpty(array){
    if (array.length > 0)
        return array;
    else
        return "No existe información";
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