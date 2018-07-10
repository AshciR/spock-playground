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

    def 'Should return 201 when make a contribution of $100'(){
        given:
        def contributionMock = Mock(ContributionService)
        contributionMock.makeContribution(100.00) >> 201

        when:
        def statusCode = contributionMock.makeContribution(100.00)

        then:
        statusCode == 201
    }

    def 'Should return 201 when we make any contribution'(double amount, int statusCode){
        given:
        def contributionMock = Mock(ContributionService)
        contributionMock.makeContribution(_) >> 201

        expect:
        contributionMock.makeContribution(amount) == statusCode

        where:
        amount | statusCode
        100.00 | 201
        200.00 | 201
        300.00 | 201

    }
}
