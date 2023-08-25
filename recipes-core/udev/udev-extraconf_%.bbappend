FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SUMMARY = "Changes default RTC"
DESCRIPTION = "Recipe to change rtc1 to be the default rtc in the extraconf.rule file"

SRC_URI += "file://localextra.rules "

S = "${WORKDIR}"

do_install:append () {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/localextra.rules    ${D}${sysconfdir}/udev/rules.d/localextra.rules
}

FILES:${PN} = "${sysconfdir}/udev"
RDEPENDS:${PN} = "udev"