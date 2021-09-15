-- 製品テーブル
CREATE TABLE IF NOT EXISTS products(
    -- 製品ID
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
    -- 在庫ID
    id INTEGER PRIMARY KEY,
    -- 製品ID
    product_id BINARY(16) NOT NULL,
    -- 在庫数
    quantity INTEGER NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- 売上履歴テーブル
CREATE TABLE IF NOT EXISTS sales_history(
    -- 履歴ID
    id BINARY(16) PRIMARY KEY,
    -- 購入時刻
    purchase_time DATETIME NOT NULL,
    -- 製品ID
    product_id BINARY(16) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- 投入金額とお釣りテーブル
CREATE TABLE IF NOT EXISTS coin_box(
    -- ID
    id INTEGER PRIMARY KEY,
    -- 投入金額
    deposit INTEGER NOT NULL,
    -- 10円玉の残り枚数
    left_10 INTEGER NOT NULL,
    -- 50円玉の残り枚数
    left_50 INTEGER NOT NULL,
    -- 100円玉の残り枚数
    left_100 INTEGER NOT NULL,
    -- 500円玉の残り枚数
    left_500 INTEGER NOT NULL,
    -- 1000円玉の残り枚数
    left_1000 INTEGER NOT NULL
);