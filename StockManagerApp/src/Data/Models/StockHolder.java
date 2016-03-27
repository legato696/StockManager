/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Models;

import Data.Models.Abstract.AbsModel;
import Data.Models.Enums.StockHolderType;

/**
 *
 * @author Urban
 */
public class StockHolder extends AbsModel
{
    public static final String TABLE_NAME = "dbo.StockHolders";
    
    public int StockHolderId;
    public String Name;
}
