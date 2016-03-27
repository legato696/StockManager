/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Models;

import Data.Models.Abstract.AbsModel;
import Data.Models.Enums.UserAccessLevel;

/**
 *
 * @author Urban
 */
public class User extends AbsModel
{
    public final static String TABLE_NAME = "dbo.Users";
    public int UserId;
    public String Username;
    public String Password;
    public UserAccessLevel AccessLevel;
    public StockHolder StockHolder;
}
