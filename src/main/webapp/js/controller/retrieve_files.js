$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/dmac-machine-learning-1.0-SNAPSHOT/service/readFilesFromFileSystem?directoryName=sss"
    }).then(function(data) {
       //$('.file-id').append(data.responseMap.file1);
       //$('.file-name').append(data.errorDescription);
    	
    	var row = $("<tr>")
       
        row.append($("<td>" + "OHH HO" + "</td>"));
        row.append($("<td>" + data.responseMap.files + "</td></tr>"));
        $("#fileuploadtable").append(row); 
        
        alert(row);
    });
});