/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.Models.Product;
import Infrastructure.Bootstrapper.Container;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Urban
 */
public class ProductServiceTest
{
    Container _container;
    
    public ProductServiceTest()
    {
        _container = new Container();
    }
    
    /**
     * Test of GetProductById method, of class ProductService.
     */
    @Test
    public void testGetProductById()
    {
        System.out.println("GetProductById");
        int productId = 1;
        ProductService instance = _container.GetProductService();
        Product result = instance.GetProductById(productId);
        
        assertEquals(productId, result.ProductId);
    }

    /**
     * Test of GetProductByName method, of class ProductService.
     */
    @Test
    public void testGetProductByName()
    {
        System.out.println("GetProductByName");
        String productName = "iPod";
        ProductService instance = _container.GetProductService();
        Product result = instance.GetProductByName(productName);
        assertEquals(1, result.ProductId);
    }

    /**
     * Test of CreateProduct method, of class ProductService.
     */
    @Test
    public void testCreateProduct()
    {
        System.out.println("CreateProduct");
        Product product = new Product();
        product.ProductName = "'TestProduct'";
        ProductService instance = _container.GetProductService();
        instance.CreateProduct(product);

    }

    /**
     * Test of DeleteProduct method, of class ProductService.
     */
    @Test
    public void testDeleteProduct()
    {
        System.out.println("DeleteProduct");
        int productId = 9;
        ProductService instance =  _container.GetProductService();
        instance.DeleteProduct(productId);
    }

    /**
     * Test of GetAllProducts method, of class ProductService.
     */
    @Test
    public void testGetAllProducts()
    {
        System.out.println("GetAllProducts");
        ProductService instance =  _container.GetProductService();
        List<Product> result = instance.GetAllProducts();
        assertTrue(result.size() > 0);
    }
    
}
