create table ESTORE_Device (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	deviceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	name VARCHAR(150) null,
	deviceTypeId LONG,
	price LONG,
	count INTEGER,
	inStock BOOLEAN,
	archive BOOLEAN,
	description TEXT null
);

create table ESTORE_DeviceType (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	deviceTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	name VARCHAR(100) null
);

create table ESTORE_Employee (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	lastName VARCHAR(100) null,
	firstName VARCHAR(100) null,
	patronymic VARCHAR(100) null,
	birthDate DATE null,
	positionId LONG,
	gender INTEGER
);

create table ESTORE_EmployeeDeviceCons (
	companyId LONG not null,
	deviceTypeId LONG not null,
	employeeId LONG not null,
	primary key (deviceTypeId, employeeId)
);

create table ESTORE_EmployeePosition (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	positionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	name VARCHAR(100) null
);

create table ESTORE_Purchase (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	purchaseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	employeeId LONG,
	deviceId LONG,
	purchasedDate DATE null,
	count INTEGER,
	purchaseTypeId LONG
);

create table ESTORE_PurchaseType (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	purchaseTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	name VARCHAR(100) null
);