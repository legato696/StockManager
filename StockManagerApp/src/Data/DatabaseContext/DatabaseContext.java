/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.DatabaseContext;

import Data.Models.Abstract.AbsModel;
import Services.Transformers.ITransformer;
import com.microsoft.sqlserver.jdbc.*;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Urban
 */
public class DatabaseContext
{
    private final ConnectionStrings _strings;
    private final ITransformer _transformer;
    
    public DatabaseContext(ConnectionStrings strings, ITransformer transformer)
    {
        _strings = strings;
        _transformer = transformer;
    }
    
    public boolean ExecuteInsertQuery(String query)
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
            return true;
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
        
        return false;
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
    
    public List<AbsModel> ExecuteSelectQuery(String query)
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
            
            return _transformer.TransformAll(resultSet);
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
        
        return null;
    }
    
    public boolean ExecuteDeleteQuery(String query)
    {
        Connection connection = null;
        PreparedStatement prepared = null;
        try
        {
            // Establish the connection
            connection = DriverManager.getConnection(_strings.connection);
            connection.setAutoCommit(false);
            // Prepare statement to execute with query
            prepared = connection.prepareStatement(query);
            // Execute the prepared statement
            prepared.executeUpdate();
            // Commit the changes
            connection.commit();
            // Exit transaction mode
            connection.setAutoCommit(true);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // Close the connection after the data has been handled
            if(prepared != null) try { prepared.close();} catch(Exception e) {}
            if(connection != null) try {connection.close();} catch(Exception e) {}
        }
        
        return false;
    }
}
