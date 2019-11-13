package com.spboot.demo.House_service;

import com.spboot.demo.Const.const_oct;
import com.spboot.demo.LogicAPI.SQLcommandline.SQLcommandLineImpl;
import com.spboot.demo.LogicAPI.SQLcommandline.SQLcommandline;
import com.spboot.demo.House.House;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Map;

public class HouseServiceImp implements HouseService {

    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost:3306/house_users";
    static final private String adminName = const_oct.admin;
    static final private String passWord = const_oct.password;
    private SQLcommandline sqlcom = new SQLcommandLineImpl("house_table");
    private Connection connection;
    private Statement statement;

    private LocationAssistant LA = new LocationAssistant();

    public HouseServiceImp() {
        connectJdbc();
    }

    public void connectJdbc() {
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("connect to house_table");
            connection = DriverManager.getConnection(DB_URL, adminName, passWord);
            System.out.println("success connect to house_table");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeJdbc() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create House by ResultSet while search.
     *
     * @param rs ResultSet
     * @return a ArrayList consist of House
     * @throws SQLException sqlException
     */
    private List<House> getHouses(ResultSet rs) throws SQLException {
        rs.beforeFirst();           //move the item to the first House.
        List<House> houses = new ArrayList<House>();
        while (rs.next()) {
            Integer autoId = rs.getInt("house_id");
            Integer state = rs.getInt("house_state");
            String location = rs.getString("house_location");
            Integer area = rs.getInt("house_area");
            Integer price = rs.getInt("house_price");
            Integer type = rs.getInt("house_type");
            Integer floor = rs.getInt("house_floor");
            Integer buildTime = rs.getInt("build_time");
            Integer timeLimit = rs.getInt("time_limit");
            Integer userId = rs.getInt("user_id");
            houses.add(new House(autoId, state, location, area, price, type, floor, buildTime, timeLimit, userId));
        }
        return houses;
    }

    /**
     * correct the min and max
     *
     * @param min the minimum
     * @param max the maximum
     */
    private void correct(Integer min, Integer max) {
        if (min > max) {
            Integer altering = min;
            min = max;
            max = min;
        }
    }

    @Override
    public Integer addHouse(String location,
                            Integer area,
                            Integer price,
                            Integer type,
                            Integer floor,
                            Integer buildTime,
                            Integer timeLimit) throws Exception {
        String sqlInsert = sqlcom.Insert(new String[]{"house_location","house_area","house_price","house_type","house_floor","build_time","time_limit","house_state"},
                new String[]{location,area.toString(),
                        price.toString(),type.toString(),
                        floor.toString(),buildTime.toString(), timeLimit.toString(),"1"});
        System.out.println(sqlInsert);
        statement.executeUpdate(sqlInsert);
        String sqlQuery = "SELECT house_id FROM house_table ORDER BY house_id DESC LIMIT 1";
        ResultSet rs = statement.executeQuery(sqlQuery);
        rs.next();
        return rs.getInt("house_id");
    }

    @Override
    public Integer deleteHouse(Integer autoId) throws Exception {
        String sqlQuery = "SELECT house_state FROM house_table WHERE house_id=" + autoId;
        ResultSet rs = statement.executeQuery(sqlQuery);
        rs.next();
        int state = rs.getInt("state");

        String sqlDelete = "UPDATE house_table SET house_state=" + 0 +
                "WHERE house_id=" + autoId;
        statement.executeUpdate(sqlDelete);
        return state;
    }

    @Override
    public Integer restoreHouse(Integer autoId) throws Exception {
        String sqlQuery = "SELECT house_state FROM house_table WHERE house_id=" + autoId;
        ResultSet rs = statement.executeQuery(sqlQuery);
        rs.next();
        int state = rs.getInt("state");

        String sqlRestore = "UPDATE house_table SET house_state=" + 1 +
                "WHERE house_id=" + autoId;
        statement.executeUpdate(sqlRestore);
        return state;
    }

    @Override
    public House searchHouseByAutoId(Integer autoId) {
        try {
            String sqlQuery = "SELECT * FROM house_table WHERE house_id=" + autoId;
            ResultSet rs = statement.executeQuery(sqlQuery);
            if (rs.next()) {
                List<House> list = getHouses(rs);
                if (list.size() == 1) {
                    return list.get(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<House> searchHouseByLocation(String location) {
        List<House> list = new ArrayList<House>();
        try {
            String sqlQuery = "SELECT * FROM house_table WHERE house_location=" + location;
            ResultSet rs = statement.executeQuery(sqlQuery);
            if (rs.next()) {
                list =  getHouses(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<House> searchHouseByType(Integer type) {
        List<House> list = new ArrayList<House>();
        try {
            String sqlQuery = "SELECT * FROM house_table WHERE house_type=" + type.toString();
            ResultSet rs = statement.executeQuery(sqlQuery);
            if (rs.next()) {
                list = getHouses(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<House> searchHouseByArea(Integer minArea, Integer maxArea) {
        List<House> list = new ArrayList<House>();
        correct(minArea, maxArea);
        try {
            String sqlQuery = "SELECT * FROM house_table WHERE house_area <= " + maxArea + " AND house_area >= " + minArea;
            ResultSet rs = statement.executeQuery(sqlQuery);
            if (rs.next()) {
                list = getHouses(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<House> searchHouseByPrice(Integer minPrice, Integer maxPrice) {
        List<House> list = new ArrayList<House>();
        correct(minPrice, maxPrice);
        try {
            String sqlQuery = "SELECT * FROM house_table WHERE house_price <= " + maxPrice + " AND house_price >= " + minPrice;
            ResultSet rs = statement.executeQuery(sqlQuery);
            if (rs.next()) {
                list = getHouses(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<House> searchHouseByBuildTime(Integer minTime, Integer maxTime) {
        List<House> list = new ArrayList<House>();
        correct(minTime, maxTime);
        try {
            String sqlQuery = "SELECT * FROM house_table WHERE build_time <= " + maxTime + " AND build_time >= " + minTime;
            ResultSet rs = statement.executeQuery(sqlQuery);
            if (rs.next()) {
                list = getHouses(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<House> searchHouseByFloor(Integer minFloor, Integer maxFloor) {
        List<House> list = new ArrayList<House>();
        correct(minFloor, maxFloor);
        try {
            String sqlQuery = "SELECT * FROM house_table WHERE house_floor <= " + maxFloor + " AND house_floor >= " + minFloor;
            ResultSet rs = statement.executeQuery(sqlQuery);
            if (rs.next()) {
                list = getHouses(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<House> searchHouses() {
        List<House> list = new ArrayList<House>();
        try {
            String sqlQuery = "SELECT * FROM house_table WHERE house_state = "+"1";
            ResultSet rs = statement.executeQuery(sqlQuery);
            if (rs.next()) {
                list = getHouses(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<House> searchSoldHouses() {
        List<House> list = new ArrayList<House>();
        try {
            String sqlQuery = "SELECT * FROM house_table WHERE house_state = "+"0";
            ResultSet rs = statement.executeQuery(sqlQuery);
            if (rs.next()) {
                list = getHouses(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<House> searchFieldHouses(Map<String, String> Loc) {
        List<House> list = new ArrayList<>();
        List<Integer> list_id = LA.searchFieldId(Loc);
        for(int i=0;i<list_id.size();i++){
            list.add(searchHouseByAutoId(list_id.get(i)));
        }
        return list;
    }
}