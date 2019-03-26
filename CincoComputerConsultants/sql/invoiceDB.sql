# get rid of this before we turn in the assignment;
use mhotovy;

start transaction;

drop table if exists InvoiceProduct;
drop table if exists Invoice;
drop table if exists Product;
drop table if exists Customer;
drop table if exists Email;
drop table if exists Person;
drop table if exists Address;
drop table if exists State;
drop table if exists Country;

create table Country (
  countryKey int primary key not null auto_increment,
  countryName varchar(100)
)engine=InnoDB,collate=latin1_general_cs;

create table State (
  stateKey int primary key not null auto_increment,
  stateName varchar(100), 
  countryKey int,
  foreign key (countryKey) references Country(countryKey)
)engine=InnoDB,collate=latin1_general_cs;

create table Address (
  addressKey int primary key not null auto_increment,
  street varchar(100) not null,
  city varchar(100) not null,
  zip varchar(100),
  stateKey int,
  countryKey int not null, 
  foreign key (countryKey) references Country(countryKey),
  foreign key (stateKey) references State(stateKey)
)engine=InnoDB,collate=latin1_general_cs;

create table Person (
  personKey int primary key not null auto_increment,
  personUUid varchar(100) not null,
  lastName varchar(100) not null,
  firstName varchar(100) not null,
  addressKey int not null,
  foreign key (addressKey) references Address(addressKey)
)engine=InnoDB,collate=latin1_general_cs;

create table Email (
  emailUuid int primary key not null auto_increment,
  email varchar(100),
  personKey int not null,
  foreign key (personKey) references Person(personKey)
)engine=InnoDB,collate=latin1_general_cs;

create table Customer (
  customerKey int primary key not null auto_increment,
  customerUuid varchar(100),
  customerType varchar(10) not null,
  customerName varchar(100) not null,
  personKey int not null,
  addressKey int not null,
  foreign key (personKey) references Person(personKey),
  foreign key (addressKey) references Address(addressKey)
)engine=InnoDB,collate=latin1_general_cs;

create table Product (
  productKey int primary key not null auto_increment,
  productUuid varchar(100) not null,
  productType varchar(10) not null,
  name varchar(100) not null,
  personKey int,
  hourlyFee double,
  annualLicenseFee double,
  serviceFee double,
  pricePerUnit double,
  foreign key (personKey) references Person(personKey)
)engine=InnoDB,collate=latin1_general_cs;

create table Invoice (
  invoiceKey int primary key not null auto_increment,
  invoiceUuid varchar(100) not null,
  customerKey int not null,
  personKey int not null,
  foreign key (customerKey) references Customer(customerKey),
  foreign key (personKey) references Person(personKey)
)engine=InnoDB,collate=latin1_general_cs;

create table InvoiceProduct (
 invoiceProductKey int primary key not null auto_increment,
 numberOfUnits int, 
 billableHours int,
 effectiveBeginDate varchar(20),
 effectiveEndDate varchar(20),
 productKey int,
 invoiceKey int,
 foreign key (productkey) references Product(productKey),
 foreign key (invoiceKey) references Invoice(invoiceKey)
)engine=InnoDB,collate=latin1_general_cs;

#Person Country
insert into Country (countryName) values ("Canada");
insert into Country (countryName) values ("USA");

#Customer Country
insert into Country (countryName) values ("Portugal");
insert into Country (countryName) values ("Philippines");
insert into Country (countryName) values ("China");
insert into Country (countryName) values ("Peru");

#Person State
insert into State (stateName, countryKey) values ("ON", (select countryKey from Country where countryName = "Canada"));
insert into State (stateName, countryKey) values ("TX", (select countryKey from Country where countryName = "USA"));
insert into State (stateName, countryKey) values ("IL", (select countryKey from Country where countryName = "USA"));
insert into State (stateName, countryKey) values ("NY", (select countryKey from Country where countryName = "USA"));

#Customer State
insert into State (stateName, countryKey) values ("Guangzhou", (select countryKey from Country where countryName = "Portugal"));
insert into State (stateName, countryKey) values (null, (select countryKey from Country where countryName = "Philippines"));
insert into State (stateName, countryKey) values (null, (select countryKey from Country where countryName = "China"));
insert into State (stateName, countryKey) values (null, (select countryKey from Country where countryName = "Peru"));

