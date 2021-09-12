-- 製品テーブル
CREATE TABLE IF NOT EXISTS products(
    -- UUID
    id BINARY(16) PRIMARY KEY,
    -- 製品名
    name VARCHAR(100),
    -- 温度
    temperature VARCHAR(6) NOT NULL,
    -- 価格
    price INTEGER NOT NULL,
    -- 製造者
    vendor_name VARCHAR(100),
    -- 作成時刻
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    -- 更新時刻
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 在庫テーブル
CREATE TABLE IF NOT EXISTS stocks(
    id INTEGER PRIMARY KEY,
    product_id BINARY(16) NOT NULL,
    quantity INTEGER NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- 売上履歴テーブル
CREATE TABLE IF NOT EXISTS sales_history(
    -- UUID
    id BINARY(16) PRIMARY KEY,
    purchase_time DATETIME NOT NULL,
    product_id BINARY(16) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- 投入金額とお釣りテーブル
CREATE TABLE IF NOT EXISTS coin_slot(
    deposit INTEGER NOT NULL,
    left_10 INTEGER NOT NULL,
    left_50 INTEGER NOT NULL,
    left_100 INTEGER NOT NULL,
    left_500 INTEGER NOT NULL,
    left_1000 INTEGER NOT NULL
);