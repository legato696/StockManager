/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.DatabaseContext.DatabaseContext;
import Data.Helpers.IQueryBuilder;
import Data.Models.Abstract.AbsModel;
import Data.Models.StockHolder;
import Services.Interfaces.IStockHolderService;
import java.util.List;

/**
 *
 * @author Urban
 */
public class StockHolderService implements IStockHolderService
{
    private final IQueryBuilder _queryBuilder;
    private final DatabaseContext _dbContext;
      
    public StockHolderService(IQueryBuilder queryBuilder, DatabaseContext dbContext)
    {
        _queryBuilder = queryBuilder;
        _dbContext = dbContext;
    }
    
    @Override
    public StockHolder GetStockHolderById(int stockHolderId)
    {
        List<AbsModel> result;
        
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(StockHolder.TABLE_NAME);
        _queryBuilder.Where("StockHolderId = " + stockHolderId);
        
        result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        return (StockHolder)result.get(0);
    }

    @Override
    public StockHolder GetStockHolderByName(String stockHolderName)
    {
        List<AbsModel> result;
        
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(StockHolder.TABLE_NAME);
        _queryBuilder.Where("Name = " + stockHolderName);
        
        result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        return (StockHolder)result.get(0);
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
        _queryBuilder.Delete();
        _queryBuilder.SetTable(StockHolder.TABLE_NAME);
        _queryBuilder.Where("StockHolderId = " + stockHolderId);
        _dbContext.ExecuteDeleteQuery(_queryBuilder.GetQuery());
    }

    @Override
    public List<StockHolder> GetAllStockHolders()
    {
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(StockHolder.TABLE_NAME);
        List<AbsModel> result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        
        return (List<StockHolder>)(List<?>)result;
    }
}
