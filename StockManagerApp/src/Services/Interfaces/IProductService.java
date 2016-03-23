/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import Data.Models.Product;
import java.util.List;

/**
 *
 * @author Urban
 */
public interface IProductService
{

    /**
     *  Gets a product by ID
     * @param productId
     * @return
     */
    public Product GetProductById(int productId);

    /**
     *  Avoid using this in case of duplicate products
     * @param productName
     * @return
     */
    public Product GetProductByName(String productName);

    /**
     *  Creates new product
     * @param product
     */
    public void CreateProduct(Product product);

    /**
     *  Deletes product by id
     * @param productId
     */
    public void DeleteProduct(int productId);
    
    /**
     * Gets a list of all products
     * @return 
     */
    public List<Product> GetAllProducts();
}
