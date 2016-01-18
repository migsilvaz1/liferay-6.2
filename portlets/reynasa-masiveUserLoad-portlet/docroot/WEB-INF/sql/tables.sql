create table reynasa_MasiveLoadUser (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	successFile LONG,
	errorFile LONG,
	statusExecution INTEGER
);

create table reynasa_masiveLoadUser (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	successFile LONG,
	errorFile LONG,
	statusExecution INTEGER
);

create table reynasa_masiveuserload (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	successFile LONG,
	errorFile LONG,
	status INTEGER
);