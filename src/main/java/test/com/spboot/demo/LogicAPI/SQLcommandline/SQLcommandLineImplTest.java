package test.com.spboot.demo.LogicAPI.SQLcommandline; 

import com.spboot.demo.House_service.LocationAssistant;
import com.spboot.demo.LogicAPI.SQLcommandline.SQLcommandLineImpl;
import com.spboot.demo.LogicAPI.SQLcommandline.SQLcommandline;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SQLcommandLineImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>11 13, 2019</pre>
* @version 1.0 
*/ 
public class SQLcommandLineImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 
static SQLcommandline SQ = new SQLcommandLineImpl("house_location_table");
/** 
* 
* Method: SelectAll(String valueParam, String value) 
* 
*/ 
@Test
public void testSelectAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: Select(String[] valueList, String[] value) 
* 
*/ 
@Test
public void testSelect() throws Exception { 
    SQ.Select(new String[]{"province"},
            new String[]{"qqqq"});

} 

/** 
* 
* Method: Insert(String[] valueList, String[] value) 
* 
*/ 
@Test
public void testInsert() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: Update(String[] valueList, String[] value, String[] changeList, String[] changeValue) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 


} 
