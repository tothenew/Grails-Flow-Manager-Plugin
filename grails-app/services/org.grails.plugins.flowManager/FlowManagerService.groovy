package org.grails.plugins.flowManager

class FlowManagerService {

        FlowInfo flowInfo
        FlowDecider flowRuleSet // Defined by the user

        String moveToNextAction() {
            flowInfo.sequence = flowRuleSet.getSequenceAsPerFlowType(flowInfo.flowType)
            flowInfo.moveToNext()
        }

        String moveToPreviousAction() {
            flowInfo.sequence = flowRuleSet.getSequenceAsPerFlowType(flowInfo.flowType)
            flowInfo.moveToPrevious()
        }

        void setFlowType(def flowType) {
            flowInfo.flowType = flowType
        }
    }