/**
 *  RM Bridge TV Remote
 *
 *  Copyright 20168 Enis Hoca
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
 * 	Author: Enis Hoca - enishoca@outlook.com
 *  For Details -  see https://community.smartthings.com/t/generic-tv-remote-device-handler-using-broadlink-rm-pro-and-mini/117384  
 */
 
preferences {    
	section("Internal Access"){
        input "internal_ip", "text", title: "IP for RM Bridge", description: "(ie. 192.168.0.12)", required: true
        input "internal_port", "text", title: "Port", description: "(ie. 7474)" , required: true
        input "POWEROFF", "text", title: "TV On/Off", description: "(RM Bridge code name)" , required: true
        input "SOUND", "text", title: "Sound On/Off", description: "(RM Bridge code name)" , required: false
        input "STB", "text", title: "Set Top Box On/Off", description: "(RM Bridge code name)" , required: false
        input "MUTE", "text", title: "Mute", description: "(RM Bridge code name)" , required: false
        input "HDMI", "text", title: "Source", description: "(RM Bridge code name)" , required: false
        input "MENU", "text", title: "Menu", description: "(RM Bridge code name)" , required: false
        input "TOOLS", "text", title: "Sound Source", description: "(RM Bridge code name)" , required: false
        input "SLEEP", "text", title: "Sleep", description: "(RM Bridge code name)" , required: false
        input "UP", "text", title: "Up", description: "(RM Bridge code name)" , required: false
        input "DOWN", "text", title: "Down", description: "(RM Bridge code name)" , required: false
        input "LEFT", "text", title: "Left", description: "(RM Bridge code name)" , required: false
        input "RIGHT", "text", title: "Right", description: "(RM Bridge code name)" , required: false
        input "CHUP", "text", title: "Channel Up", description: "(RM Bridge code name)" , required: false
        input "CHDOWN", "text", title: "Channel Down", description: "(RM Bridge code name)" , required: false
        input "PRECH", "text", title: "Prev Channel", description: "(RM Bridge code name)" , required: false
        input "EXIT", "text", title: "Exit", description: "(RM Bridge code name)" , required: false
        input "VOLUP", "text", title: "Volume Up", description: "(RM Bridge code name)" , required: false
        input "VOLDOWN", "text", title: "Volume Down", description: "(RM Bridge code name)" , required: false
        input "ENTER", "text", title: "Enter/OK", description: "(RM Bridge code name)" , required: false
        input "RETURN", "text", title: "Return", description: "(RM Bridge code name)" , required: false
        input "INFO", "text", title: "Info", description: "(RM Bridge code name)" , required: false
        input "PICTURE_SIZE", "text", title: "Picture Size", description: "(RM Bridge code name)" , required: false
	}
}
 
metadata {
	definition (name: "RM Bridge TV Remote", namespace: "castlecole", author: "Enis Hoca") {
        capability "switch" 
        capability "Switch Level"

        command "mute" 
        command "source"
        command "menu"    
        command "tools"           
        command "HDMI"    
        command "Sleep"
        command "Up"
        command "Down"
        command "Left"
        command "Right" 
        command "chup" 
        command "chdown"               
        command "prech"
        command "volup"    
        command "voldown"           
        command "Enter"
        command "Return"
        command "Exit"
        command "Info"            
        command "Size"
        command "sound"
        command "stb"
        command "all"
	}

    standardTile("switch", "device.switch", canChangeIcon: true) {
        state "default", label:'TV/STB/Sound', action:"all", icon:"st.Electronics.electronics15", backgroundColor:"#79b821"
    }

    standardTile("power", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'TV', action:"switch.off", icon:"st.samsung.da.RC_ic_power", backgroundColor:"#888888"
    }    
    standardTile("sound", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Sound', action:"sound", icon:"st.Electronics.electronics13", backgroundColor:"#888888"
    }  
    standardTile("stb", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'STB', action:"stb", icon:"st.samsung.da.RAC_ic_aircon", backgroundColor:"#888888"
    }  
    standardTile("source", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Source', action:"source", icon:"st.thermostat.heating-cooling-off"
    }
    standardTile("mute", "device.switch", decoration: "flat",  canChangeIcon: false) {
        state "default", label:'Mute', action:"mute", icon:"st.custom.sonos.muted" 
    }     
	standardTile("tools", "device.switch", decoration: "flat",  canChangeIcon: false) {
        state "default", label:'Sound Source', action:"tools", icon:"st.secondary.tools"
    }
	standardTile("menu", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Menu', action:"menu", icon:"st.vents.vent"
    }
	standardTile("HDMI", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Source', action:"HDMI", icon:"st.Electronics.electronics15"
    }
    standardTile("Sleep", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Sleep', action:"Sleep", icon:"st.Bedroom.bedroom10"
    }
    standardTile("Up", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Up', action:"Up", icon:"st.thermostat.thermostat-up"
    }
    standardTile("Down", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Down', action:"Down", icon:"st.thermostat.thermostat-down"
    }
    standardTile("Left", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Left', action:"Left", icon:"st.thermostat.thermostat-left"
    }
    standardTile("Right", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Right', action:"Right", icon:"st.thermostat.thermostat-right"
    }  
	standardTile("chup", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'CH Up', action:"chup", icon:"st.thermostat.thermostat-up"
    }
	standardTile("chdown", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'CH Down', action:"chdown", icon:"st.thermostat.thermostat-down"
    }
	standardTile("prech", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Pre CH', action:"prech", icon:"st.secondary.refresh-icon"
    }
    standardTile("volup", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Vol Up', action:"volup", icon:"st.thermostat.thermostat-up"
    }
    standardTile("voldown", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Vol Down', action:"voldown", icon:"st.thermostat.thermostat-down"
    }
    standardTile("Enter", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Enter', action:"Enter", icon:"st.illuminance.illuminance.dark"
    }
    standardTile("Return", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Return', action:"Return", icon:"st.secondary.refresh-icon"
    }
    standardTile("Exit", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Exit', action:"Exit", icon:"st.locks.lock.unlocked"
    }    
    standardTile("Info", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Info', action:"Info", icon:"st.motion.acceleration.active"
    }    
    standardTile("Size", "device.switch", decoration: "flat", canChangeIcon: false) {
        state "default", label:'Picture Size', action:"Size", icon:"st.contact.contact.open"
    }      
    main "switch"
    details (["power","stb","sound", "chup","prech","volup","chdown","mute","voldown", "HDMI", "Up", "tools", "Left", "Enter", "Right", "Return", "Down", "menu","Exit", "Info","Size","Sleep"])	
}
 
