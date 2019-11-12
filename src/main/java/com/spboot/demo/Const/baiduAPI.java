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

    /**
     *  to get the Address ' s location (lat , lng)
     * @param Address
     * @return a String of url to find it.
     */
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

    /**
     * get the image around the (lat , lng).
     * @param lat
     * @param lng
     * @return a image around this Location.
     */
    public String getImgByLocation(Double lng , Double lat){
        return "<img style=\"margin:20px\" width=\"280\" height=\"140\" "
                +"src=\"http://api.map.baidu.com/staticimage/v2?"
                +"ak="+AK
                +"&center=" + lng.toString() + "," + lat.toString()
                +"&markers=" + lng.toString() + "," + lat.toString()
                +"&width=280&height=140&zoom=13\"/>";
    }
}
