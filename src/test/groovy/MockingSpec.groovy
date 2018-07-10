import io.richie.ContributionService
import spock.lang.Specification

import java.time.LocalDate

class MockingSpec extends Specification {

    def "Should return a status code of 0" (){

        given:
            def contributionMock = Mock(ContributionService)

        when:
            def statusCode = contributionMock.makeContribution(100.00)

        then:
            statusCode == 0
    }

    def 'Should return 201 when make a contribution of $100'(){
        given:
        def contributionMock = Mock(ContributionService)
        contributionMock.makeContribution(100.00) >> 201

        when:
        def statusCode = contributionMock.makeContribution(100.00)

        then:
        statusCode == 201
    }

    def 'Should return 204 when we cancel any contribution'(int contributionId, int statusCode){
        given:
        def contributionMock = Mock(ContributionService)
        contributionMock.cancelContribution(_) >> 204

        expect:
        contributionMock.cancelContribution(contributionId) == statusCode

        where:
        contributionId | statusCode
        100.00 | 204
        200.00 | 204
        300.00 | 204

    }

    def "Should verify setFutureDate method was called"() {
        given:
        def contributionMock = Mock(ContributionService)

        when:
        contributionMock.setFutureDate(1, LocalDate.now()) // TODO: Figure out why it doesn't work with _

        then:
        1 * contributionMock.setFutureDate(_, _)
    }
}
