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
import Data.Models.Requests.StockItemUpdateRequest;
import Data.Models.StockHolder;
import Data.Models.StockItem;
import Services.Interfaces.IStockItemService;
import Services.Transformers.ITransformer;
import java.util.List;

/**
 *
 * @author Urban
 */
public class StockItemService implements IStockItemService
{
    private final IQueryBuilder _queryBuilder;
    private final DatabaseContext _dbContext;
    
    public StockItemService(IQueryBuilder queryBuilder, DatabaseContext dbContext)
    {
        _queryBuilder = queryBuilder;
        _dbContext = dbContext;
    }
    
    @Override
    public StockItem GetStockItemForStockHolder(StockHolder stockHolder, int productId)
    {
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(StockItem.TABLE_NAME);
        _queryBuilder.Where("StockHolderId = " + stockHolder.StockHolderId + " AND ProductId = " + productId);
        List<AbsModel> result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        return (StockItem)result.get(0);
    }

    @Override
    public void UpdateStockItem(StockItemUpdateRequest stockUpdateRequest)
    {
        _queryBuilder.Update("Quantity", Integer.toString(stockUpdateRequest.NewQuantity));
        _queryBuilder.SetTable(StockItem.TABLE_NAME);
        _queryBuilder.Where("StockItemId = " + stockUpdateRequest.StockItemId);
        _dbContext.ExecuteUpdateQuery(_queryBuilder.GetQuery());
    }

    @Override
    public void CreateStockItemForStockHolder(StockHolder stockHolder, Product product)
    {
        _queryBuilder.Insert("StockItemId, StockHolderId, ProductId, Quantity", 
                (GetLastStockItemID() + 1) + ", " + stockHolder.StockHolderId + ", " + product.ProductId + ", " + 0 );
        _queryBuilder.SetTable(StockItem.TABLE_NAME);
        _dbContext.ExecuteInsertQuery(_queryBuilder.GetQuery());
    }

    @Override
    public List<StockItem> GetAllStockItemsForStockHolder(StockHolder stockHolder)
    {
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(StockItem.TABLE_NAME);
        _queryBuilder.Where("StockHolderId = " + stockHolder.StockHolderId);
        List<AbsModel> result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        return (List<StockItem>)(List<?>) result;
    }
    
    private int GetLastStockItemID()
    {
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(StockItem.TABLE_NAME);
        List<AbsModel> result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        StockItem lastItem = (StockItem)result.get(result.size() - 1);
        return lastItem.StockItemId;
    }
    
}
