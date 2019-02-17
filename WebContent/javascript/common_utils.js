/**
 * 
 */
function tryParseInt(intStr) {
     var retValue = null;
     if(intStr !== null) {
         if(intStr.length > 0) {
             if (!isNaN(intStr)) {
                 retValue = parseInt(intStr);
             }
         }
     }
     return retValue;
}

function isObjectFound(obj){
	var isPresent = false;
	if (!isUndefinedOrIsNull(obj)){
		if (obj.length > 0){
			isPresent = true;
		}
	}
	return isPresent;
}
function getDateString_YYYYMMDD_HHMMSS_MiSec(){
	var d = new Date();
	var month = d.getMonth() + 1;
	var date = d.getDate();
	var year = d.getFullYear();
	var hour = d.getHours();
	var minute = d.getMinutes();
	var second = d.getSeconds();
	var millisecond = d.getMilliseconds();
	var dateString = year.toString() + paddingPrefixZeroLen2(hour.toString()) + paddingPrefixZeroLen2(date.toString()) + "_" + paddingPrefixZeroLen2(hour.toString()) + paddingPrefixZeroLen2(minute.toString()) + paddingPrefixZeroLen2(second.toString()) + "_" + millisecond.toString();
	return dateString;
}
function getDateString_YYYYMMDD_HHMMSS(){
	var d = new Date();
	var month = d.getMonth() + 1;
	var date = d.getDate();
	var year = d.getFullYear();
	var hour = d.getHours();
	var minute = d.getMinutes();
	var second = d.getSeconds();
	var dateString = year.toString() + paddingPrefixZeroLen2(month.toString()) + paddingPrefixZeroLen2(date.toString()) + "_" + paddingPrefixZeroLen2(hour.toString()) + paddingPrefixZeroLen2(minute.toString()) + paddingPrefixZeroLen2(second.toString()) ;
	return dateString;
}
function parseParamDateStringToDate(paramDateString){
	var dateRtn;
	if (typeof paramDateString !== 'undefined' && paramDateString !== null){
		var regExp = /(\d{4})(\d{2})(\d{2})/;
		var match = regExp.exec(paramDateString);
		if (typeof match !== 'undefined' && match !== null){
			if (match.length == 4){
				dateRtn = new Date(match[1],match[2]-1,match[3],0,0,0);
			}
		}
	}
	return dateRtn;
}
function parseParamDateTimeStringToDate(paramDateTimeString){
	var dateRtn;
	if (typeof paramDateTimeString !== 'undefined' && paramDateTimeString !== null){
		var regExp = /(\d{4})(\d{2})(\d{2})_(\d{2})(\d{2})(\d{2})/;
		var match = regExp.exec(paramDateTimeString);
		if (typeof match !== 'undefined' && match !== null){
			if (match.length == 7){
				dateRtn = new Date(match[1],match[2]-1,match[3],match[4],match[5],match[6]);
			}
		}
	}
	return dateRtn;
}
function getDateStringFromDisplayDateTimeString(dateTimeString){
	var dateStringRtn;
	if (typeof dateTimeString !== 'undefined' && dateTimeString !== null){
		var regExp = /(\d{2})\-(\d{2})\-(\d{4})\s(\d{2}):(\d{2}):(\d{2})/;
		var dateTimeStringA = dateTimeString.replace(/\//g, '-');
		var match = regExp.exec(dateTimeStringA);
		if (typeof match !== 'undefined' && match !== null){
			if (match.length == 7){
				dateStringRtn = match[1] + '/' + match[2] + '/' + match[3];
				//var javaScriptZeroBasedMonth = dateRtn.getMonth();
				//javaScriptZeroBasedMonth = javaScriptZeroBasedMonth - 1;
				//dateRtn.setMonth(javaScriptZeroBasedMonth);
			}
		}
	}
	return dateStringRtn;
}

function convertDateTimeStringToDate(dateTimeString){
	var dateRtn;
	if (typeof dateTimeString !== 'undefined' && dateTimeString !== null){
		var regExp = /(\d{2})\-(\d{2})\-(\d{4})\s(\d{2}):(\d{2}):(\d{2})/;
		var dateTimeStringA = dateTimeString.replace(/\//g, '-');
		var match = regExp.exec(dateTimeStringA);
		if (typeof match !== 'undefined' && match !== null){
			if (match.length == 7){
				dateRtn = new Date(match[3],match[2]-1,match[1],match[4],match[5],match[6]);
			}
		}
	}
	return dateRtn;
}
function getCurrentUrl(){
	var url = window.location.pathname;
    return url;
}

function getCurrentFileName(){
	var url = getCurrentUrl();
    var filename = url.substring(url.lastIndexOf('/')+1);
    return filename;
}

function getTodayWithoutTime(){
	var today = new Date();
	today.setHours(0,0,0,0);
	return today;
}

function paddingPrefixZeroLen2(instring){
	instring = paddingPrefixZero(instring, 2);
	return instring;
}
function paddingPrefixZero(instring, length){
	if (instring.length < length){
		instring = '0' + instring;
	}
	return instring;
}
function convertDate2ParamDateString(date){
	var rtnDateString = '';
	if (date instanceof Date){
		rtnDateString += date.getFullYear();
		rtnDateString += paddingPrefixZeroLen2((date.getMonth() + 1).toString());
		rtnDateString += paddingPrefixZeroLen2(date.getDate().toString());
	}
	return rtnDateString;
}
function convertDate2ParamDateTimeString(date){
	var rtnDateString = '';
	if (date instanceof Date){
		rtnDateString += date.getFullYear();
		rtnDateString += paddingPrefixZeroLen2((date.getMonth() + 1).toString()) ;
		rtnDateString += paddingPrefixZeroLen2(date.getDate().toString()) + '_';
		rtnDateString += paddingPrefixZeroLen2(date.getHours().toString());
		rtnDateString += paddingPrefixZeroLen2(date.getMinutes().toString());
		rtnDateString += paddingPrefixZeroLen2(date.getSeconds().toString());
	}
	return rtnDateString;
}
function convertDate2GsonDate(date){
	var rtnDateString = '';
	if (date instanceof Date){
		rtnDateString += date.getFullYear() + '-';
		rtnDateString += paddingPrefixZeroLen2((date.getMonth() + 1).toString()) + '-';
		rtnDateString += paddingPrefixZeroLen2(date.getDate().toString()) + ' ';
		rtnDateString += paddingPrefixZeroLen2(date.getHours().toString()) + ':';
		rtnDateString += paddingPrefixZeroLen2(date.getMinutes().toString()) + ':';
		rtnDateString += paddingPrefixZeroLen2(date.getSeconds().toString());
	}
	return rtnDateString;
}

function isUndefinedOrIsNull(obj){
	var isNull = false;
	if (typeof obj === 'undefined' || obj === null){
		isNull = true;
	}
	return isNull;
}

function areTheSameTime(date1, date2){
	var areTheSameTime = false;
	if (typeof date1 !== 'undefined' && 
			date1 !== null && 
			typeof date2 !== 'undefined' &&
			date2 !== null){
		if (date1 instanceof Date && date2 instanceof Date){
			var theSame = true;
			if (date1.getMonth() != date2.getMonth()){
				theSame = false;
			}
			if (date1.getDate() != date2.getDate()){
				theSame = false;
			}
			if (date1.getFullYear() != date2.getFullYear()){
				theSame = false;
			}
			if (date1.getHours() != date2.getHours()){
				theSame = false;
			}
			if (date1.getMinutes() != date2.getMinutes()){
				theSame = false;
			}
			if (date1.getSeconds() != date2.getSeconds()){
				theSame = false;
			}
			areTheSameTime = theSame;
		}
	}
	return areTheSameTime;
}
function date2DisplayString(date){
	var rtnDateString = '';
	if (date instanceof Date){
		//rtnDateString += date.getFullYear() + '/';
		//rtnDateString += paddingPrefixZeroLen2((date.getMonth() + 1).toString()) + '/';
		//rtnDateString += paddingPrefixZeroLen2(date.getDate().toString()) + ' ';
		
		rtnDateString += paddingPrefixZeroLen2(date.getDate().toString()) + '/';
		rtnDateString += paddingPrefixZeroLen2((date.getMonth() + 1).toString()) + '/';
		rtnDateString += date.getFullYear();
	}
	return rtnDateString;
}
function isDefaultEmptyDate(date){
	var isDefaultEmptyDate = false;
	if (date instanceof Date){
		var defaultEmptyDate = getDefaultEmptyDate();
		isDefaultEmptyDate = areTheSameTime(defaultEmptyDate, date);
	}
	return isDefaultEmptyDate;
}
function getDefaultEmptyDate(){
	var date = dateString2Date(DEFAULT_EMPTY_JSCRIPT_DATE_STRING);
	return date;
}
function dateString2Date(dateString){
	var dateRtn;
	if (typeof dateString !== 'undefined' && dateString !== null){
		var regExp = /(\d{4})\-(\d{2})\-(\d{2})\-(\d{2})\.(\d{2})\.(\d{2})/;
		var match = regExp.exec(dateString);
		if (typeof match !== 'undefined' && match !== null){
			if (match.length == 7){
				dateRtn = new Date(match[1],match[2]-1,match[3],match[4],match[5],match[6]);
				//var javaScriptZeroBasedMonth = dateRtn.getMonth();
				//javaScriptZeroBasedMonth = javaScriptZeroBasedMonth - 1;
				//dateRtn.setMonth(javaScriptZeroBasedMonth);
			}
		}else{
			dateRtn = dateString2DateWithMilliseconds6(dateString)
		}
	}
	return dateRtn;
}
function dateString2DateWithMilliseconds6(dateString){
	var dateRtn;
	if (typeof dateString !== 'undefined' && dateString !== null){
		var regExp = /(\d{4})\-(\d{2})\-(\d{2})\ (\d{2})\:(\d{2})\:(\d{2})\.(\d{6})/;
		var match = regExp.exec(dateString);
		if (typeof match !== 'undefined' && match !== null){
			if (match.length == 8){
				dateRtn = new Date(match[1],match[2]-1,match[3],match[4],match[5],match[6]);
				//var javaScriptZeroBasedMonth = dateRtn.getMonth();
				//javaScriptZeroBasedMonth = javaScriptZeroBasedMonth - 1;
				//dateRtn.setMonth(javaScriptZeroBasedMonth);
			}
		}else{
			dateRtn = dateString2DateWithMilliseconds1(dateString)
		}
	}
	return dateRtn;
}
function dateString2DateWithMilliseconds1(dateString){
	var dateRtn;
	if (typeof dateString !== 'undefined' && dateString !== null){
		var regExp = /(\d{4})\-(\d{2})\-(\d{2})\ (\d{2})\:(\d{2})\:(\d{2})\.(\d{1})/;
		var match = regExp.exec(dateString);
		if (typeof match !== 'undefined' && match !== null){
			if (match.length == 8){
				dateRtn = new Date(match[1],match[2]-1,match[3],match[4],match[5],match[6]);
				//var javaScriptZeroBasedMonth = dateRtn.getMonth();
				//javaScriptZeroBasedMonth = javaScriptZeroBasedMonth - 1;
				//dateRtn.setMonth(javaScriptZeroBasedMonth);
			}
		}else{
			console.debug('Timestamp Error (CAM0344009_imp.js) : "' + dateString+'"');
		}
	}
	return dateRtn;
}
function getUrlParam(paramString){
	var returnString = '';
	var pageUrl = window.location.search.substring(1);
	var urlVars = pageUrl.split('&');
	for (var i = 0; i < urlVars.length; i++){
		var paramName = urlVars[i].split('=');
		if (paramName[0] == paramString){
			returnString = paramName[1];
		}
	}
	return returnString;
}
function getUriPageFileName(uri){
	var uriParts = uri.split('/');
	var lengthOfUri = uriParts.length;
	var lastIndex = lengthOfUri - 1;
	var uriFileName = uriParts[lastIndex];
	var uriFileName = uriFileName.replace('?' , '');
	return uriFileName;
}