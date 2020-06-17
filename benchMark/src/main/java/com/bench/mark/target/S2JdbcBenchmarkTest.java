package com.bench.mark.target;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;
import javax.sql.XADataSource;
import javax.transaction.TransactionManager;
import javax.transaction.TransactionSynchronizationRegistry;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.seasar.extension.dbcp.ConnectionPool;
import org.seasar.extension.jdbc.ColumnMetaFactory;
import org.seasar.extension.jdbc.DbmsDialect;
import org.seasar.extension.jdbc.EntityMetaFactory;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.PropertyMetaFactory;
import org.seasar.extension.jdbc.TableMetaFactory;
import org.seasar.framework.convention.PersistenceConvention;

import com.bench.mark.config.S2JdbcConfig;
import com.bench.mark.repository.s2jdbc.entity.SampleTableEntity;
import com.bench.mark.support.S2SqlLogger;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class S2JdbcBenchmarkTest {

	JdbcManager jdbcManager;
	
	String sqlFilePath = "META-INF/com/bench/mark/repository/doma/dao/SampleTableDao/selectBySqlFile.sql";
	
	S2SqlLogger logger;
	
	@Setup
	public void setup() {
		S2JdbcConfig beanConfig = new S2JdbcConfig();
		XADataSource xaDataSource = beanConfig.xaDataSource();
		TransactionManager internalTransactionManager = beanConfig.internalTransactionManager();
		ConnectionPool connectionPool = beanConfig.connectionPool(xaDataSource, internalTransactionManager);
		DataSource s2dataSource = beanConfig.s2dataSource(connectionPool);
		
		PersistenceConvention persistenceConvention = beanConfig.persistenceConvention();
		ColumnMetaFactory columnMetaFactory = beanConfig.columnMetaFactory(persistenceConvention);
		PropertyMetaFactory propertyMetaFactory = beanConfig.propertyMetaFactory(persistenceConvention, columnMetaFactory);
		TableMetaFactory tableMetaFactory = beanConfig.tableMetaFactory(persistenceConvention);		
		EntityMetaFactory entityMetaFactory = beanConfig.entityMetaFactory(persistenceConvention, propertyMetaFactory, tableMetaFactory);
		
		DbmsDialect s2dialect = beanConfig.s2dialect();
		
		TransactionSynchronizationRegistry syncRegistry = beanConfig.syncRegistry(internalTransactionManager);
		
		jdbcManager = beanConfig.jdbcManager(s2dataSource, entityMetaFactory, s2dialect, syncRegistry, persistenceConvention);
		logger = new S2SqlLogger();
	}
	
	@Benchmark
	@BenchmarkMode(Mode.SampleTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select1() {
		jdbcManager
			.selectBySqlFile(SampleTableEntity.class, sqlFilePath,createParam(1))
			.getResultList();
		logger.info();
	}
		
	@Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select10() {
		jdbcManager
		.selectBySqlFile(SampleTableEntity.class, sqlFilePath,createParam(10))
		.getResultList();
		logger.info();
	}
	
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select100() {
		jdbcManager
		.selectBySqlFile(SampleTableEntity.class, sqlFilePath,createParam(100))
		.getResultList();
		logger.info();
	}
	
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select1000() {
		jdbcManager
		.selectBySqlFile(SampleTableEntity.class, sqlFilePath,createParam(1000))
		.getResultList();
		logger.info();
	}

	
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select10000() {
		jdbcManager
		.selectBySqlFile(SampleTableEntity.class, sqlFilePath,createParam(10000))
		.getResultList();
		logger.info();
	}

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select100000() {
		jdbcManager
		.selectBySqlFile(SampleTableEntity.class, sqlFilePath,createParam(100000))
		.getResultList();
		logger.info();
	}
    
    public Map<String, Object> createParam(int num){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("primaryKey", num);
    	return map;
    }
}
