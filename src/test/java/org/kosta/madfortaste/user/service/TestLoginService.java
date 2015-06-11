package org.kosta.madfortaste.user.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestLoginService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LoginService loginService;
	
	@Before
	public void setUp() {
		assertNotNull(loginService);
	}

}
