package com.bench.mark.config;

import javax.sql.DataSource;
import javax.sql.XADataSource;
import javax.transaction.TransactionManager;
import javax.transaction.TransactionSynchronizationRegistry;

import org.seasar.extension.dbcp.ConnectionPool;
import org.seasar.extension.dbcp.impl.ConnectionPoolImpl;
import org.seasar.extension.dbcp.impl.DataSourceImpl;
import org.seasar.extension.dbcp.impl.XADataSourceImpl;
import org.seasar.extension.jdbc.ColumnMetaFactory;
import org.seasar.extension.jdbc.DbmsDialect;
import org.seasar.extension.jdbc.EntityMetaFactory;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.PropertyMetaFactory;
import org.seasar.extension.jdbc.TableMetaFactory;
import org.seasar.extension.jdbc.dialect.OracleDialect;
import org.seasar.extension.jdbc.manager.JdbcManagerImpl;
import org.seasar.extension.jdbc.meta.ColumnMetaFactoryImpl;
import org.seasar.extension.jdbc.meta.EntityMetaFactoryImpl;
import org.seasar.extension.jdbc.meta.PropertyMetaFactoryImpl;
import org.seasar.extension.jdbc.meta.TableMetaFactoryImpl;
import org.seasar.extension.jta.TransactionManagerImpl;
import org.seasar.extension.jta.TransactionSynchronizationRegistryImpl;
import org.seasar.framework.convention.PersistenceConvention;
import org.seasar.framework.convention.impl.PersistenceConventionImpl;

import com.bench.mark.support.JdbcConstant;

public class S2JdbcConfig {

	public XADataSource xaDataSource() {
		XADataSourceImpl bean = new XADataSourceImpl();
		bean.setDriverClassName(JdbcConstant.driverClassName);
		bean.setURL(JdbcConstant.jdbcUrl);
		bean.setUser(JdbcConstant.username);
		bean.setPassword(JdbcConstant.password);
		return bean;
	}
	
	public TransactionManager internalTransactionManager() {
		return new TransactionManagerImpl();
	}
	
	public ConnectionPool connectionPool(XADataSource xaDataSource, TransactionManager internalTransactionManager) {
		ConnectionPoolImpl bean = new ConnectionPoolImpl();
		bean.setTimeout(600);
		bean.setMaxPoolSize(10);
		bean.setAllowLocalTx(true);
		bean.setValidationQuery("select * from dual");
		bean.setValidationInterval(10000);
		bean.setXADataSource(xaDataSource);
		bean.setTransactionManager(internalTransactionManager);
		return bean;
	}
	
	public DataSource s2dataSource(ConnectionPool connectionPool) {
		return new DataSourceImpl(connectionPool);
	}
		
	public TransactionSynchronizationRegistry syncRegistry(TransactionManager internalTransactionManager) {
		return  new TransactionSynchronizationRegistryImpl(internalTransactionManager);
	}

	public PersistenceConvention persistenceConvention() {
		return new PersistenceConventionImpl();	
	}
	
	public ColumnMetaFactory columnMetaFactory(PersistenceConvention persistenceConvention) {
		ColumnMetaFactoryImpl bean = new ColumnMetaFactoryImpl();
		bean.setPersistenceConvention(persistenceConvention);
		return bean;
	}
	
	public PropertyMetaFactory propertyMetaFactory(PersistenceConvention persistenceConvention, ColumnMetaFactory columnMetaFactory) {
		PropertyMetaFactoryImpl bean = new PropertyMetaFactoryImpl();
		bean.setColumnMetaFactory(columnMetaFactory);
		bean.setPersistenceConvention(persistenceConvention);
		return bean;
	}
	
	public TableMetaFactory tableMetaFactory(PersistenceConvention persistenceConvention) {
		TableMetaFactoryImpl bean = new TableMetaFactoryImpl();
		bean.setPersistenceConvention(persistenceConvention);
		return bean;
	}

	
	public EntityMetaFactory entityMetaFactory(PersistenceConvention persistenceConvention, PropertyMetaFactory propertyMetaFactory, TableMetaFactory tableMetaFactory) {
		EntityMetaFactoryImpl bean = new EntityMetaFactoryImpl();
		bean.setPersistenceConvention(persistenceConvention);
		bean.setPropertyMetaFactory(propertyMetaFactory);
		bean.setTableMetaFactory(tableMetaFactory);
		return bean;
	}
	
	public DbmsDialect s2dialect() {
		return new OracleDialect();
	}
	
	public JdbcManager jdbcManager(DataSource s2dataSource, 
			                                           EntityMetaFactory entityMetaFactory, 
			                                           DbmsDialect s2dialect, 
			                                           TransactionSynchronizationRegistry syncRegistry, 
			                                           PersistenceConvention persistenceConvention) {
		JdbcManagerImpl bean = new JdbcManagerImpl();
		bean.setDataSource(s2dataSource);
		bean.setEntityMetaFactory(entityMetaFactory);
		bean.setDialect(s2dialect);
		bean.setSyncRegistry(syncRegistry);
		bean.setPersistenceConvention(persistenceConvention);
		return bean;
	}
	
}
