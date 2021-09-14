package app.vendingmachine.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
@ConfigurationProperties(prefix = "security")
class SecurityConfig : WebSecurityConfigurerAdapter() {

    // 許可するドメイン
    lateinit var corsClientUrls: List<String>

    override fun configure(http: HttpSecurity?) {
        http
            // ...
            // 諸々の設定
            // ...
            ?.csrf()?.disable()
            // ?.and()
            ?.cors()
            ?.configurationSource(getCorsConfigurationSource()) //CORS設定
    }

    /**
     * CORS設定
     */
    fun getCorsConfigurationSource(): CorsConfigurationSource {

        val corsConfiguration = CorsConfiguration()

        // ①CORSを許可するURLの登録(Access-Control-Allow-Origin)
        this.corsClientUrls.forEach { corsConfiguration.addAllowedOrigin(it) }

        // ②許可するHeaderの登録(Access-Control-Allow-Headers)
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL)

        // ③許可するMethodの登録(Access-Control-AllowMethods)
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL)

        // ④認証情報送信許可の登録(Access-Control-Allow-Credentials)
        corsConfiguration.allowCredentials = true

        val corsSource = UrlBasedCorsConfigurationSource()

        // どのパスに上記ルールを適用するか
        corsSource.registerCorsConfiguration("/**", corsConfiguration)

        return corsSource
    }
}