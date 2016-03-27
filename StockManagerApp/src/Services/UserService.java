/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.DatabaseContext.DatabaseContext;
import Data.Helpers.IQueryBuilder;
import Data.Helpers.QueryBuilder;
import Data.Models.Abstract.AbsModel;
import Data.Models.User;
import Services.Interfaces.IUserService;
import java.util.List;

/**
 *
 * @author Urban
 */
public class UserService implements IUserService
{
    private final IQueryBuilder _queryBuilder;
    private final DatabaseContext _dbContext;
    
    public UserService(IQueryBuilder queryBuilder, DatabaseContext dbContext)
    {
        _queryBuilder = queryBuilder;
        _dbContext = dbContext;
    }

    @Override
    public User GetUserByUsername(String username)
    {
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(User.TABLE_NAME);
        _queryBuilder.Where("Username = " + username);
        List<AbsModel> users = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());

        if(!users.isEmpty())
        {
            return (User)users.get(0);
        }
        
        return null;
    }

    @Override
    public void InsertUser(User user)
    {
        _queryBuilder.Insert("UserId, Username, Password, StockHolderId, AccessLevel", 
                (GetLastUserId() + 1) + ", " + user.Username + ", " + user.Password + ", " + user.StockHolder.StockHolderId + ", " + user.AccessLevel);
        _queryBuilder.SetTable(User.TABLE_NAME);
        _dbContext.ExecuteInsertQuery(_queryBuilder.GetQuery());
    }
    
    private int GetLastUserId()
    {
        _queryBuilder.Select("*");
        _queryBuilder.SetTable(User.TABLE_NAME);
        List<AbsModel> result = _dbContext.ExecuteSelectQuery(_queryBuilder.GetQuery());
        User lastUser = (User)result.get(result.size()-1);
        return lastUser.UserId;
    }
}
