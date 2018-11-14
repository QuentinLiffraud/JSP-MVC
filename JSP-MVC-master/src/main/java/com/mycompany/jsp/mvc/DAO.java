/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsp.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Matthias
 */
public class DAO {
    protected final DataSource myDataSource;

	/**
	 *
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        public int deleteDiscount_Code(String Code) throws Exception {

		// Une requête SQL paramétrée
		String sql = "DELETE FROM DISCOUNT_CODE AS AUX WHERE DISCOUNT_CODE= ?";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                        // Définir la valeur du paramètre
			stmt.setString(1, Code);
			
			return stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
	}
        
        public int updateDiscount_Code(String code,Float taux) throws Exception {

		// Une requête SQL paramétrée
		String sql = "UPDATE APP.DISCOUNT_CODE SET RATE = ? WHERE DISCOUNT_CODE = ?";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                        // Définir la valeur du paramètre
			stmt.setFloat(1, taux);
                        stmt.setString(2, code);
			
			return stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
	}
        
        public int addDiscount_Code(String Code, float Taux) throws Exception {

		// Une requête SQL paramétrée
		String sql = "INSERT INTO DISCOUNT_CODE VALUES (?,?)";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                        // Définir la valeur du paramètre
			stmt.setString(1, Code);
                        stmt.setFloat(2, Taux);
			
			return stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
	}
        
        public List<DiscountEntity> ListOfDiscount() throws Exception {
		List<DiscountEntity> result = new LinkedList<>(); // Liste vIde

		String sql = "SELECT * FROM DISCOUNT_CODE";
		try (Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) { // Tant qu'il y a des enregistrements
					String Code = rs.getString("DISCOUNT_CODE");
                                        float Taux = rs.getFloat("RATE");
                                        DiscountEntity DE = new DiscountEntity(Code,Taux);
					result.add(DE);
				}
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}

		return result;

	}
        
        public int numberDiscount_Code() throws Exception {
                int result=0;
		// Une requête SQL paramétrée
		String sql = "SELECT COUNT(*) AS Number FROM APP.DISCOUNT_CODE";
		try (Connection connection = myDataSource.getConnection();
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(sql) ){ 
				if (rs.next()) { // Tant qu'il y a des enregistrements
                                    result=rs.getInt("NUMBER");
                                }
			
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
                return result;
        }
        
}
