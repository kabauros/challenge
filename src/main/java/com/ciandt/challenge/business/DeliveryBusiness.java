package com.ciandt.challenge.business;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.challenge.repository.RoutesJdbcRepository;
import com.ciandt.challenge.vo.DeliveryRoute;
import com.ciandt.challenge.vo.DeliveryRouteCalculateRequest;
import com.ciandt.challenge.vo.DeliveryRouteOutput;

@Component
public class DeliveryBusiness {
	
	@Autowired
	private RoutesJdbcRepository repository;

	public DeliveryRouteOutput process(DeliveryRouteCalculateRequest routeRequest){

		List<DeliveryRoute> origem = repository.findByOrigem(routeRequest.getOrigem());
		List<DeliveryRoute> destino = repository.findByDestino(routeRequest.getDestino());
		
		BigDecimal distancia = new BigDecimal(Float.MAX_VALUE);
		StringBuffer outputRoute = new StringBuffer();
		
		for (DeliveryRoute or : origem) {
			
			for (DeliveryRoute ds : destino) {
				
				if(or.getDestino().equals(ds.getOrigem())) {
					
					if ((or.getDistancia().add(ds.getDistancia())).compareTo(distancia) < 0) {
						distancia = or.getDistancia().add(ds.getDistancia());
						outputRoute.append(or.getOrigem() + " ");
						outputRoute.append(or.getDestino() + " ");
						outputRoute.append(ds.getDestino());
					}
				}
			}
		}
		
		BigDecimal custo = (distancia.divide(routeRequest.getAutonomia())).multiply(routeRequest.getValorDoLitro()).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		DeliveryRouteOutput output  = new DeliveryRouteOutput();
		output.setRota(outputRoute.toString());
		output.setCusto(custo);
		
		return output;
	}
	
	public int insertDeliveryRoutes(DeliveryRoute route) {
		return repository.insert(route);
	}

}
