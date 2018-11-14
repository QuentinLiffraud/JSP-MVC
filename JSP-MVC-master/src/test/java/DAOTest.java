/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.jsp.mvc.DAO;
import com.mycompany.jsp.mvc.DataSourceFactory;
import com.mycompany.jsp.mvc.DiscountEntity;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Matthias
 */
public class DAOTest {
	private DAO myDAO; // L'objet à tester
	private DataSource myDataSource; // La source de données à utiliser
	

	@Before
	public void setUp() throws SQLException {
		myDataSource = DataSourceFactory.getDataSource();
		myDAO = new DAO(myDataSource);
	}
	
	/**
	 * Test of numberOfCustomers method, of class DAO.
	 * @throws simplejdbc.DAOException
	 */
	@Test
	public void testNumberDiscount() throws Exception {
		List<DiscountEntity> result = myDAO.ListOfDiscount();
                System.out.println(result);
                System.out.println(result.get(0).getCode());
		assertEquals(4, result.size());
	}
	
        @Test
	public void testAddDiscount() throws Exception {
                myDAO.addDiscount_Code("C", (float) 1.25);
                List<DiscountEntity> result = myDAO.ListOfDiscount();
		assertEquals(myDAO.numberDiscount_Code(), result.size());
	}
        
        @Test
	public void testDeleteDiscount() throws Exception {
                myDAO.deleteDiscount_Code("C");
                List<DiscountEntity> result = myDAO.ListOfDiscount();
		assertEquals(myDAO.numberDiscount_Code(), result.size());
	}
}