#Person Address
insert into Address (street, city, zip, stateKey, countryKey) values ("1 Blue Jays Way", "Toronto", "M5V 1J1", (select stateKey from State where statename = "ON"), null);
insert into Address (street, city, zip, stateKey, countryKey) values ("123 Friendly Street", "Ottawa", "K1A 0G9", (select stateKey from State where statename = "ON"), null);
insert into Address (street, city, zip, stateKey, countryKey) values ("8753 West 3rd Ave.", "Dallas", "75001", (select stateKey from State where statename = "TX"), null);
insert into Address (street, city, zip, stateKey, countryKey) values ("333 W 35th St", "Chicago", "60616", (select stateKey from State where statename = "IL"), null);
insert into Address (street, city, zip, stateKey, countryKey) values ("1 Wall Street", "New York", "10005-0012", (select stateKey from State where statename = "NY"), null);
insert into Address (street, city, zip, stateKey, countryKey) values ("126-01 Roosevelt Ave", "Flushing", "11368", (select stateKey from State where statename = "NY"), null);
insert into Address (street, city, zip, stateKey, countryKey) values ("321 Bronx Street", "New York", "10004", (select stateKey from State where statename = "NY"), null);
insert into Address (street, city, zip, stateKey, countryKey) values ("1060 West Addison Street", "Chicago", "60613", (select stateKey from State where statename = "IL"), null);
insert into Address (street, city, zip, stateKey, countryKey) values ("1 E 161st St", "Bronx", "10451", (select stateKey from State where statename = "NY"), null);
insert into Address (street, city, zip, stateKey, countryKey) values ("1060 East Addison Street", "Chicago", "60613", (select stateKey from State where statename = "IL"), null);

#Customer Address
insert into Address (street, city, zip, stateKey, countryKey) values ("7695 Lakewood Gardens Terrace", "Malpique", "2250-325", (select stateKey from State where statename = "Guangzhou"), null);
insert into Address (street, city, zip, stateKey, countryKey) values ("306 Clemons Place", "Jaguimitan", "1664", null, (select countryKey from Country where countryName = "Philippines"));
insert into Address (street, city, zip, stateKey, countryKey) values ("656 Vidon Center", "Shenzhen", null, null, (select countryKey from Country where countryName = "China"));
insert into Address (street, city, zip, stateKey, countryKey) values ("62 Dexter Hill", "Tunal", null, null, (select countryKey from Country where countryName = "Peru"));

# Primary Contact Person
insert into Person (personUuid, lastName, firstName, addressKey) values ("231", "Baker", "Tom", (select addressKey from Address where street = "1 Blue Jays Way"));
insert into Person (personUuid, lastName, firstName, addressKey) values ("wrddoc", "Smith", "Matt", (select addressKey from Address where street = "333 W 35th St"));
insert into Person (personUuid, lastName, firstName, addressKey) values ("1svndr", "McCoy", "Sylvester", (select addressKey from Address where street = "126-01 Roosevelt Ave"));
insert into Person (personUuid, lastName, firstName, addressKey) values ("nwdoc1", "Eccleston", "Chris", (select addressKey from Address where street = "1 E 161st St"));

# Consultant Person
insert into Person (personUuid, lastName, firstName, addressKey) values ("55bb", "O'Brien", "Tim", (select addressKey from Address where street = "8753 West 3rd Ave."));
insert into Person (personUuid, lastName, firstName, addressKey) values ("944c", "Castro", "Starlin", (select addressKey from Address where street = "1060 West Addison Street")); #XXX

# Sales Person
# for the addressKey we may want to think about adding in ands for the rest of the address stuff to make it more specific.
insert into Person (personUuid, lastName, firstName, addressKey) values ("2342", "O'Brien", "Miles", (select addressKey from Address where street = "123 Friendly Street"));
insert into Person (personUuid, lastName, firstName, addressKey) values ("aef1", "Gekko", "Gordon", (select addressKey from Address where street = "1 Wall Street"));
insert into Person (personUuid, lastName, firstName, addressKey) values ("321f", "Fox", "Bud", (select addressKey from Address where street = "321 Bronx Street"));
insert into Person (personUuid, lastName, firstName, addressKey) values ("ma12", "Sveum", "Dale", (select addressKey from Address where street = "1060 East Addison Street"));


