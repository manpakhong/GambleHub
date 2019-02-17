package com.rabbitforever.gamblehub.services;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitforever.gamblehub.daos.BaccaratDao;
import com.rabbitforever.gamblehub.models.eos.BaccaratEo;
import com.rabbitforever.gamblehub.models.sos.BaccaratSo;
@Service
public class BaccaratMgr extends ServiceBase{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	@Autowired
	private BaccaratDao dao;
	private String getClassName(){
		return this.getClass().getName();
	}
	public BaccaratMgr() throws Exception{
		try{
			init(null);
		} catch (Exception e){
			logger.error(getClassName() + ".BaccaratService() - connectionType=null", e);
			throw e;
		}
	} // end constructor
	public BaccaratMgr(String connectionType) throws Exception{
		try{
			init(connectionType);
		} catch (Exception e){
			logger.error(getClassName() + ".BaccaratService() - connectionType=" + connectionType, e);
			throw e;
		}
	} // end constructor
	public void init(String connectionType) throws Exception{
		try{
			dao = new BaccaratDao();
		} catch (Exception e){
			logger.error(getClassName() + "init() - connectionType=" + connectionType, e);
			throw e;
		}
	} // end constructor
	public Integer getSessionMaxRound(String sessionString) throws Exception{
		Integer maxRound = null;
		BaccaratSo so = null;
		List<BaccaratEo> gblBaccaratEoList = null;
		try{
			
			gblBaccaratEoList = dao.read(so);
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} finally{// end try ... catch 
			so = null;
		}
		return maxRound;
	}
	public List<BaccaratEo> read(Object so) throws Exception{
		List<BaccaratEo> gblBaccaratEoList = null;
		try{
			gblBaccaratEoList = dao.read(so);
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		return gblBaccaratEoList;
	} // end select function
	public void create(BaccaratEo eo) throws Exception{
		try{
			dao.create(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".create() - eo=" + eo, e);
			throw e;
		} // end try ... catch

	} // end create function
	public Integer update(BaccaratEo eo) throws Exception{
		Integer noOfAffectedRow = null;
		try{
			noOfAffectedRow = dao.update(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".update() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		return noOfAffectedRow;
	} // end create function
	public Integer delete(BaccaratEo eo) throws Exception{
		Integer noOfAffectedRow = null;
		try{
			noOfAffectedRow = dao.delete(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".delete() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		return noOfAffectedRow;
	} // end create function
} //end class
