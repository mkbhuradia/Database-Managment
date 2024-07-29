package com.dao;

import java.sql.Connection;

public interface DaoInterction {
	void fetchData(Connection con);
	void insertData();
	void deleteData();
	void updateDate();
}
