package org.grails.plugins.flowManager

class UtilTagLib {
    static namespace = "util"

    def sayHello= {attrs, body->
        out << "Hello ${attrs.name}!"

    }

}
