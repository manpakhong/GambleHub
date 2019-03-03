/**
 * 
 */
var INPUT_TYPE_BANK = "B";
var INPUT_TYPE_PLAY = "P";
var currentControl;
$(document).ready(function(){ 

}); // end $(document).ready
function createBaccaratDto(){
	var baccaratDto = {};
	baccaratDto.id = null;
	baccaratDto.datetime = "";
	baccaratDto.datetimeString = "";
	baccaratDto.session = "";
	baccaratDto.round = 0;
	baccaratDto.bankPlayer = "";
	baccaratDto.result = "";
	baccaratDto.count = 0;
	baccaratDto.oddEven = "";
	baccaratDto.createDate = new Date();
	baccaratDto.createDateString = "";
	baccaratDto.updateDate = new Date();
	baccaratDto.updateDateString = "";
	baccaratDto.createdBy = "";
	baccaratDto.updatedBy = "";
	return baccaratDto;
}

function isCharacterKeyPress(evt) {
    if (typeof evt.which == "undefined") {
        // This is IE, which only fires keypress events for printable keys
        return true;
    } else if (typeof evt.which == "number" && evt.which > 0) {
        // In other browsers except old versions of WebKit, evt.which is
        // only greater than zero if the keypress is a printable key.
        // We need to filter out backspace and ctrl/alt/meta key combinations
        return !evt.ctrlKey && !evt.metaKey && !evt.altKey && evt.which != 8;
    }
    return false;
}
function isLetter(strInput)
{
 var letters = /^[A-Za-z]+$/;
 if(strInput.match(letters))
   {
    return true;
   }
 else
   {

   return false;
   }
}
function resultInput_onkeydown(e){
	var controlObj = e.target;
	var changeValue = $(controlObj).val();
	var charString = String.fromCharCode(e.which);
	var isCharacter = isLetter(charString);
	var previousValue = $('.resultInput').val();

	if (isCharacter){
		var isCorrectResultInput = validateCorrectResultInput(charString);
		if (!isCorrectResultInput){
			alert("Only B or P input(s) is/ are accepted!");
		}


	}
}
var BANK_PLAYER_BANK = 'B';
var BANK_PLAYER_PLAYER = 'P';
function determineBankPlayer(result){
	var bankPlayer;
	if (!isUndefinedOrIsNull(result)){
		var bp = result.charAt(0);
		if (bp == BANK_PLAYER_BANK){
			bankPlayer = BANK_PLAYER_BANK;
		} else if (bp == BANK_PLAYER_PLAYER){
			bankPlayer = BANK_PLAYER_PLAYER;
		}
	}
	return bankPlayer;
}
function marshallCountString2Int(countString){
	var rtnResult;
	if (!isUndefinedOrIsNull(countString)) {
		var numericString = '';
		for (var i=0; i < countString.length; i++){
			var charString = countString.charAt(i);
			if (!isNaN(charString)){
				numericString += charString;
			}
		}
		if (numericString.length > 0){
			rtnResult = tryParseInt(numericString);
		}
	}
	return rtnResult;
}
function collectBaccaratData(trObj){
	var baccaratDto = createBaccaratDto();
	
	var sessionInput = $(trObj).find('.sessionInput');
	var roundInput = $(trObj).find('.roundInput');
	var resultInput = $(trObj).find('.resultInput');
	var countLabel = $(trObj).find('.countLabel');
	var oddEvenLabel = $(trObj).find('.oddEvenLabel');
	var countLabel = $(trObj).find('.countLabel');
	var dateParamInput = $(document).find('.dateParamInput');
	
	var session = $(sessionInput).val();
	var roundString = $(roundInput).val();
	var round = tryParseInt(roundString);
	var result = $(resultInput).val();
	var bankPlayer = determineBankPlayer(result);
	var countString = $(countLabel).html();
	var count = marshallCountString2Int(countString);
	var oddEven = $(oddEvenLabel).html();
	var roundString = $(roundInput).val();
	var round = tryParseInt(roundString);
	var datetimeParamString = $(dateParamInput).val();
	var datetime = parseParamDateStringToDate(datetimeParamString);
	var createDateString = convertDate2ParamDateTimeString(baccaratDto.createDate);
	var updateDateString = convertDate2ParamDateTimeString(baccaratDto.updateDate);
	

	baccaratDto.session = session;
	baccaratDto.round = round;
	baccaratDto.bankPlayer = bankPlayer;
	baccaratDto.result = result;
	baccaratDto.count = count;
	baccaratDto.oddEven = oddEven;
	baccaratDto.datetime = datetime;
	baccaratDto.datetimeString = datetimeParamString;
	baccaratDto.createDateString = createDateString;
	baccaratDto.updateDateString = updateDateString;
	
	
	return baccaratDto; 
}
function postDeleteBaccaratData(baccaratDto){
	var postDto = createRequestDto();
	postDto.dataInstance = baccaratDto;
	postDto.dataClassName = "BaccaratDto";
	var dataString = JSON.stringify(postDto);
	console.log(dataString);
	
	$.ajax({
		type : "POST",
		url : "deleteBaccarat",
		contentType: "application/json; charset=utf-8",
		data : dataString
	}).done(function(data, status, jqXHR) {
		postDeleteBaccaratDataCallBack(data);
//		alert("Promise success callback.");
	}).fail(function(jqXHR, status, err) {
//		alert("Promise error callback.");
	}).always(function() {
//		alert("Promise completion callback.");
	})
}
function postEditBaccaratData(baccaratDto){
	var postDto = createRequestDto();
	postDto.dataInstance = baccaratDto;
	postDto.dataClassName = "BaccaratDto";
	var dataString = JSON.stringify(postDto);
	console.log(dataString);
	
	$.ajax({
		type : "POST",
		url : "editBaccarat",
		contentType: "application/json; charset=utf-8",
		data : dataString
	}).done(function(data, status, jqXHR) {
		postEditBaccaratDataCallBack(data);
//		alert("Promise success callback.");
	}).fail(function(jqXHR, status, err) {
//		alert("Promise error callback.");
	}).always(function() {
//		alert("Promise completion callback.");
	})
}
function postAddBaccaratData(baccaratDto){
	var postDto = createRequestDto();
	postDto.dataInstance = baccaratDto;
	postDto.dataClassName = "BaccaratDto";
	var dataString = JSON.stringify(postDto);
	console.log(dataString);
	
	$.ajax({
		type : "POST",
		url : "addBaccarat",
		contentType: "application/json; charset=utf-8",
		data : dataString
	}).done(function(data, status, jqXHR) {
		postAddBaccaratDataCallBack(data);
//		alert("Promise success callback.");
	}).fail(function(jqXHR, status, err) {
//		alert("Promise error callback.");
	}).always(function() {
//		alert("Promise completion callback.");
	})

}
function createBaccaratTableTrTopRow(){
	var tbodyObj =  $('.baccaratTableTbody');
	var dateParamInput = $('.dateParamInput');
	var dateParam = $(dateParamInput).val();
	var trObjString = "<tr>"
	+	"<td><input type=\"button\" value=\"Add\" class=\"addNewButton\" onclick=\"addNewButton_onclick(event)\"/></td>"
	+ 	"<td><input type=\"text\" value=\"" + dateParam + "\" class=\"sessionInput\"/></td>"
	+	"<td><input type=\"text\" value=\"\" class=\"roundInput\" /></td>"
	+	"<td><input type=\"text\" value=\"\" class=\"resultInput\" onkeydown=\"resultInput_onkeydown(event)\" onchange=\"resultInput_onchange(event)\" /></td>"
	+	"<td><label for=\"count\" class=\"countLabel\"></label></td>"
	+	"<td><label for=\"oddEven\" class=\"oddEvenLabel\"></label></td>"
	+	"</tr>";
	
	$(tbodyObj).append(trObjString);
}
function createBaccaratTableTrDataRow(baccaratDto){
	var tbodyObj =  $('.baccaratTableTbody');
	var dateParamInput = $('.dateParamInput');
	var dateParam = $(dateParamInput).val();
	var trObjString = "<tr>"
	+	"<td>"
	+		"<input type=\"button\" value=\"Delete\" class=\"addNewButton\" onclick=\"deleteButton_onclick(event)\"/>"
	+		"<input type=\"button\" value=\"Edit\" class=\"addNewButton\" onclick=\"editButton_onclick(event)\"/>"
	+	"</td>"
	+ 	"<td><input type=\"text\" value=\"" + baccaratDto.session + "\" class=\"sessionInput\"/></td>"
	+	"<td><input type=\"text\" value=\"\" class=\"roundInput\" value=\"" + baccaratDto.round +"\"/></td>"
	+	"<td><input type=\"text\" value=\"\" class=\"resultInput\" onkeydown=\"resultInput_onkeydown(event)\" onchange=\"resultInput_onchange(event)\" value=\"" + baccaratDto.result +"\" /></td>"
	+	"<td><label for=\"count\" class=\"countLabel\">" + baccaratDto.count +"</label></td>"
	+	"<td><label for=\"oddEven\" class=\"oddEvenLabel\">"+ baccaratDto.count +"</label></td>"
	+	"</tr>";
	
	$(tbodyObj).append(trObjString);
}
function postAddBaccaratDataCallBack(jsonStr){
	if (!isUndefinedOrIsNull(jsonStr)) {
		if (jsonStr.length == 0) {
			return;
		}
		var baccaratReponseDto = JSON.parse(jsonStr);
		if (!isUndefinedOrIsNull(baccaratReponseDto)) {
			var isSuccess = baccaratReponseDto.isSuccess;
			var bacccaratDto = baccaratReponseDto.baccaratDto;
			if (isSuccess){
				createBaccaratTableTrDataRow(bacccaratDto);
				createBaccaratTableTrTopRow();
				$(currentControl).remove();
			}
		}
	}
}

