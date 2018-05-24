package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector.MysqlConnector;
import model.ProviderModel;


public class ProviderDAO {
	private Connection connect = null;
	private MysqlConnector instance = MysqlConnector.getInstance();

	public List<ProviderModel> findListProvider() {
		List<ProviderModel> listProvider = new ArrayList<ProviderModel>();
		connect = instance.getDataBaseConnectionPool();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = connect.prepareStatement("SELECT * FROM provider");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int idProvider = rs.getInt("idProvider");
				String nameProvider = rs.getString("nameProvider");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				ProviderModel nc = new ProviderModel(idProvider, nameProvider, address, phone);
				listProvider.add(nc);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			instance.closeResulset(rs);
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
		return listProvider;
	}
	public void addProvider(ProviderModel providerModel) {
		  PreparedStatement pstm=null;
        try {
        	connect = instance.getDataBaseConnectionPool();
            pstm = connect
                    .prepareStatement("insert into provider(nameProvider,address,phone) values (?, ?, ? )");
            pstm.setString(1, providerModel.getNameProvider());
            pstm.setString(2,providerModel.getAddress());
            pstm.setString(3,providerModel.getPhone());
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
    }
	public void deleteProvider(int idProvider) {
		PreparedStatement pstm = null;
        try {
        	connect = instance.getDataBaseConnectionPool();
             pstm = connect
                    .prepareStatement("DELETE FROM provider WHERE idProvider=?");
            pstm.setInt(1, idProvider);
            pstm.executeUpdate();
            instance.closeConnection(connect);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
        
        
        deleteProductByIdProvider(idProvider);
    }
	
	private void deleteProductByIdProvider(int idProvider) {
//			PreparedStatement pstm = null;
//			int val =0;
//			try {
//				connect = instance.getDataBaseConnectionPool();
//				pstm = connect.prepareStatement("DELETE provider WHERE idProvider =?");
//				pstm.setInt(1, idProvider);
//				val=pstm.executeUpdate();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				instance.closePrepareStatement(pstm);
//				instance.closeConnection(connect);
//			}
//			//Neu val !=0 thi delete thanh cong, nguoc lai that bai
//			return val;	
		}
	
	public void updateProvider(ProviderModel providerModel) {
       
		 PreparedStatement pstm = null;
		 try {
			connect = instance.getDataBaseConnectionPool();
            pstm = connect
                    .prepareStatement("UPDATE provider SET nameProvider=?, address=?, phone=? where idProvider=?");
            pstm.setInt(4, providerModel.getIdProvider());
            pstm.setString(1, providerModel.getNameProvider());
            pstm.setString(2,providerModel.getAddress());
            pstm.setString(3,providerModel.getPhone());
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
    }
	public ProviderModel getProviderById(int idProvider) {
		connect = instance.getDataBaseConnectionPool();
		ProviderModel providerModel = new ProviderModel();
		 PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connect.
                    prepareStatement("select * from provider where idProvider=?");
            preparedStatement.setInt(1, idProvider);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	providerModel.setIdProvider(rs.getInt("idProvider"));
            	providerModel.setNameProvider(rs.getString("nameProvider"));
            	providerModel.setAddress(rs.getString("address"));
            	providerModel.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			instance.closePrepareStatement(preparedStatement);
			instance.closeConnection(connect);
		}

        return providerModel;
    }
}