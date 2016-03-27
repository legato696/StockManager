/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Helpers;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Urban
 */
public class QueryBuilderTest
{
    
    public QueryBuilderTest()
    {
    }

    @Test
    public void BasicSelectQuery_AllValid_ReturnsExpectedQuery()
    {
        System.out.println("BasicSelect");
        String expected = "SELECT * FROM TEST WHERE Test_Column = 5";
        String actual;
        QueryBuilder instance = new QueryBuilder();
        
        instance.Select("*");
        instance.SetTable("TEST");
        instance.Where("Test_Column = 5");
        
        actual = instance.GetQuery();
        
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void BasicUpdateQuery_AllValid_ReturnsExpectedQuery()
    {
        System.out.println("BasicUpdate");
        String expected = "UPDATE TEST SET TestColumnTestColumn='UpdateValue' WHERE Test_Column = 5";
        String actual;
        QueryBuilder instance = new QueryBuilder();
        
        instance.Update("TestColumn", "UpdateValue");
        instance.SetTable("TEST");
        instance.Where("Test_Column = 5");
        
        actual = instance.GetQuery();
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void BasicInsertQuery_AllValid_ReturnsExpectedQuery()
    {
        System.out.println("BasicInsert");
        String expected = "INSERT INTO TestTable(TestColumn, TestColumn2, TestColumn3) VALUES (1, Tester, Five)";
        String actual;
        QueryBuilder instance = new QueryBuilder();
        
        instance.Insert("TestColumn, TestColumn2, TestColumn3", "1, Tester, Five");
        instance.SetTable("TestTable");
        
        actual = instance.GetQuery();
     
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void BasicDeleteQuery_AllValid_ReturnsExpectedQuery()
    {
        System.out.println("BasicInsert");
        String expected = "DELETE FROM TestTable WHERE Column1 = 'Test'";
        String actual;
        QueryBuilder instance = new QueryBuilder();
        
        instance.Delete();
        instance.SetTable("TestTable");
        instance.Where("Column1 = 'Test'");
        
        actual = instance.GetQuery();
        
        Assert.assertEquals(expected, actual);
    }
}
