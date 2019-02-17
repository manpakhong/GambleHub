package com.rabbitforever.gamblehub.models.eos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "gbl_baccarat")
public class BaccaratEo
{
	protected Integer id;
	protected Date datetime;
	protected String session;
	protected Integer round;
	protected String bankPlayer;
	protected String result;
	protected String oddEven;
	protected Integer count;
	protected Date createDate;
	protected Date updateDate;
	protected String createdBy;
	protected String updatedBy;
	@Id
	@Column(name = "id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "datetime", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", nullable = false)
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Column(name = "session",length = 45, nullable = true)
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	@Column(name = "round", columnDefinition = "INT(11) UNSIGNED")
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
	}
	@Column(name = "bank_player",length = 45, nullable = true)
	public String getBankPlayer() {
		return bankPlayer;
	}
	public void setBankPlayer(String bankPlayer) {
		this.bankPlayer = bankPlayer;
	}
	@Column(name = "result",length = 45, nullable = true)
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Column(name = "odd_even",length = 45, nullable = true)
	public String getOddEven() {
		return oddEven;
	}
	public void setOddEven(String oddEven) {
		this.oddEven = oddEven;
	}
	@Column(name = "count", columnDefinition = "INT(11) UNSIGNED")
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", nullable = false)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", nullable = false)
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Column(name = "created_by",length = 255, nullable = true)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name = "updated_by",length = 255, nullable = true)
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
