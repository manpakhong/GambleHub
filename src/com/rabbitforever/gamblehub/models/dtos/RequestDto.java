package com.rabbitforever.gamblehub.models.dtos;

public abstract class RequestDto <T>{
	protected String command;
	protected String dataClassName;
	protected T dataInstance;
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
	public T getDataInstance() {
		return dataInstance;
	}
	public void setDataInstance(T dataInstance) {
		this.dataInstance = dataInstance;
	}
	
	
}
