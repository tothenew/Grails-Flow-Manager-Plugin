package sampleplugin

import org.grails.plugins.flowManager.FlowInfo
import org.codehaus.groovy.grails.commons.ApplicationHolder

class FlowManagerFilters {

    def getFlowManagerService() {
        ApplicationHolder.application.getMainContext().getBean('flowManagerService')
    }

    FlowInfo getFlowInfo() {
        flowManagerService.flowInfo
    }

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                println "controller: $controllerName, action: $actionName, params: $params"
                if (grailsApplication.getArtefactByLogicalPropertyName("Controller", controllerName).hasProperty('flowManagerService')) {
                    flowInfo.submitValue = params.submit
                    if (actionName?.startsWith('save')) {
                        String actName =actionName.substring(4)
                        flowInfo.currentSF =  actName.replaceFirst(actName[0], actName[0].toLowerCase())
                        println "setting the current SF to ${flowInfo.currentSF}"
                    }
                    if(actionName == 'init'){
                        flowInfo.submitValue = 'next'
                    }
                    println "beforeinterceptor: ... ${flowInfo.submitValue}"
                    return true
                }
            }

            after = { Map model ->
                if (grailsApplication.getArtefactByLogicalPropertyName("Controller", controllerName).hasProperty('flowManagerService') ) {
                    println "After Interceptor: Deciding next with: ${flowInfo.submitValue}"
                    switch (flowInfo.submitValue) {
                        case 'next':
                            redirect(controller: controllerName, action: "${flowManagerService.moveToNextAction()}")
                            break;

                        case 'back':
                            redirect(controller: controllerName, action: "${flowManagerService.moveToPreviousAction()}")
                            break;

                        case 'cancel':
                            redirect(controller: controllerName, action:  "cancel")
                            break;
                        default:
                            return true
                    }
                    log.debug "Doing the action:  ${flowInfo.submitValue}"
                    return false
                }
            }

            afterView = {


            }
        }
    }
}