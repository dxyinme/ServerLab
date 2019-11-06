package com.spboot.demo.Const;

public class baiduAPI {
    static public String AK = "CVcBfNr11HgTiIEKz9gjkkVwtcOiDMAI";

    public baiduAPI(){

    }

    /**
     *
     * @param Address the address of this house .
     * @return string URL of this address .
     */
    public String getMapByAddress(String Address) {
        return  "http://api.map.baidu.com/geocoder?address=" +
                Address +
                "&output=html&src=webapp.baidu.openAPIdemo";
    }

    public String getlLocationByAddress(String Address){
        return "http://api.map.baidu.com/place/v2/search?query="+
                Address+
                "&region="+
                Address+
                "&output=json&ak="+AK;
    }

    public String getCircleSearch(String Type,Double lat ,Double lng , Integer Radius){
        return "http://api.map.baidu.com/place/v2/search?query="+
                Type +
                "&location="+
                lat.toString() + "," + lng.toString()+
                "&radius="+Radius.toString()+"&output=json&ak=" + AK;
    }

}
