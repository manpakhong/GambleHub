/**
 * 
 */
var INPUT_TYPE_BANK = "B";
var INPUT_TYPE_PLAY = "P";
$(document).ready(function(){ 

}); // end $(document).ready
function createBaccaratDto(){
	var baccaratDto = {};
	baccaratDto.id = -1;
	baccaratDto.session = "";
	baccaratDto.round = 0;
	baccaratDto.bankPlayer = "";
	baccaratDto.result = "";
	baccaratDto.oddEven = "";
	baccaratDto.datetime = "";
	baccaratDto.datetimeString = "";
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
function collectBaccaratData(trObj){
	var sessionInput = $(trObj).find('.sessionInput');
	var roundInput = $(trObj).find('.roundInput');
	var resultInput = $(trObj).find('.resultInput');
	var countLabel = $(trObj).find('.countLabel');
	var oddEvenLabel = $(trObj).find('oddEvenLabel');
	
	var baccaratDto = createBaccaratDto();
	baccaratDto.sessionInput = sessionInput;
	baccaratDto.roundInput = roundInput;
	baccaratDto.resultInput = resultInput;
	baccaratDto.oddEvenLabel = oddEventLabel;
	
	return baccaratDto;
}
function postAddBaccaratData(baccaratDto){
	var postDto = createPostDto();
	postDto.dataInstance = baccaratDto;
	postDto.dataClassName = "BaccaratDto";
	var dataString = JSON.stringify(postDto);
	console.log(dataString);
	
	$.ajax({
		type : "POST",
		url : "../../../rabbitforever/commands/BlogPageCommand.php",
		data : {
			data : dataString
		}
	}).done(function(data, status, jqXHR) {
		postAddBaccaratDataCallBack(data);
//		alert("Promise success callback.");
	}).fail(function(jqXHR, status, err) {
//		alert("Promise error callback.");
	}).always(function() {
//		alert("Promise completion callback.");
	})

}

function postAddBaccaratDataCallBack(jsonStr){
	if (!isUndefinedOrIsNull(jsonStr)) {
		if (jsonStr.length == 0) {
			return;
		}
		var baccaratVo = JSON.parse(jsonStr);
		if (isUndefinedOrIsNull(baccaratVo)) {
			//alert(getBundleLangByLabel('abnormal_nullable_data_return'));
			return;
		}
	}
}
function addNewButton_onclick(e){
	var controlObj = e.target;
	var tdObj = $(controlObj).parent();
	var trObj = $(tdObj).parent();
	
	var baccaratDto = collectBaccaratData(trObj);
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