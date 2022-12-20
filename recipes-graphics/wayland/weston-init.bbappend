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

update_file() {
    if ! grep -q "$1" $3; then
        bbfatal $1 not found in $3
    fi
    sed -i -e "s,$1,$2," $3
}

do_install:append() {
	
	install -D -p -m0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini

	install -D -p -m0644 ${WORKDIR}/71-weston-drm.rules \
                ${D}${sysconfdir}/udev/rules.d/71-weston-drm.rules
	install -D -p -m0644 ${WORKDIR}/WinSystems.png ${D}${datadir}/backgrounds/WinSystems.png

    # Add weston.log back, used by NXP for testing
    update_file "ExecStart=/usr/bin/weston " "ExecStart=/usr/bin/weston --log=\$\{XDG_RUNTIME_DIR\}/weston.log " ${D}${systemd_system_unitdir}/weston.service

    # # FIXME: weston should be run as weston, not as root
    # update_file "User=weston" "User=winsys" ${D}${systemd_system_unitdir}/weston.service
    # update_file "Group=weston" "Group=winsys" ${D}${systemd_system_unitdir}/weston.service
}

FILES_${PN} += " ${datadir}/backgrounds/WinSystems.png "
