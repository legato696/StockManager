/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infrastructure.Bootstrapper;

import Data.DatabaseContext.*;
import Data.Helpers.*;
import Services.*;
import Services.Transformers.*;

/**
 *
 * @author Urban
 */
public class Container
{
    //ConnectionStrings Resolver section
    public ConnectionStrings GetConnectionStrings()
    {
        return new ConnectionStrings();
    }
    //End ConnectionStrings Resolver section
    
    //DatabaseContext Section
    public DatabaseContext GetDatabaseContext()
    {
        return new DatabaseContext(GetConnectionStrings());
    }
    
    //End DatabaseContext section
    
    //QueryBuilder Section
    public IQueryBuilder GetQueryBuilder()
    {
        return new QueryBuilder();
    }
    //End Querybuilder section
    
    
    //Transformer Section
    public ITransformer GetProductTransformer()
    {
        return new ProductTransformer();
    }
    
    public ITransformer GetStockHolderTransformer()
    {
        return new StockHolderTransformer();
    }
    
    public ITransformer GetStockItemTransformer()
    {
        return new StockItemTransformer();
    }
    
    public ITransformer GetUserTransformer()
    {
        return new UserTransformer();
    }
    //End Transformer section
    
    //Service Section
    public ProductService GetProductService()
    {
        return new ProductService(GetQueryBuilder(), GetProductTransformer(), GetDatabaseContext());
    }
    
    public StockHolderService GetStockHolderService()
    {
        return new StockHolderService(GetQueryBuilder(), GetStockHolderTransformer(), GetDatabaseContext());
    }
    
    public StockItemService GetStockItemService()
    {
        return new StockItemService(GetQueryBuilder(), GetStockItemTransformer(), GetDatabaseContext());
    }
    //End Service section
}
