package faculife

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Coloquio)
class ColoquioSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def 'crer coloquio valido'() {
        when:
            Coloquio unColoquio = new Coloquio(description: 'integrales')
            unColoquio.save()
        then:
            Coloquio.count() == 1
    }

}
