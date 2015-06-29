package org.kosta.madfortaste.market.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.exception.ExceedsMaximumException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestMarketService {
	
	@Autowired
	private MerketService merketService;
	
}
