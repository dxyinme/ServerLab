package com.spboot.demo.Comment;

import com.spboot.demo.Const.const_oct;
import com.spboot.demo.LogicAPI.SQLcommandline.SQLcommandLineImpl;
import com.spboot.demo.LogicAPI.SQLcommandline.SQLcommandline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperatorCommentImpl implements OperatorComment{


    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost:3306/house_users";
    static final private String adminName = const_oct.admin;
    static final private String passWord = const_oct.password;

    static private Connection conn;
    static private Statement stat;
    static private SQLcommandline SQLline_user_table = new SQLcommandLineImpl("comment_table");

    public OperatorCommentImpl(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, adminName, passWord);
            stat = conn.createStatement();
            System.out.println("connect commment_table success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public int addComment(String Comment, Integer userId, Integer houseId) {
        String sql_add = SQLline_user_table.Insert(
                new String[] {"comment","user_id","house_id"},
                new String[] {Comment , userId.toString() , houseId.toString()}
        );
        System.err.println(sql_add);
        try {
            stat.executeUpdate(sql_add);
            return 1;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<CommentImpl> askAllComment(Integer houseId) {
        String sql_ask = SQLline_user_table.SelectAll(
                "house_id",
                houseId.toString()
        );
        List<CommentImpl> ret = new ArrayList<>();
        try{
            ResultSet rs;
            rs = stat.executeQuery(sql_ask);
            while(rs.next()){
                ret.add(new CommentImpl(rs.getString("comment")
                        , rs.getInt("user_id")
                        , rs.getInt("house_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*
        for(CommentImpl c : ret){
            System.out.println(c.getUserId());
        }
        */
        return ret;
    }
}
