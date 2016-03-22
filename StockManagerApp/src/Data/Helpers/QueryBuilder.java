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
    private String Query;
    private String Select;
    
    @Override
    public String GetQuery()
    {
        BuildQuery();
        return Query;
    }

    private void BuildQuery()
    {
        
    }
    
    @Override
    public void Select(String selections)
    {
    }

    @Override
    public void From(String tableName)
    {
    }

    @Override
    public void Where(String where)
    {
    }

    @Override
    public void OrderBy(String orderCriteria)
    {
    }

    @Override
    public void Join(String tableName)
    {
    }
    
}
