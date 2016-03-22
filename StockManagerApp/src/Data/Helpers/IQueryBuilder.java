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
    void SetTable(String tableName);
    void Where(String where);
    void OrderBy(String orderCriteria);
    void Join(String tableName, String on, String abreviation);
    void Insert(String columnsAffected, String insertData);
    void Update(String columnUpdate,String updateData);
}
