# vending-machine

自動販売機をWebアプリで再現してみました。

https://vending--machine.herokuapp.com/

![購入画面](https://user-images.githubusercontent.com/79039863/134789659-69302ae7-49b7-42ec-8009-78fde60d3bd9.png)

![管理画面](https://user-images.githubusercontent.com/79039863/134789668-d78b1ac3-08c9-4349-85ee-38049a45a440.png)


# APIドキュメント

(本番環境)https://vending--machine.herokuapp.com/swagger-ui.html

(開発環境)http://localhost:8080/swagger-ui.html

# 主な仕様

- 使えるお金は10円玉、50円玉、100円玉、500円玉、1000円札
- 投入金額の合計は9990円まで
- 同一の硬貨は一度に20枚までしか投入できない(**通貨の単位及び貨幣の発行等に関する法律**に準拠)


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

DockerでMySQLのデータベースを作成できます。
```
docker-compose up
```

テーブルを作成するSQLファイルはこちらです。
[springboot/src/test/resources/schema.sql](springboot/src/test/resources/schema.sql)
初期データはこちらです。
[springboot/src/test/resources/data.sql](springboot/src/test/resources/data.sql)

# 環境変数

## 本番環境

キー|説明
---|---
MYSQL_URL|jdbc:mysql://ホスト名:ポート/データベース名
MYSQL_USERNAME|DBにログインするユーザー名
MYSQL_PASSWORD|DBにログインするパスワード