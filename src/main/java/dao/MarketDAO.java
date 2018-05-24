package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector.MysqlConnector;
import model.MarketModel;

public class MarketDAO {
	private Connection connect = null;
	private MysqlConnector instance = MysqlConnector.getInstance();

	public List<MarketModel> findListMarket() {
		List<MarketModel> listMarket = new ArrayList<MarketModel>();
		connect = instance.getDataBaseConnectionPool();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = connect.prepareStatement("SELECT * FROM market");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int idMarket = rs.getInt("idMarket");
				String nameMarket = rs.getString("nameMarket");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				MarketModel nc = new MarketModel(idMarket, nameMarket, address, phone);
				listMarket.add(nc);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			instance.closeResulset(rs);
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
		return listMarket;
	}

	public void deleteMarket(int idMarket) {
		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("DELETE FROM market WHERE idMarket=?");
			pstm.setInt(1, idMarket);
			pstm.executeUpdate();
			instance.closeConnection(connect);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public void addMarket(MarketModel marketModel) {
		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("insert into market(nameMarket,address,phone) values (?, ?, ? )");
			pstm.setString(1, marketModel.getNameMarket());
			pstm.setString(2, marketModel.getAddress());
			pstm.setString(3, marketModel.getPhone());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public void updateMarket(MarketModel marketModel) {

		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("UPDATE market SET nameMarket=?, address=?, phone=? where idMarket=?");
			pstm.setInt(4, marketModel.getIdMarket());
			pstm.setString(1, marketModel.getNameMarket());
			pstm.setString(2, marketModel.getAddress());
			pstm.setString(3, marketModel.getPhone());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public MarketModel getMarketById(int idMarket) {
		connect = instance.getDataBaseConnectionPool();
		MarketModel marketModel = new MarketModel();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect.prepareStatement("select * from market where idMarket=?");
			preparedStatement.setInt(1, idMarket);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				marketModel.setIdMarket(rs.getInt("idMarket"));
				marketModel.setNameMarket(rs.getString("nameMarket"));
				marketModel.setAddress(rs.getString("address"));
				marketModel.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(preparedStatement);
			instance.closeConnection(connect);
		}

		return marketModel;
	}
}
