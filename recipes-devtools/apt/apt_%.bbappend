FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
FILES:${PN} = "/var/* /usr/* /etc/*"
SRC_URI += "file://winsys-20.list"

do_install:append() {
    # rm ${D}${sysconfdir}/apt/sources.list.d/debian-10.list
    install -m 0644 ${WORKDIR}/winsys-20.list ${D}${sysconfdir}/apt/sources.list.d/
}
