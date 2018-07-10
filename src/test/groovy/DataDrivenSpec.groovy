import spock.lang.Specification

class DataDrivenSpec extends Specification {

    def "The numbers should be squared"(int base, int exponent, int ans) {
        expect:
            base ** exponent == ans // Groovy way of saying Math.pow()

        where:
            base | exponent | ans
            1    | 2        | 1
            2    | 2        | 4
            2    | 3        | 8
            3    | 2        | 9
            3    | 3        | 27

    }

}
