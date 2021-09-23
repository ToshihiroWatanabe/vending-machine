package app.vendingmachine.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * index.htmlに関するコントローラークラスです。
 * SpringBootアプリとReactアプリを統合した場合でも、ルートパス以外でindex.htmlを表示できるようにします。
 */
@Controller
class IndexController {

    /**
     * index.htmlを返します。
     */
    @RequestMapping("/", "/{x:[\\w\\-]+}", "/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}")
    fun getIndex(): String {
        return "/index.html"
    }
}