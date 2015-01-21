import geb.Browser
import geb.Page
import geb.Module
 
// modules are reusable fragments that can be used across pages that can be parameterised
// here we are using a module to model the search function on the home and results pages
class TravelSearchModule extends Module {
 
    // a parameterised value set when the module is included
    def buttonValue
 
    // the content DSL
    static content = {
 
        // name the search input control “field”, defining it with the jQuery like navigator
        field { $("input", name: "f_query") }
 
        // the search button declares that it takes us to the results page, and uses the 
        // parameterised buttonValue to define itself
        button(to: TravelResultsPage) { 
            $("a", id: "kw-submit")
        }
    }
}
 
class TravelHomePage extends Page {
 
    // pages can define their location, either absolutely or relative to a base
    static url = "http://travel.rakuten.co.jp"
 
    // “at checkers” allow verifying that the browser is at the expected page
    static at = { title.endsWith "予約サイト" }
 
    static content = {
        // include the previously defined module
        search { module TravelSearchModule, buttonValue: "検索" }
    }
}
 
class TravelResultsPage extends Page {
    static at = { title.endsWith "の検索結果【楽天トラベル】" }
//    static at = { title.startsWith "「JAL」" }
    static content = {
        // reuse our previously defined module
        search { module TravelSearchModule, buttonValue: "Search" }
 
        // content definitions can compose and build from other definitions
        results { $("div.hotelBox") }
        result { i -> results[i] }
        resultLink { i -> result(i).find("span.hotelName") }
        firstResultLink { resultLink(0) }
    }
}

class HotelPage extends Page {
    static at = {title.contains "JAL" || title.contains "ＪＡＬ"}
}
