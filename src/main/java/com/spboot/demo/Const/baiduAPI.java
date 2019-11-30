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

    /**
     *
     * <h3>HINT<h3/>
     * location=lat,lng
     *
     * @param Type 想要查的类型
     * @param lng
     * @param lat
     * @param Radius radius (meter)
     * @return
     */
    public String getCircleSearch(String Type,Double lng ,Double lat , Integer Radius){
        return "http://api.map.baidu.com/place/v2/search?query="+
                Type +
                "&location="+
                lat.toString() + "," + lng.toString()+
                "&radius="+Radius.toString()+"&output=json&ak=" + AK;
    }

    /**
     *
     * center=lng,lat
     * markers=lng,lat
     *
     * get the image around the (lat , lng).
     * @param lng
     * @param lat
     * @return a image around this Location.
     */
    public String getImgByLocation(Double lng , Double lat){
        return "http://api.map.baidu.com/staticimage/v2?"
                +"ak="+AK
                +"&center=" + lng.toString() + "," + lat.toString()
                +"&markers=" + lng.toString() + "," + lat.toString()
                +"&width=200&height=200&zoom=12";
    }
}
