package com.rabbitforever.gamblehub.models.eos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaccaratEo
{
	protected Integer id;
	protected String session;
	protected Integer round;
	protected String bankPlayer;
	protected Integer result;
	protected String oddEven;
	protected Date datetime;
	protected Date createDate;
	protected Date updateDate;
	protected String createdBy;
	protected String updatedBy;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "session")
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	@Column(name = "round")
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
	}
	@Column(name = "bank_player")
	public String getBankPlayer() {
		return bankPlayer;
	}
	public void setBankPlayer(String bankPlayer) {
		this.bankPlayer = bankPlayer;
	}
	@Column(name = "result")
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	@Column(name = "odd_even")
	public String getOddEven() {
		return oddEven;
	}
	public void setOddEven(String oddEven) {
		this.oddEven = oddEven;
	}
	@Column(name = "datetime")
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Column(name = "update_date")
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name = "updated_by")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
