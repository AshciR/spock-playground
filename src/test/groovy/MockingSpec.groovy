import io.richie.ContributionService
import spock.lang.Specification

class MockingSpec extends Specification {

    def "Should return a status code of 0" (){

        given:
            def contributionMock = Mock(ContributionService)

        when:
            def statusCode = contributionMock.makeContribution(100.00)

        then:
            statusCode == 0
    }

}
