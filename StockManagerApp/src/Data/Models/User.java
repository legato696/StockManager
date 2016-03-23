/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Models;

import Data.Models.Enums.UserAccessLevel;

/**
 *
 * @author Urban
 */
public class User
{
    public int UserId;
    public String Username;
    public String Password;
    public UserAccessLevel AccessLevel;
    public StockHolder StockHolder;
}
