package com.ciandt.challenge.test.template;

import java.math.BigDecimal;

import com.ciandt.challenge.vo.DeliveryRoute;
import com.ciandt.challenge.vo.DeliveryRouteCalculateRequest;
import com.ciandt.challenge.vo.DeliveryRouteOutput;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class Template implements TemplateLoader{
	public void load() {
		Fixture.of(DeliveryRoute.class).addTemplate("route-1", new Rule() {
			{
				add("id", 1L);
				add("origem", "A");
				add("destino", "B");
				add("distancia", BigDecimal.TEN);
			}
		});
		
		Fixture.of(DeliveryRoute.class).addTemplate("route-2", new Rule() {
			{
				add("id", 2L);
				add("origem", "B");
				add("destino", "D");
				add("distancia", new BigDecimal(15));
			}
		});
		Fixture.of(DeliveryRoute.class).addTemplate("route-3", new Rule() {
			{
				add("id", 3L);
				add("origem", "A");
				add("destino", "C");
				add("distancia", new BigDecimal(20));
			}
		});
		Fixture.of(DeliveryRoute.class).addTemplate("route-4", new Rule() {
			{
				add("id", 4L);
				add("origem", "C");
				add("destino", "D");
				add("distancia", new BigDecimal(30));
			}
		});
		Fixture.of(DeliveryRoute.class).addTemplate("route-5", new Rule() {
			{
				add("id", 5L);
				add("origem", "B");
				add("destino", "E");
				add("distancia", new BigDecimal(50));
			}
		});
		
		Fixture.of(DeliveryRoute.class).addTemplate("route-6", new Rule() {
			{
				add("id", 6L);
				add("origem", "D");
				add("destino", "E");
				add("distancia", new BigDecimal(30));
			}
		});
		
		Fixture.of(DeliveryRouteOutput.class).addTemplate("output-1", new Rule() {
			{
				add("rota", "A B D");
				add("custo", new BigDecimal("6.25"));
			}
		});
		
		Fixture.of(DeliveryRouteCalculateRequest.class).addTemplate("calculete-request-1", new Rule() {
			{
				add("origem", "A");
				add("destino", "D");
				add("autonomia", new BigDecimal(10));
				add("valorDoLitro", new BigDecimal("2.50"));
			}
		});
		
		
	}
}
