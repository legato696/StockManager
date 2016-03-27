/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Transformers;

import Data.Models.Abstract.AbsModel;
import Data.Models.StockHolder;
import java.sql.ResultSet;
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
        try
        {
            while(result.next())
            {
            }
        }
        catch(Exception e)
        {
            
        }
        return null;    
    }
}
