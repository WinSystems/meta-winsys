SUMMARY = "EMUC Socket Can Utility"
DESCRIPTION = "Program used to communicate with the EMUC Socket CAN BUS device driver"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"


SRC_URI = " file://include/version.h \
    file://lib_emuc2_64.a \
    file://main.c \
    file://Makefile \
"


S = "${WORKDIR}"

inherit make

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 emucd_64 ${D}${bindir}
}

FILES:${PN} += "${bindir}/emucd_64"
RPROVIDES:${PN} = "emucd"