function deleteButton_onclick(e){
	var controlObj = e.target;
	var tdObj = $(controlObj).parent();
	var trObj = $(tdObj).parent();
	var tbodyObj = $(trObj).parent();
	currentControl = trObj;
	var baccaratDto = collectBaccaratData(trObj);
	postDeleteBaccaratData(baccaratDto);
}
function editButton_onclick(e){
	var controlObj = e.target;
	var tdObj = $(controlObj).parent();
	var trObj = $(tdObj).parent();
	var tbodyObj = $(trObj).parent();
	currentControl = trObj;
	var baccaratDto = collectBaccaratData(trObj);
	postEditBaccaratData(baccaratDto);
}

function addNewButton_onclick(e){
	var controlObj = e.target;
	var tdObj = $(controlObj).parent();
	var trObj = $(tdObj).parent();
	var tbodyObj = $(trObj).parent();
	currentControl = trObj;
	var baccaratDto = collectBaccaratData(trObj);
	postAddBaccaratData(baccaratDto);
}

function resultInput_onchange(e){
	var controlObj = e.target;
	var changeValue = $(controlObj).val();
	isTheSameInput = validateSameResultInput(changeValue);
	if (!isTheSameInput){
		alert("You should have the same character input!");
	}
	var count = countInput(changeValue);
	updateCountValue(changeValue);

	var resultString = oddEvenDeterminator(count);
	updateOddEvenValue(resultString);
}
function updateCountValue(changeValue){
	var count = countInput(changeValue);
	if (count > 0){
		$('.countLabel').text(changeValue.charAt(0) + count);
	}

}
function updateOddEvenValue(resultString){
	$('.oddEvenLabel').text(resultString);
}
function countInput(value){
	var firstCharacter;
	var count = 0;

	for (var i=0; i < value.length; i++){
		var charElement = value.charAt(i);
		if (i == 0){
			firstCharacter = charElement;
			var isValid = validateCorrectResultInput(firstCharacter);
			if (!isValid){
				return count;
			}
			count++;
		}

		if (i > 0){
			var isValid = validateCorrectResultInput(charElement);
			if (isValid && charElement == firstCharacter){
				count++;
			}
		}
	}
	return count;
}

function oddEvenDeterminator(value){
	var resultString = '';
	if (value % 2 == 0){
		resultString = "Event";
	} else {
		resultString = "Odd";
	}
	return resultString;
}
function validateCorrectResultInput(changeValue){
	var isValid = true;
	for (var i=0; i < changeValue.length; i++){
		var charElement = changeValue.charAt(i);
		if (charElement != INPUT_TYPE_BANK && charElement != INPUT_TYPE_PLAY){
			isValid = false;
			break;
		}
	}
	return isValid;
}
function validateSameResultInput(changeValue){
	var isValid = true;
	var firstCharacter;
	for (var i=0; i < changeValue.length; i++){
		var charElement = changeValue.charAt(i);
		if (i ==0){
			firstCharacter = charElement;
		}
		if (i > 0){
			if (firstCharacter != charElement){
				isValid = false;
				break;
			}
		}
	}
	return isValid;
}