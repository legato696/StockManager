/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import Data.Models.User;

/**
 *
 * @author Urban
 */
public interface IUserService
{

    /**
     * Will return the user object found with the username given
     * If the user does not exist it returns NULL
     * 
     * @param username
     * @return User
     */
    public User GetUserByUsername(String username);
    
    /**
     *  Inserts a User object in the appropriate tables
     *  If User is not SystemAdmin a StockHolder MUST exist 
     *  for the user to be created
     * 
     * @param user
     */
    public void InsertUser(User user);
}
