package com.involves.desafio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.involves.desafio.util.DistanciaUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistanciaUtilTest {
	
	@Test
	public void haversine() {
		
		double distanciaEsperada = 1.6038325476354314;
		double distancia = DistanciaUtil.haversine(-27.6019111, -48.5957299, -27.6066129, -48.5803426);
		
		assertEquals(distanciaEsperada, distancia, 0.0);
	 }

	
	
}

