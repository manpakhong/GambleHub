package com.rabbitforever.gamblehub.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transaction;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rabbitforever.gamblehub.models.eos.BaccaratEo;

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
		try {
			
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
		return null;
	}

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
