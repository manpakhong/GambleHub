package com.rabbitforever.gamblehub.models.dtos;

public abstract class RequestDto {
	protected String command;
	protected String dataClassName;

	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDataClassName() {
		return dataClassName;
	}
	public void setDataClassName(String dataClassName) {
		this.dataClassName = dataClassName;
	}
}
