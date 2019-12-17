package com.spboot.demo.House_service;

import com.spboot.demo.Const.const_oct;
import com.spboot.demo.LogicAPI.SQLcommandline.SQLcommandLineImpl;
import com.spboot.demo.LogicAPI.SQLcommandline.SQLcommandline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocationAssistant {
    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://"+const_oct.mysqlIP+":3306/house_users";
    static final private String adminName = const_oct.admin;
    static final private String passWord = const_oct.password;

    static private Connection conn;
    static private Statement stat;
    static private SQLcommandline SQLline_user_table = new SQLcommandLineImpl("house_location_table");

    public LocationAssistant() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, adminName, passWord);
            stat = conn.createStatement();
            System.out.println("connect house_location_table success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param house_id
     * @param Loc position
     * @return true for success , false  for fail.
     */
    public boolean addHouse(Integer house_id, Map<String , String> Loc){
        String exl = SQLline_user_table.Insert(new String[]{"house_id","province","city","county","Road"},
                                  new String[]{house_id.toString(),Loc.get("province"),Loc.get("city"),
                                  Loc.get("county"),Loc.get("Road")});
        try {
            stat.executeUpdate(exl);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param Loc position
     * @return a list of which locate in there.
     */
    public List<Integer> searchFieldId(Map<String , String> Loc){
        List<Integer> res = new ArrayList<>();
        List<String> val = new ArrayList<>();
        List<String> va = new ArrayList<>();
        for(String vl:Loc.keySet()){
            val.add(vl);
        }
        for(String vl:Loc.values()){
            va.add(vl);
        }
        String[] valueList = new String[val.size()];
        String[] value = new String[va.size()];
        val.toArray(valueList);
        va.toArray(value);
        String sql = SQLline_user_table.Select(valueList , value);
        try {
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                res.add(rs.getInt("house_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
