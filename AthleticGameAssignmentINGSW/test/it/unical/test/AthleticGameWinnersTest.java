package it.unical.test;

import java.time.Instant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameWinnersTest {
	private static AthleticGame game;

	@BeforeClass
	public static void init() {
		game = new AthleticGame(null);
	}
	
	@After
	public void testReset () {
		game.reset();
	}
	
	@Before
	public void testStart() {
		game.start();
		game.addArrival("ciao", Instant.now());
	}
	
	@Test
	public void testGetWinner1 () {
		Assert.assertNotEquals(0, game.getArrivals().size());
	}
	
	@Test
	public void testGetWinner2 () {
		game.addArrival("Fabio", Instant.EPOCH.plusMillis(40));
		game.addArrival("Matteo", Instant.EPOCH.plusMillis(100));
		Assert.assertEquals("Fabio", game.getWinner());
	}

}
