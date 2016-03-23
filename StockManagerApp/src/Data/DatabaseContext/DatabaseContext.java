/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.DatabaseContext;

import com.microsoft.sqlserver.jdbc.*;
import java.sql.*;

/**
 *
 * @author Urban
 */
public class DatabaseContext
{
    private final ConnectionStrings _strings;
    
    public DatabaseContext(ConnectionStrings strings)
    {
        _strings = strings;
    }
    
    public ResultSet ExecuteInsertQuery(String query)
    {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement prepared = null;
        
        try
        {
            // Establish the connection
            connection = DriverManager.getConnection(_strings.connection);
            // Prepare statement to execute with querry
            prepared = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            // Execute the prepared statement
            prepared.execute();
            // Retrieve the generated key from Insert
            resultSet = prepared.getGeneratedKeys();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // Close the connection after the data has been handled
            if(prepared != null) try { prepared.close();} catch(Exception e) {}
            if(resultSet != null) try {resultSet.close();} catch(Exception e) {}
            if(connection != null) try {connection.close();} catch(Exception e) {}
        }
        
        return resultSet;
    }
    
    public boolean ExecuteUpdateQuery(String query)
    {
        Connection connection = null;
        PreparedStatement prepared = null;
        
        try
        {
            // Establish the connection
            connection = DriverManager.getConnection(_strings.connection);
            // Enter transaction mode
            connection.setAutoCommit(false);
            // Prepare statement to execute with query
            prepared = connection.prepareStatement(query);
            // Execute the prepared statement
            prepared.executeUpdate();
            // Commit the changes
            connection.commit();
            // Exit transaction mode
            connection.setAutoCommit(true);
        }
        catch(Exception e)
        {
            return false;
        }
        finally
        {
            // Close the connection after the data has been handled
            if(prepared != null) try { prepared.close();} catch(Exception e) {}
            if(connection != null) try {connection.close();} catch(Exception e) {}
        }
        
        return true;
    }
    
    public ResultSet ExecuteSelectQuery(String query)
    {
        ResultSet resultSet = null;
        Connection connection = null;
        Statement statement = null;

        try
        {
            // Establish the connection
            connection = DriverManager.getConnection(_strings.connection);
            // Create the statement
            statement = connection.createStatement();
            // Execute the querry and save the results in the result set
            resultSet = statement.executeQuery(query);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // Close the connection after the data has been handled
            if(statement != null) try { statement.close();} catch(Exception e) {}
            if(resultSet != null) try {resultSet.close();} catch(Exception e) {}
            if(connection != null) try {connection.close();} catch(Exception e) {}
        }
        
        return resultSet;
    }
}
