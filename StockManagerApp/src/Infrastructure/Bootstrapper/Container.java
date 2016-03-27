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
        String string = "jdbc:sqlserver://dbstockcontrol.database.windows.net:1433;database=DBStockManager;user=dbstockcontoller@dbstockcontrol;password=!DBAdmin;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        ConnectionStrings stringsObject = new ConnectionStrings(); 
        stringsObject.connection = string;
        return stringsObject;
    }
    //End ConnectionStrings Resolver section
    
    //DatabaseContext Section
    public DatabaseContext GetProductDatabaseContext()
    {
        return new DatabaseContext(GetConnectionStrings(), GetProductTransformer());
    }
    
    public DatabaseContext GetStockItemDatabaseContext()
    {
        return new DatabaseContext(GetConnectionStrings(), GetStockItemTransformer());
    }    
    
    public DatabaseContext GetStockHolderDatabaseContext()
    {
        return new DatabaseContext(GetConnectionStrings(), GetStockHolderTransformer());
    }    
    
    public DatabaseContext GetUserDatabaseContext()
    {
        return new DatabaseContext(GetConnectionStrings(), GetUserTransformer());
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
        return new ProductService(GetQueryBuilder(), GetProductDatabaseContext());
    }
    
    public StockHolderService GetStockHolderService()
    {
        return new StockHolderService(GetQueryBuilder(), GetStockHolderDatabaseContext());
    }
    
    public StockItemService GetStockItemService()
    {
        return new StockItemService(GetQueryBuilder(), GetStockItemDatabaseContext());
    }
    
    public UserService GetUserService()
    {
        return new UserService(GetQueryBuilder(), GetStockItemDatabaseContext());
    }
    //End Service section
}
