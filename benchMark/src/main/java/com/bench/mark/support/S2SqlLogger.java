package com.bench.mark.support;

import java.util.logging.Logger;

import org.seasar.extension.jdbc.SqlLog;
import org.seasar.extension.jdbc.SqlLogRegistry;
import org.seasar.extension.jdbc.SqlLogRegistryLocator;

public class S2SqlLogger {

	Logger logger;
	
	public S2SqlLogger() {
		logger = Logger.getLogger(getClass().getSimpleName());
	}
	
	public void info() {
        SqlLogRegistry sqlLogRegistry = SqlLogRegistryLocator.getInstance();
        SqlLog sqlLog = sqlLogRegistry.getLast();
        if (sqlLog != null ) {
            logger.info(sqlLog.getCompleteSql());
        }

	}
}
