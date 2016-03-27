/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.DatabaseContext.DatabaseContext;
import Data.Helpers.IQueryBuilder;
import Data.Models.Abstract.AbsModel;
import Data.Models.Product;
import Services.Interfaces.IProductService;
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
        List<AbsModel> result;

        _queryBuilder.Select("*");
        _queryBuilder.SetTable(Product.TABLE_NAME);
        _queryBuilder.Where("ProductId = " + productId);
        
        result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        
        return (Product)result.get(0);
    }

    @Override
    public Product GetProductByName(String productName)
    {
        List<AbsModel> result;
        
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(Product.TABLE_NAME);
        _queryBuilder.Where("ProductName = '" + productName +"'");
        
        result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        
        return (Product)result.get(0);
    }

    @Override
    public void CreateProduct(Product product)
    {
        List<Product> currentProducts = GetAllProducts();
        Product lastProduct = currentProducts.get(currentProducts.size()-1);
        System.out.println("Last id: " + lastProduct.ProductId);
        String columnsAffected = "ProductId, ProductName";
        String insertData = (lastProduct.ProductId + 1) + ", " +product.ProductName;
        
        _queryBuilder.Insert(columnsAffected, insertData);
        _queryBuilder.SetTable(Product.TABLE_NAME);
        
        _dbContext.ExecuteInsertQuery(_queryBuilder.GetQuery());
    }

    @Override
    public void DeleteProduct(int productId)
    {
        _queryBuilder.Delete();
        _queryBuilder.SetTable(Product.TABLE_NAME);
        _queryBuilder.Where("ProductId = " + productId);
        
        _dbContext.ExecuteDeleteQuery(_queryBuilder.GetQuery());
    }

    @Override
    public List<Product> GetAllProducts()
    {
        List<AbsModel> result;
        
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(Product.TABLE_NAME);
        
        result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        
        return (List<Product>)(List<?>)result;
    }
}
