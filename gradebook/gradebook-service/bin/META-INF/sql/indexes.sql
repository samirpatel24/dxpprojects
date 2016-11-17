create index IX_DD8E18A4 on FOO_Assignment (groupId, status);
create index IX_846B685E on FOO_Assignment (resourceBlockId);
create index IX_208952 on FOO_Assignment (status);
create index IX_7203B560 on FOO_Assignment (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_31BA13E2 on FOO_Assignment (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2096845B on FOO_Submission (groupId, assignmentId);
create index IX_86CF9ADB on FOO_Submission (studentId);