def tvAction(buttonPath) {
    log.debug settings
	if (settings."$buttonPath"){
        def path = "/code/" + settings."$buttonPath"
        //log.debug path   
		def result = new physicalgraph.device.HubAction(
				method: "GET",		/* If you want to use the RM Bridge, change the method from "POST" to "Get" */
				path: path,
				headers: [HOST: "${internal_ip}:${internal_port}"],
			)
        log.debug result
        sendHubCommand(result)
        log.debug buttonPath
	} else {
    log.debug "Undefined"
  }
}


def updated() {
 
    if (settings.internal_ip != null && settings.internal_port != null ) {
       device.deviceNetworkId = "${settings.internal_ip}:${settings.port}"
    }
}
def parse(String description) {
	return null
}

def off() {
	log.debug "Turning TV OFF"
    tvAction "POWEROFF" 
    sendEvent(name:"Command", value: "Power Off", displayed: true) 
    sendEvent(name : "switch", value : "off");
}
 
def on() {
	log.debug "Turning TV OFF"
    tvAction("POWEROFF") 
    sendEvent(name:"Command", value: "Power On", displayed: true) 
    sendEvent(name : "switch", value : "on");
}

//    log.info device.currentValue("level")


// Alexa only sends us 25 for turning up the volume 0 for turning down the volume or it sends a discrete level
// we will treat any value above 25 to increase volume under 25 to decrease volume.  there will some funky behaviour in 
// Alexa App slider but we don't care
def setLevel(val){
    if (val < 0){
    	val = 0
    }
    
    if( val > 100){
    	val = 100
    }
    
    def prevLevel = device.currentValue("level")
    log.info "setLevel $val -- prevLevel $prevLevel"
    
    if ((val > prevLevel) || ((val == prevLevel) && (val != 0))) {
      volup()
      volup()
      sendEvent(name: "switch", value: "on")
    } else {
      voldown()
      voldown()
    }
    
    
    // make sure we don't drive switches past allowed values (command will hang device waiting for it to
    // execute. Never commes back)
    sendEvent(name:"level",value:val)
    sendEvent(name:"switch.setLevel",value:val)
}

def all() {
	log.trace "all pressed"
    off()
    sound()
    stb()
}

def mute() {
	log.trace "MUTE pressed"
    tvAction("MUTE")    
}

def source() {
	log.debug "SOURCE pressed"
    tvAction("SOURCE")     
}

def menu() {
	log.debug "MENU pressed"
    tvAction("MENU") 
}

def tools() {
	log.debug "TOOLS pressed"
    tvAction("TOOLS")     
}

def HDMI() {
	log.debug "HDMI pressed"
    tvAction("HDMI")     
}

def Sleep() {
	log.debug "SLEEP pressed"
    tvAction("SLEEP")   
}

def sound() {
	log.debug "Sound pressed"
    tvAction("SOUND") 
     
}
def stb() {
	log.debug "STB pressed"
    tvAction("STB") 
     
}
def Up() {
	log.debug "UP pressed"
    tvAction("UP")
}

def Down() {
	log.debug "DOWN pressed"
    tvAction("DOWN") 
}

def Left() {
	log.debug "LEFT pressed"
    tvAction("LEFT") 
}

def Right() {
	log.debug "RIGHT pressed"
    tvAction("RIGHT") 
}

def chup() {
	log.debug "CHUP pressed"
    tvAction("CHUP")           
}

def chdown() {
	log.debug "CHDOWN pressed"
    tvAction("CHDOWN")         
}

def prech() {
	log.debug "PRECH pressed"
    tvAction("PRECH")
}

def Exit() {
	log.debug "EXIT pressed"
    tvAction("EXIT") 
}

def volup() {
	log.debug "VOLUP pressed"
    tvAction("VOLUP")         
}

def voldown() {
	log.debug "VOLDOWN pressed"
    tvAction("VOLDOWN")        
}

def Enter() {
	log.debug "ENTER pressed"
    tvAction("ENTER") 
}

def Return() {
	log.debug "RETURN pressed"
    tvAction("RETURN") 
}

def Info() {
	log.debug "INFO pressed"
    tvAction("INFO")   
}

def Size() {
	log.debug "PICTURE_SIZE pressed"
    tvAction("PICTURE_SIZE") 
}
  
