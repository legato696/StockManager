/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Transformers;

import Data.Models.Abstract.AbsModel;
import Data.Models.Enums.UserAccessLevel;
import Data.Models.StockHolder;
import Data.Models.User;
import Infrastructure.Bootstrapper.Container;
import Services.StockHolderService;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Urban
 */
public class UserTransformer implements ITransformer
{
    private final Container _container;
    
    public UserTransformer(Container container)
    {
        _container = container;
    }

    @Override
    public User Transofrm(ResultSet result)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<AbsModel> TransformAll(ResultSet result)
    {
        ArrayList<AbsModel> userList = new ArrayList<>();
        
        try
        {
            while(result.next())
            {
                User newUser = new User();
                newUser.UserId = result.getInt(1);
                newUser.Username = result.getString(2);
                newUser.Password = result.getString(3);
                newUser.StockHolder = GetStockHolderForUser(result.getInt(4));
                newUser.AccessLevel = ResolveUserAccessLevel(result.getInt(5));
                userList.add(newUser);
            }
            
            return userList;
        }
        catch(Exception e)
        {
            
        }
        return null;    
    }

    private StockHolder GetStockHolderForUser(int stockHolderId)
    {
        StockHolderService shService = _container.GetStockHolderService();
        return shService.GetStockHolderById(stockHolderId);
    }

    private UserAccessLevel ResolveUserAccessLevel(int accessLevelInt)
    {
        switch(accessLevelInt)
        {
            case 0:
                return UserAccessLevel.Guest;
            case 1:
                return UserAccessLevel.Normal;
            case 2:
                return UserAccessLevel.StockAdmin;
            case 3:
                return UserAccessLevel.SystemAdmin;
            default:
                return  UserAccessLevel.Guest;
        }
    }
}
