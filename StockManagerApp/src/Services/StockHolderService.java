/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.DatabaseContext.DatabaseContext;
import Data.Helpers.IQueryBuilder;
import Data.Models.StockHolder;
import Services.Interfaces.IStockHolderService;
import Services.Transformers.ITransformer;
import java.sql.ResultSet;

/**
 *
 * @author Urban
 */
public class StockHolderService implements IStockHolderService
{
    private final IQueryBuilder _queryBuilder;
    private final DatabaseContext _dbContext;
    private final ITransformer _transformer;
    
    
    public StockHolderService(IQueryBuilder queryBuilder, ITransformer transformer, DatabaseContext dbContext)
    {
        _queryBuilder = queryBuilder;
        _transformer = transformer;
        _dbContext = dbContext;
    }
    
    @Override
    public StockHolder GetStockHolderById(int stockHolderId)
    {
        ResultSet result;
        
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(StockHolder.TABLE_NAME);
        _queryBuilder.Where("StockHolderId = " + stockHolderId);
        
        result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
    
        return (StockHolder)_transformer.Transofrm(result);
    }

    @Override
    public StockHolder GetStockHolderByName(String stockHolderName)
    {
        ResultSet result;
        
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(StockHolder.TABLE_NAME);
        _queryBuilder.Where("Name = " + stockHolderName);
        
        result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
    
        return (StockHolder)_transformer.Transofrm(result);
    }

    @Override
    public void CreateStockHolder(StockHolder stockHolder)
    {
        _queryBuilder.SetTable(StockHolder.TABLE_NAME);
        _queryBuilder.Insert("Name", stockHolder.Name);
        _dbContext.ExecuteInsertQuery(_queryBuilder.GetQuery());
    }

    @Override
    public void DeleteStockHolderById(int stockHolderId)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
