package com.rabbitforever.gamblehub.models.sos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rabbitforever.gamblehub.models.eos.BigSmallEo;

public class BigSmallSo extends BigSmallEo implements So
{
	protected Date createDateTimeFrom;
	protected Date createDateTimeTo;
	protected Date updateDateTimeFrom;
	protected Date updateDateTimeTo;
	protected List<OrderedBy> orderedByList;
	@Override
	public void setCreateDateTimeFrom(Date createDateTimeFrom){
		this.createDateTimeFrom = createDateTimeFrom;
	}
	@Override
	public void setCreateDateTimeTo(Date createDateTimeTo){
		this.createDateTimeTo = createDateTimeTo;
	}
	@Override
	public void setUpdateDateTimeFrom(Date updateDateTimeFrom){
		this.updateDateTimeFrom = updateDateTimeFrom;
	}
	@Override
	public void setUpdateDateTimeTo(Date updateDateTimeTo){
		this.updateDateTimeTo = updateDateTimeTo;
	}
	@Override
	public Date getCreateDateTimeFrom(){
		return this.createDateTimeFrom;
	}
	@Override
	public Date getCreateDateTimeTo(){
		return this.createDateTimeTo;
	}
	@Override
	public Date getUpdateDateTimeFrom(){
		return this.updateDateTimeFrom;
	}
	@Override
	public Date getUpdateDateTimeTo(){
		return this.updateDateTimeTo;
	}
	@Override
	public void addOrderedBy(OrderedBy orderBy) {
		if (this.orderedByList == null) {
			this.orderedByList = new ArrayList<OrderedBy>();
		}
		this.orderedByList.add(orderBy);
	}

	@Override
	public List<OrderedBy> getOrderedByList() {
		return this.orderedByList;
	}
}
