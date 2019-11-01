package com.spboot.demo.House;

public enum HouseType {
    NONE(0,0,0),
    SINGLE(1,1,1);

    private Integer numBedroom;
    private Integer numLivingroom;
    private Integer typeId;

    HouseType(){

    };

    HouseType(Integer numBedroom, Integer numLivingroom, Integer typeId) {
        this.numBedroom = numBedroom;
        this.numLivingroom = numLivingroom;
        this.typeId = typeId;
    }

    public Integer getNumBedroom() {
        return numBedroom;
    }

    public void setNumBedroom(Integer numBedroom) {
        this.numBedroom = numBedroom;
    }

    public Integer getNumLivingroom() {
        return numLivingroom;
    }

    public void setNumLivingroom(Integer numLivingroom) {
        this.numLivingroom = numLivingroom;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    static public HouseType getHouseType(Integer typeId){
        switch(typeId){
            case 1:return SINGLE;
            default: return NONE;
        }
    }

    @Override
    public String toString() {
        return "HouseType{" +
                "numBedroom=" + numBedroom +
                ", numLivingroom=" + numLivingroom +
                ", typeId=" + typeId +
                '}';
    }
}
