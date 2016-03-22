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
public interface IQueryBuilder
{
    String GetQuery();
    void Select(String selections);
    void From(String tableName);
    void Where(String where);
    void OrderBy(String orderCriteria);
    void Join(String tableName);
}
