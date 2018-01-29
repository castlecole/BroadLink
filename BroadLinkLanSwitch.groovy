/**
 *  Broadlink Switch
 *
 *  Copyright 2016 BeckyR
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
 *  1/7/17 - updated with better switch displays and use of device ID from user itsamti
 */
 
 
// 09/01/2016 - itsamti - Added new switch definition below 
metadata {
	
    definition (name: "BroadLink LAN Switch", namespace: "castlecole", author: "BeckyR") {
	capability "Switch"
        capability "Actuator"
        capability "Configuration"
        capability "Refresh"

	command "onPhysical"
	command "offPhysical"
    }

    // simulator metadata
    simulator {
        // status messages
        status "on": "on/off: 1"
        status "off": "on/off: 0"

        // reply messages
        reply "zcl on-off on": "on/off: 1"
        reply "zcl on-off off": "on/off: 0"
    }

    tiles(scale: 2) {
        multiAttributeTile(name:"switch", type: "lighting", width: 6, height: 4, canChangeIcon: false){
            tileAttribute ("device.switch", key: "PRIMARY_CONTROL") { 
                attributeState "on", label:"", action:"switch.off", icon:"https://raw.githubusercontent.com/castlecole/Xiaomi/master/light_bulb_on.png", backgroundColor:"#359148", nextState:"turningOff"
                attributeState "off", label:"", action:"switch.on", icon:"https://raw.githubusercontent.com/castlecole/Xiaomi/master/light_bulb_off.png", backgroundColor:"#00a0dc", nextState:"turningOn"
                attributeState "turningOn", label:'\n\n Turning On', action:"switch.off", icon:"", backgroundColor:"#359148", nextState:"turningOff"
                attributeState "turningOff", label:'\n\n Turning Off', action:"switch.on", icon:"", backgroundColor:"#00a0dc", nextState:"turningOn"
            }
            tileAttribute("device.lastCheckin", key: "SECONDARY_CONTROL") {
    		        attributeState("default", label:'Last Update: ${currentValue}',icon: "st.Health & Wellness.health9")
	          }
        }
        standardTile("blank", "device.refresh", inactiveLabel: true, decoration: "flat", width: 4, height: 2) {
            state "default", label:"", action:""
	      }
	      standardTile("refresh", "device.refresh", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
  	        state "default", label:"", action:"refresh.refresh", icon:"https://raw.githubusercontent.com/castlecole/customdevices/master/refresh.png"
        }

        multiAttributeTile(name:"switch2", type: "lighting", width: 6, height: 4, canChangeIcon: false){
            tileAttribute ("device.switch", key: "PRIMARY_CONTROL") { 
                attributeState "on", label:'${name}', action:"switch.off", icon:"https://raw.githubusercontent.com/castlecole/Xiaomi/master/light_bulb_on.png", backgroundColor:"#359148", nextState:"turningOff"
                attributeState "off", label:'${name}', action:"switch.on", icon:"https://raw.githubusercontent.com/castlecole/Xiaomi/master/light_bulb_off.png", backgroundColor:"#00a0dc", nextState:"turningOn"
                attributeState "turningOn", label:'${name}', action:"switch.off", icon:"https://raw.githubusercontent.com/castlecole/Xiaomi/master/light_bulb_on.png", backgroundColor:"#359148", nextState:"turningOff"
                attributeState "turningOff", label:'${name}', action:"switch.on", icon:"https://raw.githubusercontent.com/castlecole/Xiaomi/master/light_bulb_off.png", backgroundColor:"#00a0dc", nextState:"turningOn"
            }
	}
	    
	main(["switch2"])
        details(["switch", "blank", "refresh"])
    }
}

def parse(String description) {
	  def pair = description.split(":")
	  createEvent(name: pair[0].trim(), value: pair[1].trim())
}

def on() {
	  sendEvent(name: "switch", value: "on")
	  put('on')
}

def off() {
	  sendEvent(name: "switch", value: "off")
	  put('off')
}

def onPhysical() {
	  sendEvent(name: "switch", value: "on", type: "physical")
	  put('on')
}

def offPhysical() {
	  sendEvent(name: "switch", value: "off", type: "physical")
	  put('off')
}

private put(toggle) {
    def url1="192.168.1.21:7474"
    def userpassascii="root:Universe-02"
    def userpass = "Basic " + userpassascii.encodeAsBase64().toString()
    def toReplace = device.deviceNetworkId
	  def replaced = toReplace.replaceAll(' ', '%20')
 	  def hubaction = new physicalgraph.device.HubAction(
				       method: "GET",
               path: "/send?deviceMac=$replaced",
               headers: [HOST: "${url1}", AUTHORIZATION: "${userpass}"],
    )
    return hubaction
}
