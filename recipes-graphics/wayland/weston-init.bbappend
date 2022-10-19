FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
FILES:${PN} = "/etc/* /usr/* /home/*"
# /home 
# /etc  
# /usr  
# /home/weston 
# /etc/profile.d 
# /etc/default 
# /etc/xdg 
# /etc/udev 
# /etc/pam.d 
# /etc/profile.d/weston.sh 
# /etc/default/weston 
# /etc/xdg/weston 
# /etc/xdg/weston/weston.ini 
# /etc/udev/rules.d 
# /etc/udev/rules.d/71-weston-drm.rules 
# /etc/pam.d/weston-autologin                                                                                                                                                                                       /usr/bin                                                                                                                                                                                                          /usr/share                                                                                                                                                                                                        /usr/bin/weston-start                                                                                                                                                                                             /usr/share/backgrounds                                                                                                                                                                                            /usr/share/backgrounds/WinSystems.png 
# SRC_URI:append = "file://71-weston-drm.rules"
# SRC_URI:append = "file://weston.ini"
# SRC_URI:append = "file://WinSystems.png"

do_install:append() {
	 # rm ${D}${sysconfdir}/xdg/weston/weston.ini
	
	install -D -p -m0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
	
	# rm ${D}${sysconfdir}/udev/rules.d/71-weston-drm.rules
    
	install -D -p -m0644 ${WORKDIR}/71-weston-drm.rules \
                ${D}${sysconfdir}/udev/rules.d/71-weston-drm.rules
	install -D -p -m0644 ${WORKDIR}/WinSystems.png ${D}${datadir}/backgrounds/WinSystems.png
}


FILES_${PN} += " ${datadir}/backgrounds/WinSystems.png "
