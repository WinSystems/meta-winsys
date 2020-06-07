DESCRIPTION = " Update Ethernet configurations to enable WOL support "
SECTION = "app"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${TOPDIR}/../sources/meta-winsys/imx/COPYING;md5=ab61cab9599935bfe9f700405ef00f28"

PR = "r0"

SRC_URI = "file://wol-support"

S = "${WORKDIR}/wol-support"

PACKAGES = "${PN} ${PN}-dbg "

PARALLEL_MAKE = '-j 1'

inherit systemd

SYSTEMD_SERVICE_${PN} = "wol-support.service"

do_install() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0664 ${S}/wol-support.service ${D}${systemd_unitdir}/system/.
}

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
