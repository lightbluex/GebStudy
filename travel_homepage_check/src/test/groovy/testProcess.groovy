import geb.Page
import geb.spock.GebSpec

class TravelHomePageSpec extends GebSpec {
    def "Search for JAL in travel top page"() {
        given:
        to TravelHomePage
 
        expect:
        at TravelHomePage
 
        when:
        search.field.value("JAL")
        search.button.click()
 
        then:
        waitFor { at TravelResultsPage }

        when:
        firstResultLink.click()

        then:
        waitFor { at HotelPage }
    }

}
