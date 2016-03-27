/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Transformers;

import Data.Models.Abstract.AbsModel;
import Data.Models.Product;
import Data.Models.StockHolder;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Urban
 */
public class StockHolderTransformer implements ITransformer
{

    @Override
    public StockHolder Transofrm(ResultSet result)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<AbsModel> TransformAll(ResultSet result)
    {
         List<AbsModel> stockHolderList = new ArrayList<>();
        
        try
        {
            while(result.next())
            {
                StockHolder newStockHolder = new StockHolder();
                newStockHolder.StockHolderId = result.getInt(1);
                newStockHolder.Name = result.getString(2);
                
                stockHolderList.add(newStockHolder);
            }
        }
        catch(Exception e)
        {
            System.err.println("Exception: " + e.getMessage());
        }
        
        return stockHolderList;     
    }
}
