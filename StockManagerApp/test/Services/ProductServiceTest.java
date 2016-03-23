/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.Models.Product;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Urban
 */
public class ProductServiceTest
{
    
    public ProductServiceTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of GetProductById method, of class ProductService.
     */
    @Test
    public void testGetProductById()
    {
        System.out.println("GetProductById");
        int productId = 0;
        ProductService instance = null;
        Product expResult = null;
        Product result = instance.GetProductById(productId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetProductByName method, of class ProductService.
     */
    @Test
    public void testGetProductByName()
    {
        System.out.println("GetProductByName");
        String productName = "";
        ProductService instance = null;
        Product expResult = null;
        Product result = instance.GetProductByName(productName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateProduct method, of class ProductService.
     */
    @Test
    public void testCreateProduct()
    {
        System.out.println("CreateProduct");
        Product product = null;
        ProductService instance = null;
        instance.CreateProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeleteProduct method, of class ProductService.
     */
    @Test
    public void testDeleteProduct()
    {
        System.out.println("DeleteProduct");
        int productId = 0;
        ProductService instance = null;
        instance.DeleteProduct(productId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllProducts method, of class ProductService.
     */
    @Test
    public void testGetAllProducts()
    {
        System.out.println("GetAllProducts");
        ProductService instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.GetAllProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
