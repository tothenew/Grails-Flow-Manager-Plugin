package org.grails.plugins.flowManager

class FlowManagerService {

        FlowInfo flowInfo
        FlowDecider flowDecider // Defined by the user

        String moveToNextAction() {
            flowInfo.sequence = flowDecider.getSequenceAsPerFlowType(flowInfo.flowType)
            flowInfo.moveToNext()
        }

        String moveToPreviousAction() {
            flowInfo.sequence = flowDecider.getSequenceAsPerFlowType(flowInfo.flowType)
            flowInfo.moveToPrevious()
        }

        void setFlowType(def flowType) {
            flowInfo.flowType = flowType
        }
    }
