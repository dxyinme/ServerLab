package com.spboot.demo.House_service;

import com.spboot.demo.House.House;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface HouseService {

    /**
     * add a new house.
     *
     * @param location the location e.g."南岗区……"
     * @param area the area , square meters
     * @param price the price  , yuan
     * @param type  the type
     * @param floor the floor
     * @param buildTime the build time , year
     * @param timeLimit the time limit , year
     *
     * @return autoId of house.
     * @throws Exception SQLException
     */
    public Integer addHouse(@WebParam(name = "location") String location,
                          @WebParam(name = "area") Integer area,
                          @WebParam(name = "price") Integer price,
                          @WebParam(name = "type") Integer type,
                          @WebParam(name = "floor") Integer floor,
                          @WebParam(name = "buildTime") Integer buildTime,
                          @WebParam(name = "timeLimit") Integer timeLimit
    ) throws Exception;


    /**
     * change the state of House to 0.
     *
     * @param autoId the auto id of house.
     * @return the old state if the house exist.
     * @throws Exception house dose not exist.
     */
    public Integer deleteHouse(@WebParam(name = "autoId") Integer autoId) throws Exception;


    /**
     * change the state of House to 1.
     *
     * @param autoId the auto id of house.
     * @return the old state if the house exists.
     * @throws Exception house dose not exist.
     */
    public Integer restoreHouse(@WebParam(name = "autoId") Integer autoId) throws Exception;

    /**
     * search house by auto id.
     *
     * @param autoId auto id
     * @return House if exist , null if not exist.
     */
    public House searchHouseByAutoId(@WebParam(name = "autoId") Integer autoId);

    /**
     * search house by location.
     * @param location the location
     * @return all existed houses whose house-location is param-location
     */
    public List<House> searchHouseByLocation(@WebParam(name = "location") String location);

    /**
     * search houses by type.
     * @param type Type of house
     * @return all existed houses whose house-type is param-type
     */
    public List<House> searchHouseByType(@WebParam(name = "type") Integer type);



    /**
     * search houses by area.
     * @param minArea min area , nonnegative
     * @param maxArea max area , no smaller than minArea.
     * @return all existed houses whose area is between minArea and maxArea.
     */
    public List<House> searchHouseByArea(@WebParam(name = "minArea") Integer minArea, @WebParam(name = "maxArea") Integer maxArea);

    /**
     * search houses by price.
     * @param minPrice min price , nonnegative
     * @param maxPrice max price , no smaller than minPrice
     * @return all existed houses whose price is between minPrice and maxPrice.
     */
    public List<House> searchHouseByPrice(@WebParam(name = "minPrice") Integer minPrice, @WebParam(name = "maxPrice") Integer maxPrice);

    /**
     * search houses by build time.
     * @param minTime min time , positive
     * @param maxTime max time , no smaller than maxTime
     * @return all existed houses whose build-time is between minTime and maxTime.
     */
    public List<House> searchHouseByBuildTime(@WebParam(name = "minTime") Integer minTime, @WebParam(name = "maxTime") Integer maxTime);

    /**
     * serach houses by floor number.
     * @param minFloor min floor
     * @param maxFloor max floor , no smaller than minFloor.
     * @return all existed houses whose house-floor is between minFloor and maxFloor.
     */
    public List<House> searchHouseByFloor(@WebParam(name = "minFloor") Integer minFloor, @WebParam(name = "maxFloor") Integer maxFloor);

    /**
     * search all houses state is not 0.
     * @return all existed houses(state is 1).
     */
    public List<House> searchHouses();

    /**
     * search all houses state is 0.
     * @return all houses state is 0(deleted or sold)
     */
    public List<House> searchSoldHouses();
}
