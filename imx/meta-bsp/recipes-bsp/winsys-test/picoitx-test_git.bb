DESCRIPTION = " Fetch test scripts & sample audio files from git repository "
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${TOPDIR}/../sources/meta-winsys/imx/COPYING;md5=ab61cab9599935bfe9f700405ef00f28"

SRCBRANCH = "master"
IMXTEST_SRC ?= "git://github.com/WinSystems/c444-winsys-test.git;protocol=https"
SRC_URI = "${IMXTEST_SRC};branch=${SRCBRANCH}"
SRCREV = "100e11bad02041ca20275544c113c06e1d44081f"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += "bash"
PLATFORM_mx8 = "IMX8"

PARALLEL_MAKE="-j 1"

do_install_append() {
    install -d -m 0755 ${D}/home/root/test-utility/
    cp -r ${S}/audio-files ${S}/test-scripts ${D}/home/root/test-utility/
    install -d -m 0755 ${D}/home/root/i210-flash-utility/
    cp -r ${S}/eepromaccesstool-0-7-7 ${D}/home/root/i210-flash-utility/
    install -d -m 0755 ${D}/usr/bin/
    cp ${S}/mPCIe_test_tools/emui_0d01/emui_0d01_test_tool ${D}/usr/bin/.
}

FILES_${PN} += " /home/root/* "

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
