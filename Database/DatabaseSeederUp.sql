INSERT INTO dbo.Products (ProductId, ProductName)
VALUES (1, 'iPod'), (2, 'iPhone4'), (3, 'iPhone5'), (4, 'iPhone5S'), (5, 'iPhone5C'), (6, 'iPhone6'), (7, 'iPhoneSE'), (8, 'iPhone6+');

INSERT INTO dbo.StockHolders (StockHolderId, StockHolderName)
VALUES (1, 'AppleWarehouse'), (2, 'AppleStore1'), (3, 'AppleSotre2');

INSERT INTO dbo.Users (UserId, Username, Password, StockHolderId, AccessLevel)
VALUES (1, 'AppleWarehouseAdmin', '123', 1, 2), (2, 'AppleStoreAdmin', '123', 2, 2), (3, 'AppleStoreStockManager', '123', 2, 1);

INSERT INTO dbo.StockItems (StockItemId, StockHolderId, ProductId, Quantity)
VALUES
(1, 1, 1, 1000), (2, 1, 2, 1000), (3, 1, 3, 1000), (4, 1, 4, 1000), (5, 1, 5, 1000), (6, 1, 6, 1000), (7, 1, 7, 1000), (8, 1, 8, 1000),
(9, 2, 1, 35), (10, 2, 2, 15), (11, 2, 3, 13), (12, 2, 4, 45), (13, 2, 5, 37), (14, 2, 6, 12), (15, 2, 7, 8), (16, 2, 8, 9),
(17, 3, 1, 1000), (18, 3, 2, 1000), (19, 3, 3, 1000), (20, 3, 4, 1000), (21, 3, 5, 1000), (22, 3, 6, 1000), (23, 3, 7, 1000), (24, 3, 8, 1000);
