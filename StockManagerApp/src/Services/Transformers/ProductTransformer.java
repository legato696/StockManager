/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Transformers;

import Data.Models.Abstract.AbsModel;
import Data.Models.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Urban
 */
public class ProductTransformer implements ITransformer
{

    @Override
    public Product Transofrm(ResultSet result)
    {
        Product product;
        
        product = (Product)TransformAll(result).get(0);
        
        return product;
    }

    @Override
    public List<AbsModel> TransformAll(ResultSet result)
    {
        List<AbsModel> productList = new ArrayList<>();
        
        try
        {
            while(result.next())
            {
                Product newProduct = new Product();
                newProduct.ProductId = result.getInt(1);
                newProduct.ProductName = result.getString(2);
                
                productList.add(newProduct);
            }
        }
        catch(Exception e)
        {
            System.err.println("Exception: " + e.getMessage());
        }
        
        return productList;    
    }
    
}
