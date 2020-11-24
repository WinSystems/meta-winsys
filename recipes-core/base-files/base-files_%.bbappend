FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://profile "

do_install_append() {
	rm ${D}${sysconfdir}/profile
        install -m 0644 ${WORKDIR}/profile ${D}${sysconfdir}/profile
}









