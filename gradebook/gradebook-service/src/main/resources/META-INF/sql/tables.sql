create table FOO_Assignment (
	uuid_ VARCHAR(75) null,
	assignmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dueDate DATE null,
	resourceBlockId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title STRING null,
	description STRING null
);

create table FOO_Submission (
	submissionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	assignmentId LONG,
	studentId LONG,
	submitDate DATE null,
	comment_ STRING null,
	grade INTEGER
);