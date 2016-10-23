package javacourse.ocp.generics.legacy;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class GenericWithLegacy {
	
	public static void main(String args[]){
		
		List<Sale> sales = new ArrayList<>();
		
		Sale sales01 = new Sale(1,  10_000.50);
		Sale sales02 = new Sale(2, 525_000.75);
		Sale sales03 = new Sale(3, 782_500.00);
		
		sales.add(sales01);
		sales.add(sales02);
		sales.add(sales03);
		
		double total = LegacyClass.getTotalSales(sales);
		System.out.println(total);
		
	}
}

//@SuppressWarnings("rawtypes")
class LegacyClass {
	
	public static double getTotalSales(List sales){
		
		double total = 0.0;
		
		Iterator i = sales.iterator();
		while(i.hasNext()){
			Sale s = (Sale) i.next();
			total += s.getSales();
		}
		return total;
	}
}


class Sale {
	
	private int customerId;
	private double sales;
	
	public Sale(int customerId, double sales){
		
		this.customerId = customerId;
		this.sales = sales;
	}
	
	public double getSales(){
		return sales;
	}
}