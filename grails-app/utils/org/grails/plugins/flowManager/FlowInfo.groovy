package org.grails.plugins.flowManager


import org.apache.commons.lang.builder.ToStringBuilder

class FlowInfo implements Serializable {
    Boolean editMode
    def flowType
    String currentSF
    def flowData
    List sequence
    String errorMessage
    String successMessage
    String submitValue

    String getNext() {
        int index = sequence.indexOf(currentSF)
        if (index < sequence.size() - 1) {
            index = index + 1
        }
        sequence.get(index)
    }

    String getPrevious() {
        int index = sequence.indexOf(currentSF)
        if (index > 0) {
            index = index - 1
        } else {
            index = 0
        }
        sequence.get(index)
    }

    String moveToPrevious() {
        currentSF = previous
        currentSF
    }

    String moveToNext() {
        currentSF = next
        currentSF
    }

    int getCurrentStepNumber() {
        sequence.indexOf(currentSF) + 1
    }


    String toString() {
        new ToStringBuilder(this).append("currentSF: $currentSF, flowType: $flowType, sequence: $sequence, FlowData: ${flowData}").toString()
    }
}