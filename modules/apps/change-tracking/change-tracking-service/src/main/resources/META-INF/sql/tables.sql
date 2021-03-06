create table CTCollection (
	ctCollectionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(200) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table CTEntry (
	ctEntryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ctCollectionId LONG,
	originalCTCollectionId LONG,
	modelClassNameId LONG,
	modelClassPK LONG,
	modelResourcePrimKey LONG,
	changeType INTEGER,
	collision BOOLEAN,
	status INTEGER
);

create table CTEntryAggregate (
	ctEntryAggregateId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ctCollectionId LONG,
	ownerCTEntryId LONG,
	status INTEGER
);

create table CTEntryAggregates_CTEntries (
	companyId LONG not null,
	ctEntryId LONG not null,
	ctEntryAggregateId LONG not null,
	primary key (ctEntryId, ctEntryAggregateId)
);

create table CTPreferences (
	ctPreferencesId LONG not null primary key,
	companyId LONG,
	userId LONG,
	ctCollectionId LONG,
	confirmationEnabled BOOLEAN
);

create table CTProcess (
	ctProcessId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	ctCollectionId LONG,
	backgroundTaskId LONG
);