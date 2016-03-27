/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Transformers;

import Data.Models.Abstract.AbsModel;
import Data.Models.Product;
import Data.Models.StockHolder;
import Data.Models.StockItem;
import Infrastructure.Bootstrapper.Container;
import Services.ProductService;
import Services.StockHolderService;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Urban
 */
public class StockItemTransformer implements ITransformer
{
    private final Container _container;
    
    public StockItemTransformer(Container container)
    {
        _container = container;
    }
    
    @Override
    public StockItem Transofrm(ResultSet result)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<AbsModel> TransformAll(ResultSet result)
    {
        List<AbsModel> stockItemList = new ArrayList<>();
        
        try
        {
            while(result.next())
            {
                StockItem newStockItem = new StockItem();
                newStockItem.StockItemId = result.getInt(1);
                newStockItem.StockHolder = GetStockHolderForStockItem(result.getInt(2));
                newStockItem.Product = GetProductForStockItem(result.getInt(3));
                newStockItem.Quantity = result.getInt(4);
                stockItemList.add(newStockItem);
            }
        }
        catch(Exception e)
        {
            System.err.println("Exception: " + e.getMessage());
        }
        
        return stockItemList;  
    }
    
    private StockHolder GetStockHolderForStockItem(int productId)
    {
        StockHolderService stockHolderService = _container.GetStockHolderService();
        return stockHolderService.GetStockHolderById(productId);
    }

    private Product GetProductForStockItem(int productId)
    {
        ProductService productService = _container.GetProductService();
        return productService.GetProductById(productId);
    }
}
