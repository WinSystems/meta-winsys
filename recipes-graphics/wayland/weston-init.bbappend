FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://71-weston-drm.rules \
	     file://weston.ini \
	     file://WinSystems.png "

do_install_append() {
	rm ${D}${sysconfdir}/xdg/weston/weston.ini
	install -D -p -m0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
	rm ${D}${sysconfdir}/udev/rules.d/71-weston-drm.rules
        install -D -p -m0644 ${WORKDIR}/71-weston-drm.rules \
                ${D}${sysconfdir}/udev/rules.d/71-weston-drm.rules
	install -D -p -m0644 ${WORKDIR}/WinSystems.png ${D}${datadir}/backgrounds/WinSystems.png
}


FILES_${PN} += " ${datadir}/backgrounds/WinSystems.png "
