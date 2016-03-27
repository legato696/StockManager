/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Helpers;

/**
 *
 * @author Urban
 */
public class QueryBuilder implements IQueryBuilder
{
    private QueryType queryType;
    
    private String Query;
    
    private String TableName;
    private String Selection;
    private String WhereCriteria;
    private String Joins;
    private String OrderCriteria;
    
    private String Data;
    private String ColumnsAffected;
    
    @Override
    public String GetQuery()
    {
        BuildQuery();
        String returnedQuery = Query;
        ResetOldQuery();
        return returnedQuery;
    }

    private void BuildQuery()
    {
        if(TableName != null)
        {
            switch(queryType)
            {
                case Select:
                    BuildSelectQuery();
                    break;
                case Insert:
                    Query = "INSERT INTO " + TableName + "(" + ColumnsAffected + ")"+ " VALUES (" + Data + ")";
                    break;
                case Update:
                    BuildUpdateQuery();
                    break;
                case Delete:
                    BuildDeleteQuery();
                    break;
            }
        }
    }
    
    @Override
    public void Select(String selections)
    {
        queryType = QueryType.Select;
        Selection = selections;
    }

    @Override
    public void Where(String where)
    {
        WhereCriteria = where;
    }

    @Override
    public void OrderBy(String orderCriteria)
    {
        OrderCriteria = orderCriteria;
    }

    @Override
    public void Join(String tableName, String on, String abreviation)
    {
        String newJoin = "INNER JOIN " + tableName + abreviation + " ON " + on;
        if(Joins != null)
        {
            Joins = Joins + " " + newJoin;
        } else
        {
            Joins = newJoin;
        }
    }

    @Override
    public void SetTable(String tableName)
    {
        TableName = tableName;
    }

    @Override
    public void Insert(String columnsAffected, String insertData)
    {
        queryType = QueryType.Insert;
        ColumnsAffected = columnsAffected;
        Data = insertData;
    }

    @Override
    public void Update(String columnToUpdate, String updateData)
    {
        String updateQuery = columnToUpdate + "='" +updateData + "'";
        
        if(queryType != QueryType.Update)
        {
            queryType = QueryType.Update;
    
            Data = columnToUpdate + updateQuery;
        } else 
        {
            Data = Data + ", " + updateQuery;
        }
    }

    public void Delete()
    {
        queryType = QueryType.Delete;
    }
    
    private void BuildSelectQuery()
    {
        Query = "SELECT " + Selection +
                " FROM " + TableName;
        
        if(Joins != null)
        {
            Query = Query + Joins;
        }
        
        if(WhereCriteria != null)
        {
            Query = Query + " WHERE " + WhereCriteria;
        }
        
        if(OrderCriteria != null)
        {
            Query = Query + " ORDER BY " + OrderCriteria;
        }
    }

    private void BuildUpdateQuery()
    {
        Query = "UPDATE " + TableName;
        if(Data != null && WhereCriteria != null)
        {
            Query = Query + " SET " + Data + " WHERE " + WhereCriteria;
        }
    }

    private void BuildDeleteQuery()
    {
        Query = "DELETE FROM " + TableName +" WHERE " + WhereCriteria;
    }

    private void ResetOldQuery()
    {
        Query = null;
    }
    
}
