/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import Data.Models.Product;
import Data.Models.Requests.StockItemUpdateRequest;
import Data.Models.StockHolder;
import Data.Models.StockItem;
import java.util.List;

/**
 *
 * @author Urban
 */
public interface IStockItemService
{

    /**
     *  Gets a StockItem object for the given StockHolder with the product id specified
     * 
     * @param stockHolder
     * @param productId
     * @return
     */
    public StockItem GetStockItemForStockHolder(StockHolder stockHolder, int productId);
    
    /**
     * Updates the stockItem from the request.
     * The request is used to define the fields that CAN be updated
     * 
     * @param stockUpdateRequest 
     */
    public void UpdateStockItem(StockItemUpdateRequest stockUpdateRequest);
    
    /**
     * Adds a new product to the stock of that stockHolder
     * The product quantity will be 0 by default
     * Quantity needs manual update!
     * 
     * @param stockHolder
     * @param product 
     */
    public void CreateStockItemForStockHolder(StockHolder stockHolder, Product product);
    
    /**
     * Gets a list of StockItems for the specified StockHolder
     * 
     * @param stockHolder
     * @return 
     */
    public List<StockItem> GetAllStockItemsForStockHolder(StockHolder stockHolder);
}
