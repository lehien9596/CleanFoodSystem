/**
 * 
 */
/**
 * @author Administrator
 *
 */
package connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class MysqlConnector {
	private static MysqlConnector dbc = null;
	private BasicDataSource connectionPool = null;
	private Connection conn = null;
	private final String USERNAME = "root";// dien user name cua em
	private final String PASSWORD = "123456"; // dien password cua em
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/hethongtruyxuat?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	private final int MAX_IDLE = 10;
	private final long MAX_WAIT_MILLIS = 10000;
	private final int MAX_OPEN_PREPARE_STATEMENT = 50;
	private final int INIT_SIXE = 5;

	private MysqlConnector() {
		connectionPool = new BasicDataSource();
		connectionPool.setUsername(USERNAME);
		connectionPool.setPassword(PASSWORD);
		connectionPool.setDriverClassName(DRIVER);
		connectionPool.setUrl(URL);
		connectionPool.setMaxIdle(MAX_IDLE);
		connectionPool.setMaxWait(MAX_WAIT_MILLIS);
		connectionPool.setTestOnBorrow(true);
		connectionPool.setTestWhileIdle(true);
		connectionPool.setInitialSize(INIT_SIXE);
		connectionPool.setMaxOpenPreparedStatements(MAX_OPEN_PREPARE_STATEMENT);
		connectionPool.setTestWhileIdle(true);
	}

	/**
	 * @return Tra ve chinh no
	 */
	public static MysqlConnector getInstance() {
		if (dbc == null) {
			dbc = new MysqlConnector();
		}
		return dbc;
	}

	/**
	 * @return Tra ve connection
	 */
	public Connection getDataBaseConnectionPool() {
		try {
			conn = connectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closePrepareStatement(PreparedStatement pstm) {
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeResulset(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}