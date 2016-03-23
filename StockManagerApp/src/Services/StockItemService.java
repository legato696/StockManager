/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.DatabaseContext.DatabaseContext;
import Data.Helpers.IQueryBuilder;
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
    private final ITransformer _transformer;
    private final DatabaseContext _dbContext;
    
    public StockItemService(IQueryBuilder queryBuilder, ITransformer transformer, DatabaseContext dbContext)
    {
        _queryBuilder = queryBuilder;
        _transformer = transformer;
        _dbContext = dbContext;
    }
    
    @Override
    public StockItem GetStockItemForStockHolder(StockHolder stockHolder, int productId)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateStockItem(StockItemUpdateRequest stockUpdateRequest)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CreateStockItemForStockHolder(StockHolder stockHolder, Product product)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StockItem> GetAllStockItemsForStockHolder(StockHolder stockHolder)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
