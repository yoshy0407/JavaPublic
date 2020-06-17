package com.bench.mark.target;


import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.openjdk.jmh.annotations.*;
import org.seasar.doma.jdbc.Config;

import com.bench.mark.config.DomaBeanConfig;
import com.bench.mark.repository.doma.dao.SampleTableDao;
import com.bench.mark.repository.doma.dao.SampleTableDaoImpl;
import com.bench.mark.support.JdbcConstant;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class DomaBenchmarkTest {

	public SampleTableDao sampleTableDao;
	
	@Setup
	public void setup() {
		HikariConfig hConfig = new HikariConfig();
		hConfig.setDriverClassName(JdbcConstant.driverClassName);
		hConfig.setJdbcUrl(JdbcConstant.jdbcUrl);
		hConfig.setUsername(JdbcConstant.username);
		hConfig.setPassword(JdbcConstant.password);
		DataSource dataSource = new HikariDataSource(hConfig);
		DomaBeanConfig beanConfig = new DomaBeanConfig();
		Config config = beanConfig.config(dataSource, beanConfig.dialect());
		sampleTableDao = new SampleTableDaoImpl(config);
	}
	
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select1() {
		sampleTableDao.selectBySqlFile(1);
	}
	
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select10() {
		sampleTableDao.selectBySqlFile(10);
	}
	
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select100() {
		sampleTableDao.selectBySqlFile(100);
	}
	
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select1000() {
		sampleTableDao.selectBySqlFile(1000);
	}

	
    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select10000() {
		sampleTableDao.selectBySqlFile(10000);
	}

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void select100000() {
		sampleTableDao.selectBySqlFile(100000);
	}
	
}
