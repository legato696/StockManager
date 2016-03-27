/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Models;

import Data.Models.Abstract.AbsModel;

/**
 *
 * @author Urban
 */
public class StockItem extends AbsModel
{
    public static final String TABLE_NAME = "dbo.Stocks";
    
    public int StockItemId;
    public Product Product;
    public StockHolder StockHolder;
}
