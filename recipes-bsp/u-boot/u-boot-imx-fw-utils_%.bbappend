require recipes-bsp/u-boot/u-boot-fw-utils-mender.inc

do_install_append () {
    install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}
