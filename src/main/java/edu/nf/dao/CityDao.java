package edu.nf.dao;

import edu.nf.entity.City;
import edu.nf.entity.PageBean;
import edu.nf.utils.DBUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao {

    public List<City> listCity(PageBean page, String province){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select city_id,city_name,city_code,province from city_info where 1 = 1 ";
        StringBuffer sql2=new StringBuffer(sql);
        if(province!=null && !"".equals(province)){
            sql2.append("and province=? ");
        }
        sql2.append("limit ?,?");
        List<City> list=new ArrayList<City>();
        try{
            connection= DBUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql2.toString());
            if(province!=null && !"".equals(province)){
                preparedStatement.setString(1,province);
                preparedStatement.setInt(2,(page.getPageNum()-1)*page.getPageSize());
                preparedStatement.setInt(3,page.getPageSize());
            }else{
                preparedStatement.setInt(1,(page.getPageNum()-1)*page.getPageSize());
                preparedStatement.setInt(2,page.getPageSize());
            }
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                City city=new City();
                city.setId(resultSet.getInt(1));
                city.setCityName(resultSet.getString(2));
                city.setCityCode(resultSet.getString(3));
                city.setProvince(resultSet.getString(4));
                list.add(city);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("查询异常",e);
        }finally {
            DBUtils.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

    public Integer getPageCount( String province){
        Integer pagecount=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        StringBuffer sql=new StringBuffer("select count(*) count from city_info where 1 = 1 ");
        if(province!=null && !"".equals(province)){
            sql.append("and province=? ");
        }
        try {
            connection=DBUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql.toString());
            if(province!=null && !"".equals(province)){
                preparedStatement.setString(1,province);
            }
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                pagecount=resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection,preparedStatement,null);
        }

        return pagecount;
    }

}
