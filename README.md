# vending-machine

自動販売機をWebアプリで再現します。

https://vending--machine.herokuapp.com/

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

# データベース

テーブルを作成するSQLファイルはこちらです。
[springboot/src/test/resources/schema.sql](springboot/src/test/resources/schema.sql)