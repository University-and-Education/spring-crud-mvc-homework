package com.spring.crud;

import com.spring.crud.controller.NOT_FOUND.CaviarControllerNotFoundTest;
import com.spring.crud.controller.OK.CaviarControllerOkTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CaviarControllerOkTest.class,
        CaviarControllerNotFoundTest.class
})
public class SpringCrudMvcHomeworkApplicationTests {
}