package com.bench.mark.repository.doma.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import com.bench.mark.repository.doma.entity.SampleTableEntity;

@Dao
public interface SampleTableDao {

	@Select
	public List<SampleTableEntity> selectBySqlFile(long primaryKey);
	
}
