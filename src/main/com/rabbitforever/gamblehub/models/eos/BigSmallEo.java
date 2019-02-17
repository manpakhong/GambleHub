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
@Table(name = "gbl_big_small")
public class BigSmallEo {
	protected Integer id;
	protected String round;
	protected Integer point;
	protected String result;
	protected Date createDate;
	protected Date updateDate;
	protected String updatedBy;
	protected String createdBy;
	protected String remarks;
	@Id
	@Column(name = "id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "round", length = 255, nullable = false)
	public String getRound() {
		return round;
	}
	public void setRound(String round) {
		this.round = round;
	}
	@Column(name = "point", columnDefinition = "INT(11) UNSIGNED")
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	@Column(name = "result", length = 255, nullable = false)
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", nullable = false)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", nullable = false)
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "updated_by", length = 255, nullable = false)
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Column(name = "created_by", length = 255, nullable = false)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name = "remarks", length = 255, nullable = true)
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
