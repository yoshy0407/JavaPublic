package com.bench.mark.config;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.OracleDialect;


public class DomaBeanConfig {

	public Config config(DataSource dataSource, Dialect dialect) {
		return new com.bench.mark.repository.doma.config.DomaConfig(dataSource, dialect);
	}
	
	public Dialect dialect() {
		return new OracleDialect();
	}
		
}
