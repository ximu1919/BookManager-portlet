create table book_Books (
	bookId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	bookName VARCHAR(200) null,
	price DOUBLE,
	book_sn VARCHAR(75) null,
	content STRING null
);