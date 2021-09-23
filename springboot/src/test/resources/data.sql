INSERT INTO
  coin_box(
    id,
    deposit,
    deposit_10,
    deposit_50,
    deposit_100,
    deposit_500,
    deposit_1000,
    left_10,
    left_50,
    left_100,
    left_500,
    left_1000
  )
VALUES(
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    100,
    50,
    50,
    50,
    0
  );
INSERT INTO
  products (id, name, temperature, price, vendor_name)
values(
    "1",
    "天然の水",
    "cold",
    "100",
    "株式会社流水"
  );
INSERT INTO
  products (id, name, temperature, price, vendor_name)
values(
    "2",
    "あったかコーヒー",
    "hot",
    "120",
    "苦味株式会社"
  );
INSERT INTO
  stocks (id, product_id, quantity)
values(1, "1", 24);
INSERT INTO
  stocks (id, product_id, quantity)
values(2, "2", 24);