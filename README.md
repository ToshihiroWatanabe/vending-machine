# vending-machine

自動販売機をWebアプリで再現します。

https://vending--machine.herokuapp.com/

![購入画面](https://user-images.githubusercontent.com/79039863/134789659-69302ae7-49b7-42ec-8009-78fde60d3bd9.png)

![管理画面](https://user-images.githubusercontent.com/79039863/134789668-d78b1ac3-08c9-4349-85ee-38049a45a440.png)


# 仕様

- 投入金額は10円～9990円
- 同一の硬貨は一度に20枚までしか投入できない(**通貨の単位及び貨幣の発行等に関する法律**に準拠)

## 使えるお金

- 10円玉
- 50円玉
- 100円玉
- 500円玉
- 1000円札

# 使用技術

- React
- TypeScript
- Spring Boot
- Kotlin
- MyBatis
- MySQL

# 動作環境

- node v14.16.1
- npm 7.16.0
- JDK 11

# データベース

テーブルを作成するSQLファイルはこちらです。
[springboot/src/test/resources/schema.sql](springboot/src/test/resources/schema.sql)

# 環境変数

## 本番環境

キー|説明
---|---
MYSQL_URL|jdbc:mysql://ホスト名:ポート/データベース名
MYSQL_USERNAME|DBにログインするユーザー名
MYSQL_PASSWORD|DBにログインするパスワード