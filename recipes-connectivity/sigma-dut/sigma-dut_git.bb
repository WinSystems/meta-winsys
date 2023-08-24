SUMMARY = "Tools for WFA Sigma DUT/CA"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://README;md5=cb7b88c5098324bb9a20d2a79d76327e"
SECTION = "base"

SRC_URI = "git://github.com/qca/sigma-dut/;protocol=https;branch=github-qca/master; \
           file://0001-Add-handling-of-DYN_BW_SGNL-command-for-AP-mode.patch \
           file://0001-Add-handling-of-DYN_BW_SGNL-command-for-DRIVER_LINUX.patch \
"

SRCREV = "7c8962080f88971cf52eb4df01f0f5fe92fdec19"

S = "${WORKDIR}/git"

do_install() {
        install -d ${D}${sbindir}
        install -m 0755 ${S}/sigma_dut ${D}${sbindir}/
}
