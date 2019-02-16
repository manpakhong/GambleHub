package com.rabbitforever.gamblehub.models.sos;

import java.util.Date;
import java.util.List;

public interface So {
	public Date getCreateDateTimeFrom();
	public void setCreateDateTimeFrom(Date createDateTimeFrom);
	
	public Date getCreateDateTimeTo();
	public void setCreateDateTimeTo(Date createDateTimeTo);
	
	public Date getUpdateDateTimeFrom();
	public void setUpdateDateTimeFrom(Date updateDateTimeFrom);
	
	public Date getUpdateDateTimeTo();
	public void setUpdateDateTimeTo(Date updateDateTimeTo);
	
	public void addOrderedBy(OrderedBy orderBy);
	public List<OrderedBy> getOrderedByList();
}
