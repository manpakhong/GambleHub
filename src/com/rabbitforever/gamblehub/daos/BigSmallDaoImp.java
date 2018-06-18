package com.rabbitforever.gamblehub.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
import com.rabbitforever.gamblehub.models.eos.BigSmallEo;
import com.rabbitforever.gamblehub.models.sos.BigSmallSo;

@Repository
public class BigSmallDaoImp extends DaoBase<BigSmallEo> {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}
	@Autowired
	private SessionFactory sessionFactory;

	public BigSmallDaoImp(String connectionType) throws Exception {
		super(connectionType);
		session = sessionFactory.getCurrentSession();
	}

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
			if (bigSmallSo.getRound() != null) {
				if (predicateList == null) {
					predicateList = new ArrayList<Predicate>();
				}
				Predicate predicate = builder.equal(root.get("name"), bigSmallSo.getRound());
				predicateList.add(predicate);
			}
			if (predicateList != null) {
				query.select(root).where(predicateList.toArray(new Predicate[] {}));
			} else {
				query.select(root);
			}
			q = session.createQuery(query);
			bigSmallEoList = q.getResultList();
			for (BigSmallEo bigSmallEo: bigSmallEoList) {
				System.out.println(bigSmallEo.getResult());
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
			if (connectionType.equals(CONNECTION_TYPE_HIBERNATE)) {
				if (session != null) {
					session.close();
					session = null;
				}
			}
		}
		return bigSmallEoList;
	}

	@Override
	public Integer create(BigSmallEo eo) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