# Primary Contact Emails
insert into Email (email, personKey) values ("famousdoc@who.com", (select personKey from Person where personUuid = "231"));
insert into Email (email, personKey) values ("tbaker@cse.unl.edu", (select personKey from Person where personUuid = "231"));
insert into Email (email, personKey) values ("mostfamous@whovian.com", (select personKey from Person where personUuid = "231"));
insert into Email (email, personKey) values ("thedoctor@bbc.com", (select personKey from Person where personUuid = "231"));
insert into Email (email, personKey) values ("obrien@ds9.com", (select personKey from Person where personUuid = "55bb"));
insert into Email (email, personKey) values ("obrien@enterprise.gov", (select personKey from Person where personUuid = "55bb"));
insert into Email (email, personKey) values ("msmith@who.com", (select personKey from Person where personUuid = "wrddoc"));
insert into Email (email, personKey) values ("thedoc@cse.unl.edu", (select personKey from Person where personUuid = "wrddoc"));
insert into Email (email, personKey) values ("slyguy@hotmail.com", (select personKey from Person where personUuid = "1svndr"));
insert into Email (email, personKey) values ("mccoy@whofan.com", (select personKey from Person where personUuid = "1svndr"));
insert into Email (email, personKey) values ("bfox@gmail.com", (select personKey from Person where personUuid = "321f"));
insert into Email (email, personKey) values ("csheen@crazy.net", (select personKey from Person where personUuid = "321f"));
insert into Email (email, personKey) values ("scastro@cubs.com", (select personKey from Person where personUuid = "944c"));
insert into Email (email, personKey) values ("starlin_castro13@gmail.com", (select personKey from Person where personUuid = "944c"));
insert into Email (email, personKey) values ("newguy@whovian.com", (select personKey from Person where personUuid = "nwdoc1"));
insert into Email (email, personKey) values ("sveum@cubs.com", (select personKey from Person where personUuid = "ma12"));

# Customers
insert into Customer (customerUuid, customerType, personKey, customerName, addressKey) values ("149j", "G", (select personKey from Person where personUuid = "231"), "Altavista", 
																							  (select addressKey from Address where street = "7695 Lakewood Gardens Terrace"));
insert into Customer (customerUuid, customerType, personKey, customerName, addressKey) values ("3l50", "C", (select personKey from Person where personUuid = "wrddoc"), "Microsoft", 
																							  (select addressKey from Address where street = "306 Clemons Place" ));
insert into Customer (customerUuid, customerType, personKey, customerName, addressKey) values ("ttew", "G", (select personKey from Person where personUuid = "1svndr"), "Borland", 
																							  (select addressKey from Address where street = "656 Vidon Center"));
insert into Customer (customerUuid, customerType, personKey, customerName, addressKey) values ("5xtt", "C", (select personKey from Person where personUuid = "nwdoc1"),"Chami", 
																							  (select addressKey from Address where street = "62 Dexter Hill"));


# Products 
insert into Product (productUuid, productType, name, personKey, hourlyFee, annualLicenseFee, serviceFee, pricePerUnit) 
					  values ("a34e", "E", "GreyScale Organizer", null, null, null, null, 140.56);
insert into Product (productUuid, productType, name, personKey, hourlyFee, annualLicenseFee, serviceFee, pricePerUnit) 
				      values ("94ka", "C", "Dog Bone Training", (select personKey from Person where personUuid = "55bb"), 35.00, null, null, null);
insert into Product (productUuid, productType, name, personKey, hourlyFee, annualLicenseFee, serviceFee, pricePerUnit) 
				      values ("111a", "L", "Fone Registration", null, null, 400.00, 5500.00, null);
insert into Product (productUuid, productType, name, personKey, hourlyFee, annualLicenseFee, serviceFee, pricePerUnit) 
				      values ("900g", "C", "Organizer Trainingn", (select personKey from Person where personUuid = "944c"), 50.00, null, null, null);
insert into Product (productUuid, productType, name, personKey, hourlyFee, annualLicenseFee, serviceFee, pricePerUnit) 
				      values ("1449", "E", "Dog Discs", null, null, null, null, 1010.10);
