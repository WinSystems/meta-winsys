FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
FILES:${PN} = "/etc/* /usr/* /home/*"
 
SRC_URI += "file://71-weston-drm.rules \
    file://weston.ini \
    file://WinSystems.png"

update_file() {
    if ! grep -q "$1" $3; then
        bbfatal $1 not found in $3
    fi
    sed -i -e "s,$1,$2," $3
}

do_install:append() {
	
	install -D -p -m0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
    install -d ${D}${sysconfdir}/udev/rules.d
	install -D -p -m0666 ${WORKDIR}/71-weston-drm.rules ${D}${sysconfdir}/udev/rules.d/71-weston-drm.rules
	install -D -p -m0644 ${WORKDIR}/WinSystems.png ${D}${datadir}/backgrounds/WinSystems.png
    
}

FILES_${PN} += " ${datadir}/backgrounds/WinSystems.png "
FILES_${PN} += "${sysconfdir}/udev"
RDEPENDS_${PN} = "udev"