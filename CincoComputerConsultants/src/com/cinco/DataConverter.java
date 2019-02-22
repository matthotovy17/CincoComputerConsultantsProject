/**
 * Author: Chloe Galinsky, Matt Hotovy
 * Date: 2/8/2019
 * 
 * This program reads in 3 files each containing different information regarding
 * the Cinco Computer Consultants and exports the data to a JSON format
 */

package com.cinco;

import java.util.Map;

public class DataConverter {

	Map<String, Person> personMap = FileReader.getPersonsData("data/Persons.dat");
	Map<String, Customer> customerMap = FileReader.getCustomersData("data/Customers.dat", personMap);
	Map<String, Product> productMap = FileReader.getProductsData("data/Products.dat", personMap);

}
