/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import Data.Models.StockHolder;
import java.util.List;

/**
 *
 * @author Urban
 */
public interface IStockHolderService
{

    /**
     * Use this if you have id!
     * 
     * @param stockHolderId
     * @return
     */
    public StockHolder GetStockHolderById(int stockHolderId);

    /**
     * Use only if ID is not available!
     * 
     * @param stockHolderName
     * @return
     */
    public StockHolder GetStockHolderByName(String stockHolderName);

    /**
     *  Creates a new StockHolder, used by system administrators
     * 
     * @param stockHolder
     */
    public void CreateStockHolder(StockHolder stockHolder);

    /**
     *  Deletes stockHolder, only usable by system administrators
     * 
     * @param stockHolderId
     */
    public void DeleteStockHolderById(int stockHolderId);

    /**
     * Returns all stockHolders in the DB
     * 
     * @return List<StockHolder> 
     */
    public List<StockHolder> GetAllStockHolders();
}
