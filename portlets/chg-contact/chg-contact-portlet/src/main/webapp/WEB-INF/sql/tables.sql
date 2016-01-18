create table chg_Area (
	areaId LONG not null primary key,
	name VARCHAR(250) null,
	mainEmail VARCHAR(75) null,
	userId LONG
);

create table chg_Contact (
	contactId LONG not null primary key,
	areaId LONG,
	createDate DATE null,
	status INTEGER,
	name VARCHAR(250) null,
	surname VARCHAR(250) null,
	activity VARCHAR(250) null,
	address VARCHAR(500) null,
	city VARCHAR(75) null,
	postalCode VARCHAR(75) null,
	email VARCHAR(75) null,
	telephone VARCHAR(75) null,
	subject VARCHAR(250) null,
	description VARCHAR(500) null,
	response VARCHAR(500) null
);

create table chg_Tracing (
	tracingId LONG not null primary key,
	areaId LONG,
	contactId LONG,
	status INTEGER,
	modifiedDate DATE null,
	comment_ VARCHAR(250) null
);