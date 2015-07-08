$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/dmac-machine-learning-1.0-SNAPSHOT/api/readOneFileFromFileSystem?directoryName=sss"
    }).then(function(data) {    	
    	var row = $("<tbody><tr>")       
        row.append($("<td>" + data.responseMap.file + "</td>"));
        row.append($("<td>" + data.responseMap.lastModifiedTime + "</td></tr></tbody>"));
        
        $("#fileuploadtable").append(row); 
    });
});