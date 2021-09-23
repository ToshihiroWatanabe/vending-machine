package app.vendingmachine.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * index.htmlを返すコントローラークラスです。
 * SpringBootアプリとReactアプリを統合した場合でも、ルートパス以外でindex.htmlを表示できるようにします。
 */
@Controller
class IndexController {

    @RequestMapping("/", "/{x:[\\w\\-]+}", "/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}")
    fun getIndex(): String {
        return "/index.html"
    }
}