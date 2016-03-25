CREATE TABLE [dbo].[Products]
(
	[ProductId] INT NOT NULL PRIMARY KEY,
	[ProductName] NCHAR(30) NULL
)

CREATE TABLE [dbo].[StockHolders]
(
	[StockHolderId] INT NOT NULL PRIMARY KEY,
	[StockHolderName] NCHAR(30) NULL
)

CREATE TABLE [dbo].[Users]
(
	[UserId] INT NOT NULL PRIMARY KEY, 
    [Username] NCHAR(30) NULL, 
    [Password] NCHAR(30) NULL, 
    [StockHolderId] INT NULL,
    [AccessLevel] INT NOT NULL
)

CREATE TABLE [dbo].[StockItems]
(
	[StockItemId] INT NOT NULL PRIMARY KEY,
	[StockHolderId] INT NOT NULL,
	[ProductId] INT NOT NULL,
	[Quantity] INT NOT NULL
)

ALTER TABLE [dbo].[Users]
ADD FOREIGN KEY (StockHolderId)
REFERENCES StockHolders(StockHolderId)

ALTER TABLE [dbo].[StockItems]
ADD FOREIGN KEY (StockHolderId)
REFERENCES StockHolders(StockHolderId)

ALTER TABLE [dbo].[StockItems]
ADD FOREIGN KEY (ProductId)
REFERENCES Products(ProductId)