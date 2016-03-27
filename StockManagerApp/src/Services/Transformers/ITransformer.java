/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Transformers;

import Data.Models.Abstract.AbsModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Urban
 */
public interface ITransformer
{
    public AbsModel Transofrm(ResultSet result);
    public List<AbsModel> TransformAll(ResultSet result);
}
