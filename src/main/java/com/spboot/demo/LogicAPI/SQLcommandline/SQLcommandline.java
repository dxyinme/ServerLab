package com.spboot.demo.LogicAPI.SQLcommandline;


public interface SQLcommandline {
    /**
     *  find all attributes whose 'valueparam' is 'value' .
     *
     * @param valueParam the value contain.
     * @param value the value correspond to the value list .
     * @return
     */
    public String SelectAll( String valueParam, String value);

    /**
     *
     * @param valueList the value contain.
     * @param value the value correspond to the value list .
     * @return the string of sql command line for insert value into table name.
     */
    public String Insert( String[] valueList, String[] value);

    /**
     * delete
     * @param valueList the value contain.
     * @param value the value correspond to the value list .
     * @param changeList the List which want to change.
     * @param changeValue the value correspond to the changeList list.
     * @return the string of sql command line for Update value into table name.
     */
    public String Update(String[] valueList, String[] value,String[] changeList , String[] changeValue);
}
