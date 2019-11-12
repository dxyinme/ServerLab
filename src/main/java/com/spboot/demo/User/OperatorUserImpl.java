package com.spboot.demo.User;

import com.spboot.demo.LogicAPI.SQLcommandline.SQLcommandLineImpl;
import com.spboot.demo.LogicAPI.SQLcommandline.SQLcommandline;

import java.sql.*;

public class OperatorUserImpl implements OperatorUser {

    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost:3306/house_users";
    static final private String adminName = "root";
    static final private String passWord = "13705034784";

    static private Connection conn;
    static private Statement stat;
    static private SQLcommandline SQLline_user_table = new SQLcommandLineImpl("user_table");

    public OperatorUserImpl() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, adminName, passWord);
            stat = conn.createStatement();
            System.out.println("connect user_table success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean Login(String Name) {
        //do not used .
        return false;
    }

    @Override
    public boolean SignUp(String Name) {
        String sql_confirm = SQLline_user_table.SelectAll("name", Name);
        String sql_add = SQLline_user_table.Insert(new String[]{"name", "message"}, new String[]{Name, "zero"});
        System.out.println(sql_add);
        ResultSet rs;
        try {
            rs = stat.executeQuery(sql_confirm);
            String _na = null;

            while (rs.next()) {
                _na = rs.getString("name");
                break;
            }
            if (_na == null || !_na.equals(Name)) {
                stat.executeUpdate(sql_add);
                return true;
            } else {
                System.out.println(Name + " has been used!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public User getUser(String Name) {
        ResultSet rs;
            String sql_Select = SQLline_user_table.SelectAll("name", Name);
            try {
                Integer id = 0;
                String username = null, message = null;
                rs = stat.executeQuery(sql_Select);
                if (rs.next()) {
                    id = rs.getInt("id");
                    username = rs.getString("name");
                    message = rs.getString("message");
                }
                System.out.println("success : " + id.toString() + " " + username + " " + message);
                User ret = new UserImpl(username, message,id);
                return ret;
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean ChangeInfo(User user) {
        String Name = user.getName();
        String sql_update = SQLline_user_table.Update(
                new String[]{"name"},
                new String[]{user.getName()},
                new String[]{"message"},
                new String[]{user.getMessage()}
        );
        System.out.println(sql_update);
        try {

            int cut = stat.executeUpdate(sql_update);
            return cut != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Integer askId(String Name) {
        User u = getUser(Name);
        if(u == null){
            return null;
        }
        else{
            return u.getId();
        }
    }
}
