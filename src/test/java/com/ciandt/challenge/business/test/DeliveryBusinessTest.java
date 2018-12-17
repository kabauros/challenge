package com.ciandt.challenge.business.test;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import com.ciandt.challenge.business.DeliveryBusiness;
import com.ciandt.challenge.repository.RoutesJdbcRepository;
import com.ciandt.challenge.vo.DeliveryRoute;
import com.ciandt.challenge.vo.DeliveryRouteCalculateRequest;
import com.ciandt.challenge.vo.DeliveryRouteOutput;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static br.com.six2six.fixturefactory.Fixture.from;

@RunWith(MockitoJUnitRunner.class)
public class DeliveryBusinessTest {
	
	@InjectMocks
	private DeliveryBusiness business;
	
	@Mock
	private RoutesJdbcRepository repository;
	
	public @Rule ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void setUpClass() {
		loadTemplates("com.ciandt.challenge.test.template");
	}
	
	@Test
	public void testInsertRoute() {
		DeliveryRoute route = from(DeliveryRoute.class).gimme("route-1"); 
				
		when(repository.insert(route)).thenReturn(1);
		business.insertDeliveryRoutes(route);
		assertTrue(true);
	}
	
	
	@Test
	public void testProcess() {
		
		List<DeliveryRoute> origem = from(DeliveryRoute.class).gimme(2, "route-1", "route-3"); 
		List<DeliveryRoute> destino = from(DeliveryRoute.class).gimme(2, "route-2", "route-4");
		DeliveryRouteCalculateRequest routeRequest = from(DeliveryRouteCalculateRequest.class).gimme("calculete-request-1"); 
		DeliveryRouteOutput output = from(DeliveryRouteOutput.class).gimme("output-1"); 
		
		when(repository.findByOrigem("A")).thenReturn(origem);
		when(repository.findByDestino("D")).thenReturn(destino);
						
		DeliveryRouteOutput retorno = business.process(routeRequest);
		assertEquals(output.getRota(), retorno.getRota());
		assertEquals(output.getCusto(), retorno.getCusto());
	}

}
