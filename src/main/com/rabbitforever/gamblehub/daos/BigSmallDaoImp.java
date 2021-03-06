package com.rabbitforever.gamblehub.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rabbitforever.gamblehub.interceptors.AuditInterceptor;
import com.rabbitforever.gamblehub.models.eos.BaccaratEo;
import com.rabbitforever.gamblehub.models.eos.BigSmallEo;
import com.rabbitforever.gamblehub.models.sos.BigSmallSo;
import com.rabbitforever.gamblehub.models.sos.OrderedBy;
import com.rabbitforever.gamblehub.utils.HibernateUtils;

@Repository
public class BigSmallDaoImp implements BigSmallDao{
	private final Logger logger = LogManager.getLogger(getClassName());
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private String getClassName(){
		return this.getClass().getName();
	}


	public BigSmallDaoImp() throws Exception{

	}
//	public BigSmallDaoImp(String connectionType) throws Exception {
//		super(connectionType);
//		session = sessionFactory.getCurrentSession();
//	}

	@Override
	public List<BigSmallEo> read(Object so) throws Exception {
		List<BigSmallEo> bigSmallEoList = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<BigSmallEo> query = null;
		Transaction trans = null;
		Root<BigSmallEo> root = null;
		Query<BigSmallEo> q = null;
		List<Predicate> predicateList = null;
		try {
			session = sessionFactory.getCurrentSession();
			BigSmallSo bigSmallSo = (BigSmallSo) so;
			trans = session.getTransaction();
			trans.begin();
			builder = session.getCriteriaBuilder();
			query = builder.createQuery(BigSmallEo.class);
			root = query.from(BigSmallEo.class);

			if(bigSmallSo.getId() != null) {
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("id"), bigSmallSo.getId());
				predicateList.add(predicate);
			}
			if (bigSmallSo.getPoint() != null) {
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("point"), bigSmallSo.getPoint());
				predicateList.add(predicate);
			}			
			if (bigSmallSo.getRound() != null) {
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("round"), bigSmallSo.getRound());
				predicateList.add(predicate);
			}
			if (bigSmallSo.getCreateDateTimeFrom() != null) {
				Date dateFrom = bigSmallSo.getCreateDateTimeFrom();
				Date dateTo = bigSmallSo.getCreateDateTimeTo();
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				if (dateTo == null) {
					dateTo = new Date();
				}
				Predicate predicate = builder.between(root.get("createDate"),dateFrom, dateTo);
				predicateList.add(predicate);
			}
			if (bigSmallSo.getUpdateDateTimeFrom() != null) {
				Date dateFrom = bigSmallSo.getUpdateDateTimeFrom();
				Date dateTo = bigSmallSo.getUpdateDateTimeTo();
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				if (dateTo == null) {
					dateTo = new Date();
				}
				Predicate predicate = builder.between(root.get("updateDate"),dateFrom, dateTo);
				predicateList.add(predicate);
			}			
			if (predicateList != null) {
				query.select(root).where(predicateList.toArray(new Predicate[] {}));
			} else {
				query.select(root);
			}
			List<OrderedBy> orderedByList = bigSmallSo.getOrderedByList();
			if (orderedByList != null) {
				for (OrderedBy orderedBy: orderedByList) {
					String dataField = orderedBy.getDataField();
					if (orderedBy.getIsAsc()) {
						query.orderBy(builder.desc(root.get(dataField)));
					} else {
						query.orderBy(builder.desc(root.get(dataField)));
					}
				}
			}
			q = session.createQuery(query);
			bigSmallEoList = q.getResultList();
			for (BigSmallEo bigSmallEo: bigSmallEoList) {
				logger.debug(bigSmallEo.getResult());
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		finally {
			if (trans != null) {
				trans.commit();
				trans = null;
			}
//			if (connectionType.equals(CONNECTION_TYPE_HIBERNATE)) {
//				if (session != null) {
//					session.close();
//					session = null;
//				}
//			}
		}
		return bigSmallEoList;
	}

	@Override
	public Integer create(BigSmallEo eo) throws Exception {
		Transaction trans = null;
		Integer id = null;
		try {
			session = sessionFactory.withOptions().interceptor(new AuditInterceptor()).openSession();
			
			trans = session.getTransaction();
			trans.begin();

			eo.setCreatedBy("admin");
			eo.setCreateDate(new Date());
			eo.setUpdatedBy("admin");
			eo.setUpdateDate(new Date());
			session.save(eo);
			trans.commit();
			id = eo.getId();
		} catch (Exception e) {
			logger.error(getClassName() + ".create() - eo=" + eo, e);
			trans.rollback();
			throw e;
		} // end try ... catch
		finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}
		return id;
	}

	@Override
	public Integer update(BigSmallEo eo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(BigSmallEo eo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
