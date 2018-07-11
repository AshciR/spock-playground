import spock.lang.Specification

class BasicSpecification extends Specification {

    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "two + two should equal four"(){
        given:
            int left = 2
            int right = 2

        when:
        int result = left + right

        then:
            result == 4
    }

    def "should remove from list"(){
        given:
            def list = [1, 2, 3, 4]

        when:
            list.remove(0)

        then:
            list == [2, 3, 4]
    }

    def "should throw a Index out of bounds exception"(){
        given:
            def list = [1, 2, 3, 4]

        when:
            list.remove(5)

        then:
            thrown(IndexOutOfBoundsException)
            list.size() == 4
    }

    def "map should have the correct values when updated"(){
        given:
            def map = ["one" : 1, "two" : 2, "three" : 3]

        when:
            map["one"] = 100

        then:
            map["one"] == 100
    }

}
