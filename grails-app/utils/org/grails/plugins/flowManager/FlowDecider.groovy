package org.grails.plugins.flowManager


interface FlowDecider {
    List getSequenceAsPerFlowType(def flowType)
}
