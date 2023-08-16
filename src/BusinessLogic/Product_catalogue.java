package BusinessLogic;

public class Product_catalogue {
 Product products[] = new Product[100];

public  Product retrieveproduct(String name) {
	for(int i=0;i<100;i++) {
	String retname=	products[i].retrieveproducts();
	    if(retname.equals(name)) {
	    	return products[i];
	    }
	}
	return null;
}
}
