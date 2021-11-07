package app.vendingmachine.config

import com.google.common.collect.Sets.newHashSet
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SpringFoxConfig {
    @Bean // @Beanを使用することでDocketインスタンスを設定することができます。
    fun api(): Docket =
            Docket(DocumentationType.SWAGGER_2)
                    .groupName("vending-machine") // グループネームの設定。
                    .select()
                    // ApiSelectorBuilderを返し、swaggerを通してエンドポイントを制御する。
                    .apis(RequestHandlerSelectors.any())
                    // 指定したAPIのみを出力したい場合使用する。今回はデフォルトのanyを使用。
                    .paths(PathSelectors.regex("/api.*"))
                    // 指定したパス以下のAPIのみを対象としたい場合使用する。これをしないとSpring Bootのデフォルトのエラーまで出力されてしまう。。
                    .build()
                    // select()とapis(), paths()を設定した後に必ず書く必要がある。

                    .apiInfo(apiinfo())
                    // APIの冒頭の説明部分をapiinfo()を参照して変更します。
                    .protocols(newHashSet("http", "https"))
    // 複数のプロトコル/スキーマを設定することができます。

    fun apiinfo(): ApiInfo =
            ApiInfoBuilder()
                    .title("Vending Machine API")
                    .description("自動販売機を扱うためのAPIです。")
                    .version("1.0.0")
                    // .contact(
                    //         Contact(
                    //                 "example",
                    //                 "http://example.com",
                    //                 "example@example.com"
                    //         )
                    // )
                    .build()
}
