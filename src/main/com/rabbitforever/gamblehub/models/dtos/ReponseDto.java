package com.rabbitforever.gamblehub.models.dtos;

public class ReponseDto{

	protected String message;
	protected Boolean isSuccess;


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}


//	public void setDto(T dto) throws Exception{
//		try {
//
//			Method dtoMethod = dto.getClass().getMethod("getId");
//			Object returnObject = dtoMethod.invoke(dto);
//			Integer id = (Integer) returnObject;
//			if (id != null) {
//				isSuccess = true;
//			} else {
//				isSuccess = false;
//			}
//			this.dto = dto;
//		} catch (Exception e) {
//			logger.error(getClassName() + ".parseUpdateDateTimeStringToDate()-dto=" + dto , e);
//			throw e;
//		}
//	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReponseDto [message=");
		builder.append(message);
		builder.append(", isSuccess=");
		builder.append(isSuccess);
		builder.append("]");
		return builder.toString();
	}

	
}
