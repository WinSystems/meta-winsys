DESCRIPTION = " Update write-key to provide rpmb block access "
SECTION = "app"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${TOPDIR}/../sources/meta-winsys/imx/COPYING;md5=ab61cab9599935bfe9f700405ef00f28"

PR = "r0"

RDEPENDS_${PN} += "bash"

SRC_URI = "file://rpmb-access"

S = "${WORKDIR}/rpmb-access"

PACKAGES = "${PN} ${PN}-dbg "

PARALLEL_MAKE = '-j 1'

inherit systemd

SYSTEMD_SERVICE_${PN} = "rpmb-access.service"

do_install() {
	install -d ${D}${sysconfdir}/
	install -m 0777 ${S}/rpmb-access.sh ${D}${sysconfdir}/.
    install -d ${D}${systemd_unitdir}/system/
    install -m 0664 ${S}/rpmb-access.service ${D}${systemd_unitdir}/system/.
}

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

FILES_${PN} += "${sysconfdir}/*"
