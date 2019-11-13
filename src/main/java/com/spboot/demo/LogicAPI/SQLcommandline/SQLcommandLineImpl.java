package com.spboot.demo.LogicAPI.SQLcommandline;

public class SQLcommandLineImpl implements SQLcommandline {

    private final String tableName;

    public SQLcommandLineImpl(String tn) {
        tableName = tn;
    }

    @Override
    public String SelectAll(String valueParam, String value) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(tableName);
        sb.append(" WHERE ");
        sb.append(valueParam);
        sb.append(" ='");
        sb.append(value);
        sb.append("'");
        System.err.println(sb.toString());
        return sb.toString();
    }


    @Override
    public String Select(String[] valueList, String[] value) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(tableName);
        sb.append(" WHERE ");
        for(int i=0;i<value.length;i++){
            if(value[i] == null || value[i] == "null" || valueList[i] == null || valueList[i] == "null"){
                continue;
            }
            sb.append(valueList[i]);
            sb.append(" = '");
            sb.append(value[i] + "'");
            sb.append(" AND ");
        }
        sb.append("1");
        System.err.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String Insert(String[] valueList, String[] value) {
        StringBuilder sb = new StringBuilder("INSERT INTO " + tableName + " (");
        for (int i = 0; i < valueList.length; i++) {
            String o = valueList[i];
            sb.append(o);
            if (i != valueList.length - 1) {
                sb.append(",");
            } else {
                sb.append(") VALUES (");
            }
        }
        for (int i = 0; i < value.length; i++) {
            String o = value[i];
            if(o == null){
                o = "null";
            }
            sb.append("'");
            sb.append(o);
            sb.append("'");
            if (i != value.length - 1) {
                sb.append(",");
            } else {
                sb.append(")");
            }
        }
        return sb.toString();
    }

    @Override
    public String Update(String[] valueList, String[] value, String[] changeList, String[] changeValue) {
        StringBuilder sb = new StringBuilder("UPDATE " + tableName + " ");
        sb.append(" SET ");
        for (int i = 0; i < changeList.length; i++) {
            sb.append(changeList[i] + "='");
            sb.append(changeValue[i] + "'");
            if (i != changeList.length - 1) {
                sb.append(",");
            }
        }
        sb.append(" WHERE ");
        for (int i = 0; i < valueList.length; i++) {
            sb.append(valueList[i] + "='");
            sb.append(value[i] + "'");
            if (i != changeList.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
