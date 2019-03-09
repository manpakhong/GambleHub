package com.rabbitforever.gamblehub.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
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
	public BaccaratDao() throws Exception{
		super();
	}
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
			root = query.from(BaccaratEo.class);
			if(baccaratSo.getId() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("id"), baccaratSo.getId());
				predicateList.add(predicate);
			}
			if(baccaratSo.getSession() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("session"), baccaratSo.getSession());
				predicateList.add(predicate);

			}
			if(baccaratSo.getRound() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("round"), baccaratSo.getRound());
				predicateList.add(predicate);

			}
			if(baccaratSo.getBankPlayer() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("bank_player"), baccaratSo.getBankPlayer());
				predicateList.add(predicate);
			}
			if(baccaratSo.getResult() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("result"), baccaratSo.getResult());
				predicateList.add(predicate);
			}
			if(baccaratSo.getOddEven() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("odd_even"), baccaratSo.getOddEven());
				predicateList.add(predicate);
			}
			if(baccaratSo.getDatetime() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("datetime"), baccaratSo.getDatetime());
				predicateList.add(predicate);
			}
			if(baccaratSo.getCreateDate() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("create_date"), baccaratSo.getCreateDate());
				predicateList.add(predicate);
			}
			if(baccaratSo.getUpdateDate() != null){
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("update_date"), baccaratSo.getUpdateDate());
				predicateList.add(predicate);
			}
			if (predicateList != null) {
				query.select(root).where(predicateList.toArray(new Predicate[] {}));
			} else {
				query.select(root);
			}
			List<OrderedBy> orderedByList = baccaratSo.getOrderedByList();
			List<Order> orderList = null;
			if (orderedByList != null){
				orderList = new ArrayList<Order>();
				for (OrderedBy orderedBy: orderedByList) {
					String dataField = orderedBy.getDataField();
					if (orderedBy.getIsAsc()) {
						orderList.add(builder.asc(root.get(dataField)));

					} else {
						orderList.add(builder.desc(root.get(dataField)));
					}
				}
			}
			if (orderList != null) {
				query.orderBy(orderList);
			}
			q = session.createQuery(query);
			baccaratEoList = q.getResultList();
			for (BaccaratEo baccaratEo:baccaratEoList){
				logger.debug(baccaratEo.toString());
			}
			trans.commit();
		}catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			trans.rollback();
			throw e;
		} // end try ... catch
		finally {
			if(trans != null){

				trans = null;
			}
		}
		return baccaratEoList;
	} // end select function
	@Override
	public void create(BaccaratEo eo) throws Exception {
		List<BaccaratEo> baccaratEoList = null;
		CriteriaBuilder builder = null;
		CriteriaQuery<BaccaratEo> query = null;
		Transaction trans = null;
		Root<BaccaratEo> root = null;
		Query<BaccaratEo> q = null;
		List<Predicate> predicateList = null;
		try {
			trans = session.getTransaction();
			trans.begin();

			eo.setCreatedBy("admin");
			eo.setCreateDate(new Date());
			eo.setUpdatedBy("admin");
			eo.setUpdateDate(new Date());
			session.save(eo);
			trans.commit();
			Integer id = eo.getId();
		} catch (Exception e) {
			logger.error(getClassName() + ".create() - eo=" + eo, e);
			trans.rollback();
			throw e;
		} // end try ... catch
		finally {
			if (trans != null) {

				trans = null;
			}
//			if (connectionType.equals(CONNECTION_TYPE_HIBERNATE)) {
//				if (session != null) {
//					session.close();
//					session = null;
//				}
//			}
		}
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
