require recipes-bsp/u-boot/u-boot-fw-utils_2019.07.bb

UBOOT_SRC ?= "git://github.com/WinSystems/u-boot-imx8m.git;protocol=https"
SRCBRANCH = "v2020.04"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH} \
            file://fw_env.config \
"
SRCREV = "${AUTOREV}"


inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

do_install () {
    install -d ${D}${base_sbindir}
    install -d ${D}${sysconfdir}
    install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_printenv
    install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_setenv
    install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}