insert into Product (productUuid, productType, name, personKey, hourlyFee, annualLicenseFee, serviceFee, pricePerUnit) 
				      values ("1p94", "L", "PlayByPlay Long Distance Service", null, null, 3500.00, 12000.00, null);
insert into Product (productUuid, productType, name, personKey, hourlyFee, annualLicenseFee, serviceFee, pricePerUnit) 
				      values ("f9f2", "E", "GreyScale Sound System", null, null, null, null, 549.99);
insert into Product (productUuid, productType, name, personKey, hourlyFee, annualLicenseFee, serviceFee, pricePerUnit) 
				      values ("t5he", "L", "Happy Time", null, null, 1755.00, 1000.00, null);
insert into Product (productUuid, productType, name, personKey, hourlyFee, annualLicenseFee, serviceFee, pricePerUnit) 
				      values ("24fg", "E", "Dog Fone", null, null, null, null, 2289.41);
                      

# Invoices
insert into Invoice (invoiceUuid, customerKey, personKey) 
                      values ("INV001", (select customerKey from Customer where customerUuid = "149j"),
                      (select personKey from Person where personUuid = "2342"));
insert into Invoice (invoiceUuid, customerKey, personKey) 
                      values ("INV002", (select customerKey from Customer where customerUuid = "3l50"),
                      (select personKey from Person where personUuid = "aef1"));
insert into Invoice (invoiceUuid, customerKey, personKey) 
                      values ("INV003", (select customerKey from Customer where customerUuid = "ttew"),
                      (select personKey from Person where personUuid = "321f"));
insert into Invoice (invoiceUuid, customerKey, personKey) 
                      values ("INV004", (select customerKey from Customer where customerUuid = "5xtt"),
                      (select personKey from Person where personUuid = "ma12"));
                      

# InvoiceProduct
insert into InvoiceProduct (numberOfUnits, billableHours, effectiveBeginDate, effectiveEndDate, productKey, invoiceKey) values
                           (2, null, null, null, (select productKey from Product where productUuid = "a34e"),
                           (select invoiceKey from Invoice where invoiceUuid = "INV001"));
insert into InvoiceProduct (numberOfUnits, billableHours, effectiveBeginDate, effectiveEndDate, productKey, invoiceKey) values 
                           (null, 10, null, null, (select productKey from Product where productUuid = "94ka"), 
                           (select invoiceKey from Invoice where invoiceUuid = "INV001"));
insert into InvoiceProduct (numberOfUnits, billableHours, effectiveBeginDate, effectiveEndDate, productKey, invoiceKey) values
                           (null, null, 2017-02-01, 2019-02-11, (select productKey from Product where productUuid = "111a"), 
                           (select invoiceKey from Invoice where invoiceUuid = "INV002"));
insert into InvoiceProduct (numberOfUnits, billableHours, effectiveBeginDate, effectiveEndDate, productKey, invoiceKey) values 
                           (null, 25, null, null, (select productKey from Product where productUuid = "900g"), 
                           (select invoiceKey from Invoice where invoiceUuid = "INV003"));
insert into InvoiceProduct (numberOfUnits, billableHours, effectiveBeginDate, effectiveEndDate, productKey, invoiceKey) values
                           (3, null, null, null, (select productKey from Product where productUuid = "1449"), 
                           (select invoiceKey from Invoice where invoiceUuid = "INV003"));
insert into InvoiceProduct (numberOfUnits, billableHours, effectiveBeginDate, effectiveEndDate, productKey, invoiceKey) values
                           (null, null, 2018-05-13, 2019-05-13, (select productKey from Product where productUuid = "1p94"), 
						   (select invoiceKey from Invoice where invoiceUuid = "INV003"));
insert into InvoiceProduct (numberOfUnits, billableHours, effectiveBeginDate, effectiveEndDate, productKey, invoiceKey) values
                           (4, null, null, null, (select productKey from Product where productUuid = "f9f2"), 
						   (select invoiceKey from Invoice where invoiceUuid = "INV004"));
insert into InvoiceProduct (numberOfUnits, billableHours, effectiveBeginDate, effectiveEndDate, productKey, invoiceKey) values 
                           (null, null, 2016-04-01, 2017-06-07, (select productKey from Product where productUuid = "t5he"), 
                           (select invoiceKey from Invoice where invoiceUuid = "INV004"));

commit;
