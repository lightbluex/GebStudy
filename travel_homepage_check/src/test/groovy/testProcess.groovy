import geb.spock.GebSpec
import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver

//class TravelHomePageSpec extends GebSpec {
//    def "Search for JAL in travel top page"() {
//        given:
//        to TravelHomePage
//
//        expect:
//        at TravelHomePage
//
//        when:
//        search.field.value("JAL")
//        search.button.click()
//
//        then:
//        waitFor { at TravelResultsPage }
//
//        when:
//        firstResultLink.click()
//
//        then:
//        waitFor { at HotelPage }
//    }
//}


Browser.drive {
    to TravelHomePage
    assert at(TravelHomePage)
    search.field.value("JAL")
    search.button.click()
    waitFor { at TravelResultsPage }
    firstResultLink.click()
    waitFor { at HotelPage }
}.quit()

    //Browser.drive {
    //    to TravelHomePage
    //    assert at(TravelHomePage)
    //    search.field.value("JAL")
    //    search.button.click()
    //    waitFor { at TravelResultsPage }
    //    firstResultLink.click()
    //    waitFor { at HotelPage }
    //}.quit()

