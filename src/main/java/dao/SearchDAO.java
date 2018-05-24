package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import connector.MysqlConnector;

public class SearchDAO {
	private Connection connect = null;
	private MysqlConnector instance = MysqlConnector.getInstance();

	public ResultSet search(String textSearch, List<String> fieldSearchs, String tableNameSearch) {
		connect = instance.getDataBaseConnectionPool();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		if (fieldSearchs != null && !fieldSearchs.isEmpty()) {
			StringBuffer buff = new StringBuffer();
			int size = fieldSearchs.size();
			int index = 0;
			for (String field : fieldSearchs) {
				if (index == 0)
					buff.append(field + " LIKE ? ");
				else
					buff.append("OR " + field + " LIKE ? ");
				index++;
			}
			String QUERY = "SELECT * FROM " + tableNameSearch + " WHERE " + buff.toString();
			System.out.println(QUERY);
			try {
				pstm = connect.prepareStatement(QUERY);
				for (int i = 1; i <= size; i++) {
					pstm.setString(i, "%" + textSearch + "%");
				}
				rs = pstm.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}
		return rs;
	}
}
