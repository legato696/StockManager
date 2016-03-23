/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.DatabaseContext.DatabaseContext;
import Data.Helpers.IQueryBuilder;
import Data.Models.Product;
import Services.Interfaces.IProductService;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Urban
 */
public class ProductService implements IProductService
{
    private final IQueryBuilder _queryBuilder;
    private final DatabaseContext _dbContext;
    
    public ProductService(IQueryBuilder queryBuilder, DatabaseContext dbContext)
    {
        _queryBuilder = queryBuilder;
        _dbContext = dbContext;
    }
    
    @Override
    public Product GetProductById(int productId)
    {
        ResultSet result;

        _queryBuilder.Select("*");
        _queryBuilder.SetTable("Products");
        _queryBuilder.Where("ProductId = " + productId);
        
        result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        
        return CastResultToProduct(result);
    }

    @Override
    public Product GetProductByName(String productName)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CreateProduct(Product product)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteProduct(int productId)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> GetAllProducts()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Product CastResultToProduct(ResultSet result)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
