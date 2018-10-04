package com.rabbitforever.gamblehub.interceptors;

import java.io.Serializable;
import java.util.Arrays;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditInterceptor extends EmptyInterceptor {

	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}	
    private int updates;
    private int creates;
    private int loads;

    public void onDelete(Object entity,
                         Serializable id,
                         Object[] state,
                         String[] propertyNames,
                         Type[] types) {
        // do nothing
    }

    public boolean onFlushDirty(Object entity,
                                Serializable id,
                                Object[] currentState,
                                Object[] previousState,
                                String[] propertyNames,
                                Type[] types) {

//        if ( entity instanceof Auditable ) {
//            updates++;
//            for ( int i=0; i < propertyNames.length; i++ ) {
//                if ( "lastUpdateTimestamp".equals( propertyNames[i] ) ) {
//                    currentState[i] = new Date();
//                    return true;
//                }
//            }
//        }
//        return false;
    	
        logger.debug( "Entity {0}#{1} changed from {2} to {3}",
                entity.getClass().getSimpleName(),
                id,
                Arrays.toString( previousState ),
                Arrays.toString( currentState )
            );
            return super.onFlushDirty( entity, id, currentState,
                previousState, propertyNames, types);
    }

    public boolean onLoad(Object entity,
                          Serializable id,
                          Object[] state,
                          String[] propertyNames,
                          Type[] types) {
//        if ( entity instanceof Auditable ) {
//            loads++;
//        }
        return false;
    }

    public boolean onSave(Object entity,
                          Serializable id,
                          Object[] state,
                          String[] propertyNames,
                          Type[] types) {

//        if ( entity instanceof Auditable ) {
//            creates++;
//            for ( int i=0; i<propertyNames.length; i++ ) {
//                if ( "createTimestamp".equals( propertyNames[i] ) ) {
//                    state[i] = new Date();
//                    return true;
//                }
//            }
//        }
        return false;
    }

    public void afterTransactionCompletion(Transaction tx) {
        if ( tx.getStatus() == TransactionStatus.COMMITTED ) {
            logger.info("Creations: " + creates + ", Updates: " + updates, "Loads: " + loads);
        }
        updates=0;
        creates=0;
        loads=0;
    }
}
