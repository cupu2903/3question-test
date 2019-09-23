/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.0 		*/
/*  Created On : 23-Sep-2019 10:57:45 				*/
/*  DBMS       : SQL Server 2012 						*/
/* ---------------------------------------------------- */

/* Drop Foreign Key Constraints */

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[FK_Cart_Users]') AND OBJECTPROPERTY(id, N'IsForeignKey') = 1) 
ALTER TABLE [Cart] DROP CONSTRAINT [FK_Cart_Users]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[FK_Cart_Item_Cart]') AND OBJECTPROPERTY(id, N'IsForeignKey') = 1) 
ALTER TABLE [Cart_Item] DROP CONSTRAINT [FK_Cart_Item_Cart]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[FK_Cart_Item_Item]') AND OBJECTPROPERTY(id, N'IsForeignKey') = 1) 
ALTER TABLE [Cart_Item] DROP CONSTRAINT [FK_Cart_Item_Item]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[FK_Users_User_Type]') AND OBJECTPROPERTY(id, N'IsForeignKey') = 1) 
ALTER TABLE [Users] DROP CONSTRAINT [FK_Users_User_Type]
GO

/* Drop Tables */

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[Cart]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [Cart]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[Cart_Item]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [Cart_Item]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[Item]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [Item]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[User_Type]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [User_Type]
GO

IF EXISTS (SELECT 1 FROM dbo.sysobjects WHERE id = object_id(N'[Users]') AND OBJECTPROPERTY(id, N'IsUserTable') = 1) 
DROP TABLE [Users]
GO

/* Create Tables */

CREATE TABLE [Cart]
(
	[cart_id] varchar(40) NOT NULL,
	[cart_dt] datetime2(7) NOT NULL,
	[subtotal] int NULL,
	[discount_percentage] int NULL,
	[discount_nominal] int NULL,
	[total] int NULL,
	[users_id] varchar(40) NOT NULL
)
GO

CREATE TABLE [Cart_Item]
(
	[qty] int NOT NULL,
	[cart_id] varchar(40) NOT NULL,
	[item_id] varchar(40) NOT NULL
)
GO

CREATE TABLE [Item]
(
	[item_id] varchar(40) NOT NULL,
	[item_name] varchar(80) NOT NULL,
	[item_desc] varchar(256) NULL,
	[qty] int NOT NULL,
	[price] int NOT NULL
)
GO

CREATE TABLE [User_Type]
(
	[users_type] varchar(1) NOT NULL,
	[users_type_desc] varchar(40) NOT NULL,
	[users_id] varchar(40) NULL
)
GO

CREATE TABLE [Users]
(
	[users_id] varchar(40) NOT NULL,
	[passwd] varchar(128) NULL,
	[full_nm] varchar(80) NOT NULL,
	[phone_no] varchar(20) NULL,
	[reg_date] datetime2(7) NOT NULL,
	[users_type] varchar(1) NULL
)
GO

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE [Cart] 
 ADD CONSTRAINT [PK_Cart]
	PRIMARY KEY CLUSTERED ([cart_id] ASC)
GO

CREATE NONCLUSTERED INDEX [IXFK_Cart_Users] 
 ON [Cart] ([users_id] ASC)
GO

ALTER TABLE [Cart_Item] 
 ADD CONSTRAINT [PK_Cart_Item]
	PRIMARY KEY CLUSTERED ([cart_id] ASC,[item_id] ASC)
GO

CREATE NONCLUSTERED INDEX [IXFK_Cart_Item_Cart] 
 ON [Cart_Item] ([cart_id] ASC)
GO

CREATE NONCLUSTERED INDEX [IXFK_Cart_Item_Item] 
 ON [Cart_Item] ([item_id] ASC)
GO

ALTER TABLE [Item] 
 ADD CONSTRAINT [PK_Item]
	PRIMARY KEY CLUSTERED ([item_id] ASC)
GO

ALTER TABLE [User_Type] 
 ADD CONSTRAINT [PK_Users_Type]
	PRIMARY KEY CLUSTERED ([users_type] ASC)
GO

CREATE NONCLUSTERED INDEX [IXFK_User_Type_Users] 
 ON [User_Type] ([users_id] ASC)
GO

ALTER TABLE [Users] 
 ADD CONSTRAINT [PK_Users]
	PRIMARY KEY CLUSTERED ([users_id] ASC)
GO

CREATE NONCLUSTERED INDEX [IXFK_Users_User_Type] 
 ON [Users] ([users_type] ASC)
GO

CREATE NONCLUSTERED INDEX [IXFK_Users_User_Type_02] 
 ON [Users] ([users_type] ASC)
GO

/* Create Foreign Key Constraints */

ALTER TABLE [Cart] ADD CONSTRAINT [FK_Cart_Users]
	FOREIGN KEY ([users_id]) REFERENCES [Users] ([users_id]) ON DELETE Cascade ON UPDATE Cascade
GO

ALTER TABLE [Cart_Item] ADD CONSTRAINT [FK_Cart_Item_Cart]
	FOREIGN KEY ([cart_id]) REFERENCES [Cart] ([cart_id]) ON DELETE Cascade ON UPDATE Cascade
GO

ALTER TABLE [Cart_Item] ADD CONSTRAINT [FK_Cart_Item_Item]
	FOREIGN KEY ([item_id]) REFERENCES [Item] ([item_id]) ON DELETE Cascade ON UPDATE Cascade
GO

ALTER TABLE [Users] ADD CONSTRAINT [FK_Users_User_Type]
	FOREIGN KEY ([users_type]) REFERENCES [User_Type] ([users_type]) ON DELETE Cascade ON UPDATE Cascade
GO
