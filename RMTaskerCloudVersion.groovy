/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *
 * This is the cloud version for tasker.  It is fairly rudimentary, and linked to RM tasker as it stood in mid-2016. 
 * You will need to scan it to change your url, password and broadlink mac address manually.  I am not maintaing/supporting this
 * but added it for those who want it.  Likely does not work with the smartApps I added for the LAN version but i don't remember as
 * I don't use this version.
 /
metadata {
	definition (name: "broadlink", namespace: "castlecole", author: "BeckyR") {
		capability "Switch"
	}

	// tile definitions
	tiles {
		standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "on", label: '${name}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
			state "off", label: '${name}', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
		}

		main "switch"
		details "switch"
	}
}
 
import groovy.json.JsonSlurper   
def on() {
	put('On')
   
}

def off() {
	put('Off')
}

private put(toggle) {
def codeID = ""
def params = [
   uri: "http://username:password@your.publicip:yourportnumber/codes",
   conentType: "text/json"
    ]
    
	try {
    httpPostJson(params) { resp ->
	def text=resp.data.toString()
    def json = new JsonSlurper().parseText(text)
    json.each { 
     log.debug "$it.remoteName  ${device.name} $it.name  ${toggle}"
     if("$it.remoteName"=="${device.name}"&&"$it.name"=="${toggle}")
    {
    codeID = "$it.id"
    log.debug "code ID = ${codeID}"
    log.debug "device = $it.remotename"
    log.debug "code = $it.name"
   }}}
  } catch (e) {
    log.error "something went wrong: $e"}
    def params2 = [
    uri: "http://bhttp://username:password@your.publicip:yourportnumber/send?deviceMac=yourmac&codeId=${codeID}"]
    try {
      httpGet(params2) 
    } catch (e) {
      log.error "something went wrong: $e"}
}
