var command = new Object();
command.default = "SELECT";
command.select = "SELECT";
command.insert = "INSERT";
command.delete = "DELETE";
command.update = "UPDATE";

$(document).ready(function(){ 
	
}); // end $(document).ready

function createRequestDto(){
	var requestDto = {};
	requestDto.command = "SELECT";
	requestDto.object = "";
	requestDto.objectName = "";
	return requestDto;
}