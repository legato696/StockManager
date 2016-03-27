/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.DatabaseContext;

import Data.Models.Abstract.AbsModel;
import Data.Models.Product;
import Services.Transformers.ITransformer;
import Services.Transformers.ProductTransformer;
import java.sql.ResultSet;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Urban
 */
public class DatabaseContextIT
{
    private final ConnectionStrings _cStrings;
    private ITransformer _transformer;
    
    
    public DatabaseContextIT()
    {
        _cStrings = new ConnectionStrings();
        _cStrings.connection = "jdbc:sqlserver://dbstockcontrol.database.windows.net:1433;database=DBStockManager;user=dbstockcontoller@dbstockcontrol;password=!DBAdmin;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    }

    /**
     * Test of ExecuteSelectQuery method, of class DatabaseContext.
     */
    @Test
    public void SelectQuerry_TestDataExists_ResultListNotNull()
    {
        System.out.println("SelectQuery");
        String query = "SELECT * FROM dbo.Products";
        _transformer = new ProductTransformer();
        
        DatabaseContext instance = new DatabaseContext(_cStrings, _transformer);
        List<AbsModel> result = instance.ExecuteSelectQuery(query);
        Assert.assertTrue(result != null);
    }
    
    /**
     * Test of ExecuteSelectQuery method, of class DatabaseContext.
     */
    @Test
    public void SelectQuerry_TestDataExists_ResultSetValue()
    {
        System.out.println("SelectQuery");
        String query = "SELECT * FROM dbo.Products";
        _transformer = new ProductTransformer();
        
        DatabaseContext instance = new DatabaseContext(_cStrings, _transformer);
        List<AbsModel> result = instance.ExecuteSelectQuery(query);
        
        Product firstProduct = (Product)result.get(0);
        Assert.assertEquals(1, firstProduct.ProductId);
    }
    
    /**
     * Test of ExecuteInsertQuery method, of class DatabaseContext.
     */
    @Test
    public void InsertQuery_AllValid_DataInsertedInTheDatabase()
    {
        System.out.println("InsertQuery");
        String query = "INSERT INTO dbo.Products (ProductId, ProductName) VALUES (9, 'TestProduct')";
        _transformer = new ProductTransformer();
        
        DatabaseContext instance = new DatabaseContext(_cStrings, _transformer);
        boolean result = instance.ExecuteInsertQuery(query);

        Assert.assertEquals(true, result);
    }
    
    @Test
    public void DeleteQuery_RecordExists_DataDeleted()
    {
        System.out.println("DeleteQuery");
        String query = "DELETE FROM dbo.Products" +
                       " WHERE ProductId = " + 9;
        _transformer = new ProductTransformer();
        
        DatabaseContext instance = new DatabaseContext(_cStrings, _transformer);
        boolean result = instance.ExecuteInsertQuery(query);

        Assert.assertEquals(true, result);
    }
    
     @Test
    public void UpdateQuery_RecordExists_DataDeleted()
    {
        System.out.println("UpdateQuery");
        String query = "UPDATE dbo.Products" +
                       " SET ProductName = 'iPodTouch'" +
                       " WHERE ProductId = 9;";
                                               
        _transformer = new ProductTransformer();
        
        DatabaseContext instance = new DatabaseContext(_cStrings, _transformer);
        boolean result = instance.ExecuteInsertQuery(query);

        Assert.assertEquals(true, result);
    }
}
