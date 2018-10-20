package com.rabbitforever.gamblehub.services;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rabbitforever.gamblehub.daos.BaccaratDao;
import com.rabbitforever.gamblehub.models.eos.BaccaratEo;
@Service
public class BaccaratService extends ServiceBase{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private BaccaratDao dao;
	private String getClassName(){
		return this.getClass().getName();
	}
	public BaccaratService() throws Exception{
		try{
			init(null);
		} catch (Exception e){
			logger.error(getClassName() + ".BaccaratService() - connectionType=null", e);
			throw e;
		}
	} // end constructor
	public BaccaratService(String connectionType) throws Exception{
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
	public Integer create(BaccaratEo eo) throws Exception{
		Integer noOfAffectedRow = null;
		try{
			noOfAffectedRow = dao.create(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".create() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		return noOfAffectedRow;
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
