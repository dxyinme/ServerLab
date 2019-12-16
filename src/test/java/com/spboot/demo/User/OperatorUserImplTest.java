package com.spboot.demo.User;


import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* OperatorUserImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>10.28, 2019</pre>
* @version 1.0 
*/ 
public class OperatorUserImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: Login(String Name) 
* 
*/ 
@Test
public void testLogin() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: SignUp(String Name) 
* 
*/ 
@Test
public void testSignUp() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getUser(String Name) 
* 
*/ 
@Test
public void testGetUser() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: ChangeInfo(User user) 
* 
*/ 
@Test
public void testChangeInfo() throws Exception { 
//TODO: Test goes here...
    OperatorUser opU = new OperatorUserImpl();
    User user = new UserImpl("ra","rara",23333);
    opU.ChangeInfo(user);
} 


} 
