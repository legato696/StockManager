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
import Services.Transformers.ITransformer;
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
    private final ITransformer _transformer;
    
    public ProductService(IQueryBuilder queryBuilder, ITransformer transformer,DatabaseContext dbContext)
    {
        _queryBuilder = queryBuilder;
        _transformer = transformer;
        _dbContext = dbContext;
    }
    
    @Override
    public Product GetProductById(int productId)
    {
        ResultSet result;

        _queryBuilder.Select("*");
        _queryBuilder.SetTable(Product.TABLE_NAME);
        _queryBuilder.Where("ProductId = " + productId);
        
        result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        
        return (Product)_transformer.Transofrm(result);
    }

    @Override
    public Product GetProductByName(String productName)
    {
        ResultSet result;
        
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(Product.TABLE_NAME);
        _queryBuilder.Where("Name = " + productName);
        
        result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        
        return (Product)_transformer.Transofrm(result);
    }

    @Override
    public void CreateProduct(Product product)
    {
        String columnsAffected = "Name";
        String insertData = product.ProductName;
        _queryBuilder.Insert(columnsAffected, insertData);
        _dbContext.ExecuteInsertQuery(_queryBuilder.GetQuery());
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
}
