package com.rabbitforever.gamblehub.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rabbitforever.gamblehub.models.eos.BaccaratEo;
import com.rabbitforever.gamblehub.models.sos.BaccaratSo;
import com.rabbitforever.gamblehub.models.sos.OrderedBy;

@Repository
public class BaccaratDao extends OrmDaoBase<BaccaratEo>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());

	private String getClassName(){
		return this.getClass().getName();
	}
	@Override
	public List<BaccaratEo> read(Object so) throws Exception {
		List<BaccaratEo> baccaratEoList = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<BaccaratEo> query = null;
		Transaction trans = null;
		Root<BaccaratEo> root = null;
		Query<BaccaratEo> q = null;
		List<Predicate> predicateList = null;
		try{
			session = sessionFactory.getCurrentSession();
			BaccaratSo baccaratSo = (BaccaratSo) so;
			trans = session.getTransaction();
			trans.begin();
			builder = session.getCriteriaBuilder();
			query = builder.createQuery(BaccaratEo.class);
			if(baccaratSo.getId() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("id"), baccaratSo.getId());
			}
			if(baccaratSo.getSession() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("session"), baccaratSo.getSession());
			}
			if(baccaratSo.getRound() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("round"), baccaratSo.getRound());
			}
			if(baccaratSo.getBankPlayer() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("bank_player"), baccaratSo.getBankPlayer());
			}
			if(baccaratSo.getResult() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("result"), baccaratSo.getResult());
			}
			if(baccaratSo.getOddEven() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("odd_even"), baccaratSo.getOddEven());
			}
			if(baccaratSo.getDatetime() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("datetime"), baccaratSo.getDatetime());
			}
			if(baccaratSo.getCreateDate() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("create_date"), baccaratSo.getCreateDate());
			}
			if(baccaratSo.getUpdateDate() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("update_date"), baccaratSo.getUpdateDate());
			}
			if (predicateList != null) {
				query.select(root).where(predicateList.toArray(new Predicate[] {}));
			} else {
				query.select(root);
			}
			List<OrderedBy> orderedByList = baccaratSo.getOrderedByList();
			if (orderedByList != null){
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
			baccaratEoList = q.getResultList();
			for (BaccaratEo baccaratEo:baccaratEoList){
				logger.debug(baccaratEo.toString());
			}
		}catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		finally {
			if(trans != null){
				trans.commit();
				trans = null;
			}
		}
		return baccaratEoList;
	} // end select function
	@Override
	public Integer create(BaccaratEo eo) throws Exception {
		List<BaccaratEo> baccaratEoList = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<BaccaratEo> query = null;
		Transaction trans = null;
		Root<BaccaratEo> root = null;
		Query<BaccaratEo> q = null;
		List<Predicate> predicateList = null;
		try {
			
		} catch (Exception e) {
			logger.error(getClassName() + ".create() - eo=" + eo, e);
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
		return null;
	}

	@Override
	public Integer update(BaccaratEo eo) throws Exception {
		List<BaccaratEo> baccaratEoList = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<BaccaratEo> query = null;
		Transaction trans = null;
		Root<BaccaratEo> root = null;
		Query<BaccaratEo> q = null;
		List<Predicate> predicateList = null;
		try {
			
		} catch (Exception e) {
			logger.error(getClassName() + ".update() - eo=" + eo, e);
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
		return null;
	}

	@Override
	public Integer delete(BaccaratEo eo) throws Exception {
		List<BaccaratEo> baccaratEoList = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<BaccaratEo> query = null;
		Transaction trans = null;
		Root<BaccaratEo> root = null;
		Query<BaccaratEo> q = null;
		List<Predicate> predicateList = null;
		try {
			
		} catch (Exception e) {
			logger.error(getClassName() + ".delete() - eo=" + eo, e);
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
		return null;
	}

}
